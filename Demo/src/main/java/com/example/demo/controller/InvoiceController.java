package com.example.demo.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.config.UserDetail;
import com.example.demo.config.UserDetailService;
import com.example.demo.model.DeletedInvoice;
import com.example.demo.dto.DelInvoice;
import com.example.demo.dto.EmployeeDto;
import com.example.demo.dto.FeedbackDto;
import com.example.demo.dto.InvoiceDto;
//import saleinventory.management.system.config.UserDetailService;
import com.example.demo.model.*;
import com.example.demo.service.CategoryService;
import com.example.demo.service.DelInvoiceService;
import com.example.demo.service.InvoiceDetailService;
import com.example.demo.service.InvoiceService;
import com.example.demo.service.ReceiptService;
import com.example.demo.service.UserService;
import com.example.demo.service.WarehouseService;

@Controller
public class InvoiceController {
	@Autowired
	InvoiceService invoiceService;
	@Autowired
	ReceiptService receiptService;
	@Autowired
	InvoiceDetailService invoiceDetailService;
	@Autowired
	UserDetailService userService;
	@Autowired
	WarehouseService wareService;
	@Autowired
	DelInvoiceService delSer;

	static ArrayList<InvoiceDto> listProduct = new ArrayList<>();

	@GetMapping("/createbill")
	public String createBill(Model model) {
		model.addAttribute("bill", new InvoiceDto());
		
		
		listProduct.removeAll(listProduct);
		return "createbill";
	}

	@GetMapping("/invoicesSale")
	public String historyWarehouse(Model model, HttpServletRequest request) {
		int page = 0;
		if (request.getParameter("p") != null && !request.getParameter("p").isEmpty()) {
			page = Integer.parseInt(request.getParameter("p")) - 1;
		}
		if (!model.containsAttribute("deletedInvoice")) {
			model.addAttribute("deletedInvoice", new DelInvoice());
		}
		Page<Invoice> l = invoiceService.findAll(page);
		int totalPage = l.getTotalPages();
		int begin = Math.max(1, (page + 1) - totalPage);
		model.addAttribute("totalPage", totalPage);
		model.addAttribute("currentIndex", l.getNumber() + 1);
		model.addAttribute("beginIndex", begin);
		model.addAttribute("endIndex", Math.min(begin + 5, totalPage));
		model.addAttribute("listInvoi", l);
		return "invoicesSale";
	}

	@RequestMapping("/getInvoices")
	@ResponseBody
	public List<Object> getInvoices(Model modal, @RequestParam("idInvoice") String idInvoice) {
		List<InvoiceDetail> ld = invoiceDetailService.getById(idInvoice);
		Invoice iv = invoiceService.getOne(idInvoice);
		System.out.println(idInvoice);
		List<Object> objs = new ArrayList<>();
		objs.add(ld);
		objs.add(iv.getStatus());
		return objs;
	}

	@PostMapping("/createInvoice")
	public String exportInvoice(@ModelAttribute("bill") InvoiceDto iDto, Model model) {
		long totalBill = 0;
		System.out.println("CTHD " + iDto.toString() + " ");
		long price = Long.parseLong(iDto.getPrice().trim());

		int update = 0;
		if (listProduct.size() > 0) {
			for (int i = 0; i < listProduct.size(); i++) {
				System.out.println("step " + iDto.getIdProduct() + " " + listProduct.get(i).getIdProduct());
				if (iDto.getIdProduct().trim().equals(listProduct.get(i).getIdProduct().trim())) {

					int newQuan = (Integer.parseInt(listProduct.get(i).getQuantity().trim())
							+ Integer.parseInt(iDto.getQuantity().trim()));
					listProduct.get(i).setQuantity(newQuan + " ");
					listProduct.get(i).setTotal((price * newQuan) + " ");
					break;
				} else {
					update++;
				}
			}
			if (update == listProduct.size()) {
				iDto.setTotal((price * Integer.parseInt(iDto.getQuantity().trim())) + " ");
				listProduct.add(iDto);
			}
		} else {
			iDto.setTotal((price * Integer.parseInt(iDto.getQuantity().trim())) + " ");
			listProduct.add(iDto);
		}

		for (InvoiceDto invoiceDto : listProduct) {
			totalBill += Long.parseLong(invoiceDto.getTotal().trim());
		}
		System.out.println("listProduct " + listProduct.size());
		model.addAttribute("listProduct", listProduct);
		model.addAttribute("totalBill", totalBill);
		return "createbill";
	}

	@PostMapping("/saveInvoice")
	public String save(Authentication authenticaton, Model model) {
		// get info of user
		UserDetail user = (UserDetail) authenticaton.getPrincipal();
		User u = userService.findByName(user.getUsername());
		// get date current
		Date date = Calendar.getInstance().getTime();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-hh.mm.ss");
		String day = dateFormat.format(date);
		day = day.trim();
		long money = 0;
		for (InvoiceDto invoiceDto : listProduct) {
			money += Long.parseLong(invoiceDto.getTotal().trim());
		}
		Invoice invoice = new Invoice(invoiceService.randomId(3000, day), u.getId_user(), money, 0, 0, day, 1);
		invoiceService.addInvoice(invoice);
		for (InvoiceDto invoiceDto : listProduct) {
			InvoiceDetail iDetail = new InvoiceDetail(new InvoiceId(invoice.getIdInvoice(), invoiceDto.getIdProduct()),
					Integer.parseInt(invoiceDto.getQuantity().trim()), Long.parseLong(invoiceDto.getPrice().trim()), 0);
			System.out.println(iDetail.toString());
			invoiceDetailService.addInvoiceDetail(iDetail);
		}
		model.addAttribute("bill", new InvoiceDto());
		listProduct = null;
		return "createbill";
	}



	@PostMapping("/delete")
	public String deleteInvoice(@ModelAttribute("deletedInvoice") DelInvoice deDto) {
		// get date current
		Date date = Calendar.getInstance().getTime();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-hh.mm.ss");
		String day = dateFormat.format(date);
		day = day.trim();
		System.out.println("DELETE "+ deDto.toString());
		DeletedInvoice d = new DeletedInvoice(deDto.getId(), deDto.getReason(),  day);
		delSer.save(d);
		invoiceService.delete(d.getId(), 4);
		return "redirect:/invoicesSale";
	}

	@GetMapping("/pending")
	@ResponseBody
	public int pending(Model model, @RequestParam("idWare") int idWare, @RequestParam("idProduct") String idProduct,
			@RequestParam("q") int quantity, @RequestParam("inv") String idInvoice) {
		if (!model.containsAttribute("invoice")) {
			model.addAttribute("invoice", new InvoiceDto());
		}
		Invoice iv = invoiceService.getOne(idInvoice);
		int mess = wareService.buyProduct(new WarehouseId(idWare, idProduct), quantity, idInvoice);
		if (iv.getStatus() == 0) {// trang thai hoa don chua dc duyet

			List<InvoiceDetail> ld = invoiceDetailService.getById(idInvoice);
			int d = 0;
			for (InvoiceDetail invoiceDetail : ld) {
				if (invoiceDetail.getStatus() == 0) {
					d++;
				}
			}
			System.out.println("dem" + d);
			if (d == 0 && mess == 0) {

				iv.setStatus(3);
			} else {
				iv.setStatus(0);
			}
			invoiceService.addInvoice(iv);

		}
		return mess;

	}


}

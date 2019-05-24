package com.example.demo.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.example.demo.dto.InvoiceDto;
//import saleinventory.management.system.config.UserDetailService;
import com.example.demo.model.*;
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
	UserService userService;
	@Autowired
	WarehouseService wareService;
	static ArrayList<InvoiceDto> listProduct = new ArrayList<>();
	static long totalBill = 0;

	@ModelAttribute("bill")
	public InvoiceDto createBill() {
		return new InvoiceDto();
	}

	@GetMapping("/invoicesSale")
	public String historyWarehouse(Model modal) {
		List<Invoice> l = invoiceService.findAll();

		modal.addAttribute("listInvoi", l);
		return "invoicesSale";
	}

	@RequestMapping("/getInvoices")
	@ResponseBody
	public List<InvoiceDetail> getInvoices(Model modal, @RequestParam("idInvoice") String idInvoice) {
		List<InvoiceDetail> ld = invoiceDetailService.getById(idInvoice);
		System.out.println(idInvoice);
		modal.addAttribute("ld", ld);
		return ld;
	}

	@PostMapping("/createInvoice")
	public String exportInvoice(@ModelAttribute("bill") List<InvoiceDto> iDto, Model model) {
System.out.println("CTHD "+iDto.toString()+" "+ iDto.size());
//		long price = Long.parseLong(iDto.getPrice().trim());
//
//		int update = 0;
//		if (listProduct.size() > 0) {
//			for (int i = 0; i < listProduct.size(); i++) {
//				if (iDto.getIdProduct().trim().equals(listProduct.get(i).getIdProduct().trim())) {
//					listProduct.get(i).setQuantity((Integer.parseInt(listProduct.get(i).getQuantity().trim())
//							+ Integer.parseInt(iDto.getQuantity().trim())) + " ");
//					listProduct.get(i)
//							.setTotal((price * Integer.parseInt(listProduct.get(i).getQuantity().trim())) + " ");
//					update = 1;
//					break;
//				}
//			}
//		} else {
//			iDto.setTotal((price * Integer.parseInt(iDto.getQuantity().trim())) + " ");
//			listProduct.add(iDto);
//			update = 1;
//		}
//		if (update == 0) {
//			listProduct.add(iDto);update = 1;
//		}

		for (InvoiceDto invoiceDto : listProduct) {
			totalBill += Long.parseLong(invoiceDto.getTotal().trim());
		}
		System.out.println(listProduct.size());
		model.addAttribute("listProduct", listProduct);
		model.addAttribute("totalBill", totalBill);
		return "redirect:/createbill";
	}

	@GetMapping("/saveInvoice")
	public String save(Authentication authenticaton) {
		UserDetail user = (UserDetail) authenticaton.getPrincipal();
		User u = userService.findByName(user.getUsername());
		long money = 0;
		for (InvoiceDto invoiceDto : listProduct) {
			money += Long.parseLong(invoiceDto.getTotal().trim());
		}
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy ");
		Date date = new Date();
		Invoice invoice = new Invoice("12", u.getId_user(), money, 0, 0, formatter.format(date), 1);
		invoiceService.addInvoice(invoice);
		for (InvoiceDto invoiceDto : listProduct) {
			InvoiceDetail iDetail = new InvoiceDetail(new InvoiceId(invoice.getIdInvoice(), invoiceDto.getIdProduct()),
					Integer.parseInt(invoiceDto.getQuantity().trim()), Long.parseLong(invoiceDto.getPrice().trim()), 0);
			System.out.println(iDetail.toString());
			invoiceDetailService.addInvoiceDetail(iDetail);
		}
		return "createbill";
	}

	@PutMapping("/edit")
	public void adjustInvoice(@RequestParam("idInvoice") String idInvoice) {
//		invoiceService.addInvoice(in);
//		receiptService.save(r);

	}

	@GetMapping("/delete")
	public String deleteInvoice(@RequestParam("idInvoice") String idInvoice) {
		invoiceService.delete(idInvoice, 4);
		return "redirect:/invoicesSale";
	}

	@GetMapping("/pending")
	@ResponseBody
	public int pending(Model model, @RequestParam("idWare") int idWare, @RequestParam("idProduct") String idProduct,
			@RequestParam("q") int quantity, @RequestParam("inv") String idInvoice) {
		List<InvoiceDetail> ld = invoiceDetailService.getById(idInvoice);
		System.out.println("dinh "+ idWare+" "+ idProduct+" "+ quantity+" "+ idInvoice);
		int mess=wareService.buyProduct(new WarehouseId(idWare, idProduct), quantity, idInvoice);
		System.out.println("server "+ mess);
		int d = 0;
		for (InvoiceDetail invoiceDetail : ld) {
			if (invoiceDetail.getStatus() == 0) {
				d++;
			}
		}
		System.out.println("dem"+d);
		if (d == 0) {
			Invoice iv = invoiceService.getOne(idInvoice);
			iv.setStatus(3);
			invoiceService.addInvoice(iv);
		}else {
			Invoice iv = invoiceService.getOne(idInvoice);
			iv.setStatus(0);
			invoiceService.addInvoice(iv);
		}
//		model.addAttribute("mess", mess);
		return mess;

	}
}

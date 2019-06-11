package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.dto.StaticDto;
import com.example.demo.model.CategoryProduct;
import com.example.demo.model.InformationWarehouse;
import com.example.demo.service.CategoryService;
import com.example.demo.service.InforWareService;
import com.example.demo.service.InvoiceService;
import com.example.demo.service.ProductService;

@Controller
public class IWController {
	@Autowired
	InforWareService inforWareService;
	@Autowired
	InvoiceService invoiceService;
	@Autowired
	CategoryService cateService;
	@Autowired
	ProductService productService;

	@GetMapping("/")
	public String getListIW(Model model) {
		List<InformationWarehouse> listIWa = inforWareService.findAll();
		model.addAttribute("listIWa", listIWa);
		int countBill = invoiceService.getQuantityInvoice();
		long sumMonney = invoiceService.getSumMoney();
		int deleteBill = invoiceService.getDeletedInvoice();
		int itemReturned = invoiceService.getItemReturned();
		System.out.println(countBill);
		System.out.println(sumMonney);
		System.out.println(deleteBill);
		System.out.println(itemReturned);
		model.addAttribute("getInvoiceInDay", countBill);
		model.addAttribute("getSumMoneyInDay", sumMonney);
		model.addAttribute("getDeletedInvoice", deleteBill);
		model.addAttribute("getItemReturned", itemReturned);
		List<CategoryProduct> listItem = cateService.getList();
		model.addAttribute("listItem", listItem);
		// static default
			List<Object> results = productService.getTrends(2019, "1");
			model.addAttribute("results", results);
//			System.out.println("static "+ results.size());
		
		return "index";
	}
	@PostMapping("/getTrends")
	@ResponseBody
	public List<Object> getTopTrends(Model model,@PathVariable("year") int year, @PathVariable("item") String item) {
//		if(year==0 && item==null) {
//			List<Object> results = productService.getTrends(2019, "1");
//		}
//		List<Object> results = productService.getTrends(year, item);
		return null;
	}
}

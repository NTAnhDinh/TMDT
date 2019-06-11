package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.Warehouse;
import com.example.demo.service.WarehouseService;

@Controller
public class WarehouseController {
	@Autowired
	WarehouseService warehouseService;
	@GetMapping("/warehouse")
	public String getAll(Model model, @RequestParam(name = "p", defaultValue = "1") int page) {
		Page<Warehouse> l =warehouseService.getList(page-1);
		model.addAttribute("wares",l);
//		System.out.println(warehouseService.getList().size());
		int totalPage = l.getTotalPages();
		int begin = Math.max(1, (page ) - totalPage);
		model.addAttribute("totalPage", totalPage);
		model.addAttribute("currentIndex", l.getNumber() + 1);
		model.addAttribute("beginIndex", begin);
		model.addAttribute("endIndex", Math.min(begin + 5, totalPage));
		return "warehouse";
	}
}

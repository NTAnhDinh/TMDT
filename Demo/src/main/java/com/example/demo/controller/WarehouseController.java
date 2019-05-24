package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.model.Warehouse;
import com.example.demo.service.WarehouseService;

@Controller
public class WarehouseController {
	@Autowired
	WarehouseService warehouseService;
	@GetMapping("/warehouse")
	public String getAll(Model model) {
		model.addAttribute("wares",warehouseService.getList());
		List<Warehouse> l =warehouseService.getList();
		for (Warehouse warehouse : l) {
			System.out.println(warehouse.toString());
		}
		System.out.println(warehouseService.getList().size());
		return "warehouse";
	}
}

package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.model.InformationWarehouse;
import com.example.demo.service.InforWareService;

@Controller
public class IWController {
	@Autowired
	InforWareService inforWareService;

	@GetMapping("/historyWarehouse")
	public String getListIW(Model model) {
		List<InformationWarehouse> listIWa = inforWareService.findAll();
		model.addAttribute("listIWa", listIWa);
		return "historyWarehouse";
	}
}

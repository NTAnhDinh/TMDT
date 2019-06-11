package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainController {
	
	
	
	
	@GetMapping("/login")
	public String loginSucees() {

		return "login";
	}

	@GetMapping("/logout")
	public String logout() {

		return "redirect:/login";
	}



	@GetMapping("/inventoryTrends")
	public String inventoryTrends() {
		return "InventoryTrends";
	}

	

	@GetMapping("/InvenManager")
	public String I1() {
		return "sidebar/InvenManager";
	}



//	@GetMapping("/SaleMana")
//	public String I3() {
//		return "sidebar/SaleMana";
//	}

//	@GetMapping("/sidebarAdmin")
//	public String I4() {
//		return "sidebar/sidebarAdmin";
//	}
	@GetMapping("/sidebar/admin")
	public String a() {
		return "sidebar/sidebarAdmin";
	}
	@GetMapping("/sale")
	public String sale() {

		return "sidebar/sale";
	}
	
}

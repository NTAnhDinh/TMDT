package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainController {
	@GetMapping("/")
	public String index() {
		return "index";
	}

	
//	@GetMapping("/warehouse")
//	public String statusInventorySale() {
//		return "warehouse";
//	}

	@GetMapping("/login")
	public String loginSucees(String login) {

		return "login";
	}

	@GetMapping("/createbill")
	public String createBill() {
		return "createbill";
	}



	@GetMapping("/inventoryTrends")
	public String inventoryTrends() {
		return "InventoryTrends";
	}

	@GetMapping("/template")
	public String template() {
		return "template";
	}

	@GetMapping("/I1")
	public String I1() {
		return "sidebar/InvenManager";
	}



	@GetMapping("/I3")
	public String I3() {
		return "sidebar/SaleMana";
	}

	@GetMapping("/I4")
	public String I4() {
		return "sidebar/sidebarAdmin";
	}

	@GetMapping("/sale")
	public String sale() {

		return "sale2";
	}
	
}

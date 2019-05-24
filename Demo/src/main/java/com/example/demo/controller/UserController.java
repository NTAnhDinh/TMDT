package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.demo.config.UserDetail;
import com.example.demo.model.Product;
import com.example.demo.model.User;
import com.example.demo.service.UserService;
@Controller
public class UserController {
	@Autowired
	UserService userService;
//	
////	
////	@PostMapping("/login")
////	public String login(Model model, String error, String logout) {
////		if (error != null)
////			model.addAttribute("error", "Your username and password is invalid.");
////
////		if (logout != null)
////			model.addAttribute("logout", "You have been logged out successfully.");
////
////		return "login";
////	}
//
//	@PostMapping("/changePassword")
//	public void updatePassword(@RequestParam("oldPassword") String oldPassword,
//			@RequestParam("newPassword") String newPassword, @RequestParam("rePassword") String rePassword,
//			Model model) {
//		String error = "";
//		User user = userService.findByPassword(oldPassword);
//		if (user == null) {
//			error = "";
//		} else {
//			if (newPassword.equals(rePassword))
//				userService.updatePassword(newPassword);
//			else {
//				error = "";
//			}
//		}
//		model.addAttribute("error", error);
//	}
//	
//	
	
	@GetMapping("/getRole")
	
	public List<User> getRole() {
		return userService.findByIdRole();
	}
}

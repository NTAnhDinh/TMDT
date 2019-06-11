package com.example.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.config.UserDetail;
import com.example.demo.config.UserDetailService;
import com.example.demo.dto.EmployeeDto;
import com.example.demo.dto.ProductDto;
import com.example.demo.model.Product;
import com.example.demo.model.Role;
import com.example.demo.model.User;
import com.example.demo.service.RoleService;
import com.example.demo.service.UserService;
import com.example.demo.validator.UserValidator;

@Controller
public class UserController {
	@Autowired
	UserDetailService userService;
	@Autowired
	RoleService roleService;
	@Autowired
	private UserValidator userValidator;


	@GetMapping("/getRole")

	public List<User> getRole() {
		return userService.findByIdRole();
	}

	@GetMapping("/employee")
	public String employeeAdmin(Model model) {
		model.addAttribute("users", userService.findAll());
		if (!model.containsAttribute("employDto")) {
			model.addAttribute("employDto", new EmployeeDto());
		}
		List<Role> roles = roleService.findAll();
		model.addAttribute("roles", roles);
		List<User> listU = userService.findByIdRole();
		model.addAttribute("listU", listU);
		return "employee";
	}

	@PostMapping("/createEmployee")
	public String save(@ModelAttribute("employDto") EmployeeDto employee, BindingResult bindingResult, Model model,
			RedirectAttributes ra) {
		String message = "";
		userValidator.validate(employee, bindingResult);
		if (bindingResult.hasErrors()) {
			System.out.println("validate");
			ra.addFlashAttribute("org.springframework.validation.BindingResult.employDto", bindingResult);
			ra.addFlashAttribute("employDto", employee);
			return "redirect:/employee";
		} else {
			System.out.println("UserController " + employee.toString());
			User u = new User();
			u.setIdRole(Integer.parseInt(employee.getIdRole()));
			u.setName(employee.getUsername());
			u.setPassword(employee.getPassword());
			u.setStatus(1);
			u.setRole(roleService.getById(Integer.parseInt(employee.getIdRole())));
			userService.save(u);
			message = "Success!";
			ra.addFlashAttribute("mess", message);
			return "redirect:/employee";
		}
	}
}

package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.config.UserDetail;
import com.example.demo.dto.FeedbackDto;
import com.example.demo.model.Feedback;
import com.example.demo.model.User;
import com.example.demo.service.FeedbackService;
import com.example.demo.service.UserService;

@Controller
public class FeedbackController {
	@Autowired
	FeedbackService feedbackService;
	@Autowired
	UserService userService;
	
	@GetMapping("/reportException")
	public String reportException(Model model) {
		List<User> listU=	userService.findByIdRole();
		model.addAttribute("listU", listU);
		return "reportException";
	}
	@PostMapping("/createFeedback")
	public String createFeedback(@ModelAttribute("feedback") FeedbackDto feDto, Model model,
			Authentication authenticaton) {
		System.out.println(feDto.getContentException());
		UserDetail user = (UserDetail) authenticaton.getPrincipal();
		System.out.println(feDto.toString());
		User u = userService.findByName(user.getUsername());
		Feedback feedback = new Feedback(1, feDto.getReportType(), u.getId_user(), feDto.getExceptionsSe(), feDto.getDate(),
				feDto.getContentException(), 1);
		feedbackService.save(feedback);
		return "redirect:/reportException";
	}
}

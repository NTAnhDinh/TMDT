package com.example.demo.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.config.UserDetail;
import com.example.demo.config.UserDetailService;
import com.example.demo.dto.EmployeeDto;
import com.example.demo.dto.FeedbackDto;
import com.example.demo.dto.InvoiceDto;
import com.example.demo.model.Feedback;
import com.example.demo.model.Product;
import com.example.demo.model.User;
import com.example.demo.model.Warehouse;
import com.example.demo.service.FeedbackService;
import com.example.demo.service.ProductService;
import com.example.demo.service.UserService;
import com.example.demo.service.WarehouseService;

@Controller
public class FeedbackController {
	@Autowired
	FeedbackService feedbackService;
	@Autowired
	UserDetailService userService;
	@Autowired
	WarehouseService wareService;
	@Autowired
	ProductService proService;

	@GetMapping("/reportException")
	public String reportException(Model model, @ModelAttribute("invoice") InvoiceDto In) {
		if (!model.containsAttribute("feedback")) {
			model.addAttribute("feedback", new FeedbackDto());
		}
		List<User> listU = userService.findByIdRole();
		List<InvoiceDto> inDto = new ArrayList<InvoiceDto>();
		if (In != null) {
			String nameStr = In.getNameProduct();
			String quanStr = In.getQuantity();
			if (nameStr != null && quanStr != null) {
				Pattern pattern = Pattern.compile(",");
				String[] names = pattern.split(nameStr);
				String[] quans = pattern.split(quanStr);
				for (int i = 0; i < quans.length; i++) {
					InvoiceDto d = new InvoiceDto(names[i], quans[i]);
					inDto.add(d);
				}
				for (int j = 0; j < inDto.size(); j++) {

					Product p = proService.findByNameProduct(inDto.get(j).getNameProduct());
					Warehouse w = wareService.getByIdProduct(p.getIdProduct());
					if (w.getStatus() == 0) {
						inDto.remove(j);
					}
				}
			}
			model.addAttribute("listU", listU);
			model.addAttribute("inDto", inDto);
			System.out.println("Feedback " + inDto.toString());
			return "reportException";

		} else {
			System.out.println("feedBack");
			return "createbill";
		}
	}

	@PostMapping("/createFeedback")
	public String createFeedback(@ModelAttribute("feedback") FeedbackDto feDto,
			@RequestParam("nameProduct") String nameProduct, @RequestParam("quantity") String quantity, Model model,
			Authentication authenticaton) {

		UserDetail user = (UserDetail) authenticaton.getPrincipal();
		System.out.println(feDto.toString());
		String content = "";
		if (nameProduct != null && quantity != null) {
			Pattern pattern = Pattern.compile(",");
			String[] names = pattern.split(nameProduct);
			String[] quans = pattern.split(quantity);

			for (int i = 0; i < quans.length; i++) {
				
				content += "Name of product :" + names[i] + " , requested quantity : " + quans[i] + " \r";
			}
		}
		User u = userService.findByName(user.getUsername());
		Feedback feedback = new Feedback( feDto.getReportType(), u.getId_user(), feDto.getExceptionsSe(),
				feDto.getDate(), content, 0);
		feedbackService.save(feedback);
		return "redirect:/reportException";
	}

	@GetMapping("/reportInvenMana")
	public String reportInvenMana(@RequestParam(name = "p", defaultValue = "1") int page, Model model) {
		Page<Feedback> feeds = feedbackService.getAll(page - 1);
		System.out.println("phong " + feeds.iterator().next().toString());
		model.addAttribute("feeds", feeds);
		int totalPage = feeds.getTotalPages();
		int begin = Math.max(1, (page) - totalPage);
		model.addAttribute("totalPage", totalPage);
		model.addAttribute("currentIndex", feeds.getNumber() + 1);
		model.addAttribute("beginIndex", begin);
		model.addAttribute("endIndex", Math.min(begin + 5, totalPage));
		return "reportInvenMana";
	}

	@PostMapping("/getFeedback")
	@ResponseBody
	public Feedback getFeedback(@RequestParam("idFeed") int idFeed) {
		return feedbackService.getFeedback(idFeed);
	}

	@PostMapping("/markHandle")
	@ResponseBody
	public void handle(@RequestParam("status") String status, @RequestParam("id") String id) {
		Feedback f = feedbackService.getFeedback(Integer.parseInt(id));
		if (Integer.parseInt(status) == 1) {
			f.setStatus(1);

		}
		if (Integer.parseInt(status) == 0) {
			f.setStatus(0);

		}
		feedbackService.save(f);
	}
}

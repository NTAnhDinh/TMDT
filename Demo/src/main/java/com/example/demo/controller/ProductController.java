package com.example.demo.controller;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.dto.ProductDto;
import com.example.demo.model.CategoryProduct;
import com.example.demo.model.Product;
import com.example.demo.service.CategoryService;
import com.example.demo.service.ProductService;
import com.example.demo.validator.InvoiceValidator;
import com.example.demo.validator.ProductValidator;

@Controller
public class ProductController {

	@Autowired
	ProductService productService;
	@Autowired
	CategoryService cateService;
	@Autowired
	ProductValidator productVali;
	@Autowired
	InvoiceValidator invVali;

	@GetMapping("/searchProduct")
	@ResponseBody
	public List<Object> search(@RequestParam(value = "nameProduct") String keyword) {
		List<Product> results = new ArrayList<>();
		List<Object> result = new ArrayList<>();
		results.add(productService.findByNameProduct(keyword));
		if ( results.get(0)==null) {
			result.add(1);
		} else {
			result.add(0);
			
		}
		result.add(results.get(0));
		return result;
	}

	@GetMapping("/searchProduct2")
	@ResponseBody
	public List<String> searchProduct(@RequestParam(value = "inputNameproduct") String keyword) {
		System.out.println(keyword);
		return productService.searchProduct(keyword);
	}

	@RequestMapping("/getProduct")
	@ResponseBody
	public Product getProduct(@RequestParam("idProduct") String idProduct, Model model) {
		System.out.println(idProduct);
		Product product = productService.findByIdProduct(idProduct);
		model.addAttribute("product", product);
		return product;
	}

	@GetMapping("/stockAdmin")

	public String stockAdmin(Model model, @RequestParam(name = "p", defaultValue = "1") int page) {
		if (!model.containsAttribute("proDto")) {
			model.addAttribute("proDto", new ProductDto());
		}
		System.out.println("page" + page);
		Page<Product> listProducts = productService.getList(page - 1);
		int totalPage = listProducts.getTotalPages();

		int begin = Math.max(1, (page) - totalPage);
		model.addAttribute("listProducts", listProducts);
		List<CategoryProduct> listCate = new ArrayList<>();
		listCate.addAll(cateService.getList());
		model.addAttribute("listCate", listCate);
		model.addAttribute("totalPage", totalPage);
		model.addAttribute("currentIndex", listProducts.getNumber() + 1);
		model.addAttribute("beginIndex", begin);
		model.addAttribute("endIndex", Math.min(begin + 5, totalPage));

		return "stockAdmin";
	}

	@RequestMapping(value = "/updatePrice")
	public String editPrice(@RequestParam("idProduct") String idProduct, @RequestParam("nPrice") long price) {
		System.out.println("f " + idProduct + " " + price);
		productService.updatePrice(price, idProduct);
		return "redirect:/stockAdmin";
	}

	@PostMapping(value = "/saveProduct")
	public String uploadFile(@ModelAttribute("proDto") ProductDto proDto, BindingResult binding,
			RedirectAttributes rd) {
		productVali.validate(proDto, binding);
		if (binding.hasErrors()) {
			rd.addFlashAttribute("org.springframework.validation.BindingResult.proDto", binding);
			rd.addFlashAttribute("proDto", proDto);
			return "redirect:/stockAdmin";
		}

		System.out.println("image " + proDto.getMyfile().getOriginalFilename());
		Date date = Calendar.getInstance().getTime();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-hh.mm.ss");
		String day = dateFormat.format(date);
		day = day.trim();
		System.out.println("daycur " + day + " " + date);
		Product product = new Product(productService.randomId(500, day), proDto.getCategory(), proDto.getProductName(),
				proDto.getSuppliers(), proDto.getPrice(), 0);
		productService.save(product, proDto.getMyfile().getOriginalFilename());

		return "redirect:/stockAdmin";
	}

}

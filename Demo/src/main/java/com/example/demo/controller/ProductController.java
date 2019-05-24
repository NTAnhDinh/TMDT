package com.example.demo.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.dto.EditPrice;
import com.example.demo.dto.ProductDto;
import com.example.demo.model.CategoryProduct;
import com.example.demo.model.Product;
import com.example.demo.service.CategoryService;
import com.example.demo.service.ProductService;

@Controller
public class ProductController {

	@Autowired
	ProductService productService;
	@Autowired
	CategoryService cateService;

//	
//	@PostMapping("/getProduct")
//	public  Product getProduct(@RequestParam(value = "nameProduct") String nameProduct) {
//		Product product =productService.findByNameProduct(nameProduct);
//		return product;
//	}
	@GetMapping("/searchProduct")
	@ResponseBody
	public List<Product> search(@RequestParam(value = "nameProduct") String keyword) {
		System.out.println(keyword);
		return productService.search(keyword);
	}

	@GetMapping("/searchProduct2")
	@ResponseBody
	public List<String> searchProduct(@RequestParam(value = "inputNameproduct") String keyword) {
		System.out.println(keyword);
		return productService.searchProduct(keyword);
	}
	@GetMapping("/getListProduct")
	@ResponseBody
	public Page<Product> getListProduct(@RequestParam("p")int page) {
		Page<Product> listProducts =productService.getList(page);
		return listProducts;
	}
	@RequestMapping("/getProduct")
	@ResponseBody
	public Product getProduct(@RequestParam("idProduct")String idProduct, Model model) {
		System.out.println(idProduct);
		Product product=productService.findByIdProduct(idProduct);
		model.addAttribute("product", product);
		return product;
	}
	@GetMapping("/stockAdmin")

	public String stockAdmin(Model model) {
		Page<Product> listProducts =productService.getList(0);
		int totalPage=listProducts.getTotalPages();
		int begin=Math.max(listProducts.getNumber()+1,totalPage);
		model.addAttribute("listProducts", listProducts);
		List<CategoryProduct> listCate = new ArrayList<>();
		listCate.addAll(cateService.getList());
		model.addAttribute("listCate", listCate);
		model.addAttribute("totalPage", totalPage);
		model.addAttribute("currentIndex", listProducts.getNumber());
		model.addAttribute("beginIndex", begin);
		model.addAttribute("endIndex", Math.min(begin+5,totalPage ));
		System.out.println("currentIndex"+ listProducts.getNumber());
		return "stockAdmin";
	}
	@RequestMapping(value="/updatePrice")
	public String editPrice(@RequestParam("idProduct") String idProduct,@RequestParam("nPrice") String price
		) {
		System.out.println("f "+idProduct+" "+ price);
		productService.updatePrice(Long.parseLong(price), idProduct);
		return "redirect:/stockAdmin";
	}

	@PostMapping(value = "/saveProduct")
	public String uploadFile(Model model, @ModelAttribute("proDto") ProductDto proDto) {
		System.out.println(proDto.toString());
		try {
			MultipartFile multipartFile = proDto.getMyfile();
			String fileName = multipartFile.getOriginalFilename();
			File f = new File(this.getFolderUpload(), fileName);
			System.out.println(fileName + " " + f.getAbsolutePath());
			multipartFile.transferTo(f);

		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("message", "Upload failed");
		}

		Product product = new Product("qq", proDto.getCategory(), proDto.getProductName(), proDto.getSuppliers(),
				Long.parseLong(proDto.getPrice()), 0);
		productService.save(product);
		return "redirect:/stockAdmin";
	}

	public File getFolderUpload() {
		File folderUpload = new File("D:/CodeJAVA/Test/Demo/src/main/resources/static/imgs");
		if (!folderUpload.exists()) {
			folderUpload.mkdirs();
		}
		return folderUpload;
	}
}

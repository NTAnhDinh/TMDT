package com.example.demo.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.example.demo.dto.InvoiceDto;
import com.example.demo.model.Product;
import com.example.demo.service.ProductService;

@Component
public class InvoiceValidator implements Validator {
	@Autowired
	ProductService productService;

	@Override
	public boolean supports(Class<?> clazz) {
		return false;
	}

	@Override
	public void validate(Object o, Errors errors) {
//		InvoiceDto i = (InvoiceDto) o;
//		Product product = productService.findByNameProduct(i.getNameProduct());
//		if(product.equals(null)) {
//			errors.rejectValue("nameProduct", "NotFound");
//		}

	}

}

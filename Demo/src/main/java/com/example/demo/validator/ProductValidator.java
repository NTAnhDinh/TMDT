package com.example.demo.validator;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.example.demo.dto.ProductDto;
import com.example.demo.model.CategoryProduct;
import com.example.demo.service.CategoryService;

@Component
public class ProductValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return ProductDto.class.equals(clazz);
	}

	@Override
	public void validate(Object o, Errors errors) {
		ProductDto product = (ProductDto) o;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "productName", "NotEmpty");
		if ("".equals(product.getCategory()) || product.getCategory().equals(null)) {
			errors.rejectValue("category", "NotEmpty");
		}

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "suppliers", "NotEmpty");
		if (product.getPrice() < 100) {
			errors.rejectValue("price", "product.priceMin");
		}
		if (product.getPrice() > 100000000) {
			errors.rejectValue("price", "product.priceMax");
		}
		if (product.getMyfile().isEmpty()) {
			errors.rejectValue("myfile", "File is empty");
		}
		if ( product.getMyfile().getSize() == 0) {
			errors.rejectValue("files", "missing.file");
		}
		
	}

}

package com.example.demo.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.web.multipart.MultipartFile;

public class ProductDto implements Serializable{
	String productName;
	String category;
	String suppliers;
	long price;
	MultipartFile myfile;

	public ProductDto(String productName, String category, String suppliers, long price, MultipartFile myfile) {
		super();
		this.productName = productName;
		this.category = category;
		this.suppliers = suppliers;
		this.price = price;
		this.myfile = myfile;
	}

	public ProductDto() {
	}

	public MultipartFile getMyfile() {
		return myfile;
	}

	public void setMyfile(MultipartFile myfile) {
		this.myfile = myfile;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getSuppliers() {
		return suppliers;
	}

	public void setSuppliers(String suppliers) {
		this.suppliers = suppliers;
	}

	

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "ProductDto [productName=" + productName + ", category=" + category + ", suppliers=" + suppliers
				+ ", price=" + price + "]";
	}

}

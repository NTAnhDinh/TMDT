package com.example.demo.dto;

import org.springframework.web.multipart.MultipartFile;

public class ProductDto {
 String productName;
 String category;
 String suppliers;
 String price;
MultipartFile  myfile;


public ProductDto(String productName, String category, String suppliers, String price, MultipartFile myfile) {
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
public String getPrice() {
	return price;
}
public void setPrice(String price) {
	this.price = price;
}

@Override
public String toString() {
	return "ProductDto [productName=" + productName + ", category=" + category + ", suppliers=" + suppliers + ", price="
			+ price + "]";
}


}

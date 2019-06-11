package com.example.demo.dto;

public class InvoiceDto {
String nameProduct;
String quantity;
String idProduct;
String price;
String total;
String status;
public InvoiceDto(String nameProduct, String quantity, String idProduct, String price, String total) {
	super();
	this.nameProduct = nameProduct;
	this.quantity = quantity;
	this.idProduct = idProduct;
	this.price = price;
	this.total = total;
}
public InvoiceDto(String nameProduct, String quantity) {
	super();
	this.nameProduct = nameProduct;
	this.quantity = quantity;
}
public InvoiceDto() {
	// TODO Auto-generated constructor stub
}
public String getNameProduct() {
	return nameProduct;
}
public void setNameProduct(String nameProduct) {
	this.nameProduct = nameProduct;
}
public String getQuantity() {
	return quantity;
}
public void setQuantity(String quantity) {
	this.quantity = quantity;
}
public String getIdProduct() {
	return idProduct;
}
public void setIdProduct(String idProduct) {
	this.idProduct = idProduct;
}
public String getPrice() {
	return price;
}
public void setPrice(String price) {
	this.price = price;
}
public String getTotal() {
	return total;
}
public void setTotal(String total) {
	this.total = total;
}
@Override
public String toString() {
	return "InvoiceDto [nameProduct=" + nameProduct + ", quantity=" + quantity + "-"+status+"]";
}

}

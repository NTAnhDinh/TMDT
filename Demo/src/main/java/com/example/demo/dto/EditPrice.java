package com.example.demo.dto;

public class EditPrice {
String nPrice;

public EditPrice(String nPrice) {
	super();
	this.nPrice = nPrice;
}
public EditPrice() {
}
public String getnPrice() {
	return nPrice;
}
public void setnPrice(String nPrice) {
	this.nPrice = nPrice;
}

}

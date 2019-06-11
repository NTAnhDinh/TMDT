package com.example.demo.dto;

import javax.persistence.Id;

public class StaticDto {
	@Id
	private String idProduct;
	private String nameProduct;
	private int month;
	private long quantity;
	public StaticDto() {
	}
	public StaticDto(String idProduct, String nameProduct, long quantity, int month) {
		super();
		this.idProduct = idProduct;
		this.nameProduct = nameProduct;
		this.quantity = quantity;
		this.month = month;
		
	}
	public StaticDto(String idProduct, String nameProduct, int quantity) {
		super();
		this.idProduct = idProduct;
		this.nameProduct = nameProduct;
		this.quantity = quantity;
	}
	
	public String getIdProduct() {
		return idProduct;
	}
	public void setIdProduct(String idProduct) {
		this.idProduct = idProduct;
	}
	public String getNameProduct() {
		return nameProduct;
	}
	public void setNameProduct(String nameProduct) {
		this.nameProduct = nameProduct;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public long getQuantity() {
		return quantity;
	}
	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}
	
}

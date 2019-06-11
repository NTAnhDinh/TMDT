package com.example.demo.dto;

import java.util.Map;

public class FeedbackDto {
	String reportType;
	String creator;
	String date;
	String exceptionsSe;
	String nameProduct;
	String quantity;

	public FeedbackDto(String reportType, String creator, String date, String exceptionsSe, String nameProduct,
			String quantity) {
		super();
		this.reportType = reportType;
		this.creator = creator;
		this.date = date;
		this.exceptionsSe = exceptionsSe;
		this.nameProduct = nameProduct;
		this.quantity = quantity;
	}

	public FeedbackDto() {
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

	public String getReportType() {
		return reportType;
	}

	public void setReportType(String reportType) {
		this.reportType = reportType;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getExceptionsSe() {
		return exceptionsSe;
	}

	public void setExceptionsSe(String exceptionsSe) {
		this.exceptionsSe = exceptionsSe;
	}

	

}

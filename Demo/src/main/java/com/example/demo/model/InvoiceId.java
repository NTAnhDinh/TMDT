package com.example.demo.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class InvoiceId implements Serializable{
	@Column(name="id_invoice")
	private String idInvoice;
	@Column(name="id_product")
	private String idProduct;
	public InvoiceId() {
	}
	public InvoiceId(String idInvoice, String idProduct) {
		super();
		this.idInvoice = idInvoice;
		this.idProduct = idProduct;
	}
	public String getIdInvoice() {
		return idInvoice;
	}
	public void setIdInvoice(String idInvoice) {
		this.idInvoice = idInvoice;
	}
	public String getIdProduct() {
		return idProduct;
	}
	public void setIdProduct(String idProduct) {
		this.idProduct = idProduct;
	}
	

}

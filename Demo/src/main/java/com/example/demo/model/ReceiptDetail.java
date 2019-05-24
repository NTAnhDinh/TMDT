package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="receiptdetail")
public class ReceiptDetail {

	@Id
	private int id;

	@OneToOne
	@JoinColumn(name = "id_product", insertable = false, updatable = false)
	private Product product;
	private double moneyPaid;
	public ReceiptDetail(int id, double moneyPaid, Product product) {
		super();
		this.id = id;
		this.moneyPaid = moneyPaid;
		this.product = product;
	}
	public ReceiptDetail() {
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getMoneyPaid() {
		return moneyPaid;
	}
	public void setMoneyPaid(double moneyPaid) {
		this.moneyPaid = moneyPaid;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	
}

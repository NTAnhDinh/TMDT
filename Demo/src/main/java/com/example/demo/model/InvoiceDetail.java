package com.example.demo.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "invoice_detail")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class InvoiceDetail implements Serializable {
	@EmbeddedId
	private InvoiceId id;

	@OneToOne
	@JoinColumn(name = "id_product", insertable = false, updatable = false)
	private Product product;
	@Column(name = "quantity")
	private int quantity;
	private long price;
	private int status;

	@ManyToOne
	@JoinColumn(name = "id_invoice", insertable = false, updatable = false)
	Invoice invoice;
	public InvoiceDetail() {
	}

	public InvoiceDetail(InvoiceId id, int quantity, long price, int status) {
		super();
		this.id = id;
		this.quantity = quantity;
		this.price = price;
		this.status = status;
	}

	public String getIdInvoice() {
		return id.getIdInvoice();
	}

	public String getIdProduct() {
		return id.getIdProduct();
	}

	public InvoiceId getId() {
		return id;
	}

	public void setId(InvoiceId id) {
		this.id = id;
	}

	public InvoiceDetail(InvoiceId id, Product product, int quantity, long price, int status) {
		super();
		this.id = id;
		this.product = product;
		this.quantity = quantity;
		this.price = price;
		this.status = status;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

//	public List<Product> getProducts() {
//		return products;
//	}
//
//	public void setProducts(List<Product> products) {
//		this.products = products;
//	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "InvoiceDetail [id=" + id + ", product=" + product + ", quantity=" + quantity + ", price=" + price
				+ ", status=" + status + "]";
	}

}

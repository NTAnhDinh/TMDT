package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "warehouse")
public class Warehouse {
	@EmbeddedId
	WarehouseId id;
	@OneToOne
	@JoinColumn(name = "id_product", insertable = false, updatable = false)
	private Product product;
	private double realPrice;
	private int numberInventory;
	@Column(name="defect_number")
	private int defectedNumber;
	private int soldedNumber;
	private String dateUpdate;

	public Warehouse(WarehouseId id, Product product, double realPrice, int numberInventory, int defectedNumber,
			int soldedNumber, String dateUpdate) {
		super();
		this.id = id;
		this.product = product;
		this.realPrice = realPrice;
		this.numberInventory = numberInventory;
		this.defectedNumber = defectedNumber;
		this.soldedNumber = soldedNumber;
		this.dateUpdate = dateUpdate;
	}



	public Warehouse() {
	}

	





	public WarehouseId getId() {
		return id;
	}



	public void setId(WarehouseId id) {
		this.id = id;
	}



	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public double getRealPrice() {
		return realPrice;
	}

	public void setRealPrice(double realPrice) {
		this.realPrice = realPrice;
	}

	public int getNumberInventory() {
		return numberInventory;
	}

	public void setNumberInventory(int numberInventory) {
		this.numberInventory = numberInventory;
	}

	

	

	public int getDefectedNumber() {
		return defectedNumber;
	}

	public void setDefectedNumber(int defectedNumber) {
		this.defectedNumber = defectedNumber;
	}

	public int getSoldedNumber() {
		return soldedNumber;
	}

	public void setSoldedNumber(int soldedNumber) {
		this.soldedNumber = soldedNumber;
	}

	public String getDateUpdate() {
		return dateUpdate;
	}

	public void setDateUpdate(String dateUpdate) {
		this.dateUpdate = dateUpdate;
	}

	

}

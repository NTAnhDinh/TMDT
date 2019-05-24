package com.example.demo.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class WarehouseId implements Serializable {
	@Column(name = "id_warehouse")
	private int idWarehouse;

	@Column(name = "id_product")
	private String idProduct;

	public WarehouseId() {
	}

	public WarehouseId(int idWarehouse, String idProduct) {
		super();
		this.idWarehouse = idWarehouse;
		this.idProduct = idProduct;
	}

	public int getIdWarehouse() {
		return idWarehouse;
	}

	public void setIdWarehouse(int idWarehouse) {
		this.idWarehouse = idWarehouse;
	}

	public String getIdProduct() {
		return idProduct;
	}

	public void setIdProduct(String idProduct) {
		this.idProduct = idProduct;
	}

	@Override
	public String toString() {
		return "WarehouseId [idWarehouse=" + idWarehouse + ", idProduct=" + idProduct + "]";
	}

}

package com.example.demo.model;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "product")
public class Product implements Serializable {
	@Id
	private String idProduct;
	@OneToOne
	@JoinColumn(name = "id_category", insertable = false, updatable = false)
	private CategoryProduct cateProduct;
	@Column(name = "id_category")
	private String idCategory;
	@Column(name = "name_product")
	private String nameProduct;
	private String supplier;
	private long price;
	private int tag;
	
	public Product(String idProduct, String idCategory, String nameProduct, String supplier, long price, int tag) {
		super();
		this.idProduct = idProduct;
		this.idCategory = idCategory;
		this.nameProduct = nameProduct;
		this.supplier = supplier;
		this.price = price;
		this.tag = tag;
	}

	public Product() {
	}

	public String getNameProduct() {
		return nameProduct;
	}

	public void setNameProduct(String nameProduct) {
		this.nameProduct = nameProduct;
	}

	public int getTag() {
		return tag;
	}

	public void setTag(int tag) {
		this.tag = tag;
	}

	public String getIdProduct() {
		return idProduct;
	}

	public void setIdProduct(String idProduct) {
		this.idProduct = idProduct;
	}

	public CategoryProduct getCateProduct() {
		return cateProduct;
	}

	public void setCateProduct(CategoryProduct cateProduct) {
		this.cateProduct = cateProduct;
	}

	public String getSupplier() {
		return supplier;
	}

	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}

	public String getIdCategory() {
		return idCategory;
	}

	public void setIdCategory(String idCategory) {
		this.idCategory = idCategory;
	}

	@Override
	public String toString() {
		return "Product [idProduct=" + idProduct + ", cateProduct=" + cateProduct + ", idCategory=" + idCategory
				+ ", nameProduct=" + nameProduct + ", supplier=" + supplier + ", price=" + price + ", tag=" + tag + "]";
	}

}

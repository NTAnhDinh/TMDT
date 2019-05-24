package com.example.demo.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "category_product")

public class CategoryProduct implements Serializable {
	@Id
	private String idCategory;
	private String name;

	public CategoryProduct(String idCategory, String name) {
		super();
		this.idCategory = idCategory;
		this.name = name;
	}

	public CategoryProduct() {
	}

	public String getIdCategory() {
		return idCategory;
	}

	public void setIdCategory(String idCategory) {
		this.idCategory = idCategory;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}

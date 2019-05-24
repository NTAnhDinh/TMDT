package com.example.demo.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "info_warehouse")
public class InformationWarehouse implements Serializable{
	@Id
	private int idWarehouse;
	@Column(name="name")
	private String name;
	@Column(name="id_user")
	private int idUser;
	@OneToOne
	@JoinColumn(name = "id_user", insertable = false, updatable = false)
	private User user;
	
	private int status;
	public InformationWarehouse(int idWarehouse, String name, int idUser, int status) {
		super();
		this.idWarehouse = idWarehouse;
		this.name = name;
		this.idUser = idUser;
		this.status = status;
	}
	public InformationWarehouse() {
	}
	public int getIdWarehouse() {
		return idWarehouse;
	}
	public void setIdWarehouse(int idWarehouse) {
		this.idWarehouse = idWarehouse;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getIdUser() {
		return idUser;
	}
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
}

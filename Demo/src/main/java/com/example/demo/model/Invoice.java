package com.example.demo.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="invoice")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Invoice implements Serializable{
@Id
@Column(name="id_invoice")
private String idInvoice;

private int id_user;
@OneToOne
@JoinColumn(name = "id_user", insertable = false, updatable = false)
private User user;
private long total;
private double payment;
private int status;
private String date;
private int idWarehouse;

public Invoice() {
}


public Invoice(String idInvoice, int id_user, User user, long total, double payment, int status, String date,
		int idWarehouse) {
	super();
	this.idInvoice = idInvoice;
	this.id_user = id_user;
	this.user = user;
	this.total = total;
	this.payment = payment;
	this.status = status;
	this.date = date;
	this.idWarehouse = idWarehouse;
}


public Invoice(String idInvoice, int id_user, long total, double payment, int status, String date, int idWarehouse) {
	super();
	this.idInvoice = idInvoice;
	this.id_user = id_user;
	this.total = total;
	this.payment = payment;
	this.status = status;
	this.date = date;
	this.idWarehouse = idWarehouse;
}


public String getIdInvoice() {
	return idInvoice;
}

public void setIdInvoice(String idInvoice) {
	this.idInvoice = idInvoice;
}


public int getStatus() {
	return status;
}

public void setStatus(int status) {
	this.status = status;
}

public long getTotal() {
	return total;
}
public void setTotal(long total) {
	this.total = total;
}
public double getPayment() {
	return payment;
}
public void setPayment(double payment) {
	this.payment = payment;
}
public String getDate() {
	return date;
}
public void setDate(String date) {
	this.date = date;
}
public User getUser() {
	return user;
}
public void setUser(User user) {
	this.user = user;
}

@Override
public String toString() {
	return "Invoice [idInvoice=" + idInvoice +", id_user=" + id_user + ", total="
			+ total + ", payment=" + payment + ", status=" + status + ", date=" + date + "]";
}

}

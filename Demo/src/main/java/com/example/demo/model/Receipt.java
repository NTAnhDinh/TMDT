package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="receipt")
public class Receipt {
@Id
private int id;
private String idInvoice;
private String nameCustomer;
private String phoneNumber;
private String description;
private double total_Paid;

public Receipt(int id,String idInvoice, String nameCustomer, String phoneNumber, String description, double total_Paid) {
	super();
	this.id=id;
	this.idInvoice = idInvoice;
	this.nameCustomer = nameCustomer;
	this.phoneNumber = phoneNumber;
	this.description = description;
	this.total_Paid = total_Paid;
}
public Receipt() {
}
public String getIdInvoice() {
	return idInvoice;
}
public void setIdInvoice(String idInvoice) {
	this.idInvoice = idInvoice;
}
public String getNameCustomer() {
	return nameCustomer;
}
public void setNameCustomer(String nameCustomer) {
	this.nameCustomer = nameCustomer;
}
public String getPhone() {
	return phoneNumber;
}
public void setPhone(String phone) {
	this.phoneNumber = phone;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public String getPhoneNumber() {
	return phoneNumber;
}
public void setPhoneNumber(String phoneNumber) {
	this.phoneNumber = phoneNumber;
}
public double getTotal_Paid() {
	return total_Paid;
}
public void setTotal_Paid(double total_Paid) {
	this.total_Paid = total_Paid;
}

}

package com.example.demo.dto;

public class DelInvoice {
	String id;
	String reason;
	String description;
	public DelInvoice(String id, String reason, String description) {
		super();
		this.id = id;
		this.reason = reason;
		this.description = description;
	}
	public DelInvoice() {
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "DelInvoice [id=" + id + ", reason=" + reason + ", description=" + description + "]";
	}
	
}

package com.example.demo.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "deleted_invoice")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class DeletedInvoice implements Serializable {
	@Id
	private String idInvoice;
	private String reason;
	private String date;
	@OneToOne
	@JoinColumn(name = "id_invoice", insertable = false, updatable = false)
	private Invoice invoice;
	

	public DeletedInvoice(String idInvoice, String reason, String date) {
		super();
		this.idInvoice = idInvoice;
		this.reason = reason;
		this.date = date;
	}

	public DeletedInvoice() {
	}

	public String getId() {
		return idInvoice;
	}

	public void setId(String idInvoice) {
		this.idInvoice = idInvoice;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
}

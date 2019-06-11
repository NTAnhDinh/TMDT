package com.example.demo.model;

import java.io.Serializable;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "feedback")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Feedback implements Serializable{
	@Id
	@GeneratedValue
	private int idFeedback;
	private String title;
	private int id_user;
	@OneToOne
	@JoinColumn(name = "id_user", insertable = false, updatable = false)
	private User user;
	@Column(name = "receiver")
	private String receiver;
	private String dateReport;
	private String note;
	private int status;
	public Feedback() {
	}

	public Feedback( String title, int id_user, String receiver, String dateReport, String note,
			int status) {
		super();
		this.title = title;
		this.id_user = id_user;
		this.receiver = receiver;
		this.dateReport = dateReport;
		this.note = note;
		this.status = status;
	}

	public int getId_user() {
		return id_user;
	}

	public void setId_user(int id_user) {
		this.id_user = id_user;
	}

	public int getIdFeedback() {
		return idFeedback;
	}
	public void setIdFeedback(int idFeedback) {
		this.idFeedback = idFeedback;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getReceiver() {
		return receiver;
	}
	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}
	public String getDateReport() {
		return dateReport;
	}
	public void setDateReport(String dateReport) {
		this.dateReport = dateReport;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Feedback [idFeedback=" + idFeedback + ", title=" + title + ", id_user=" + id_user + ", user=" + user
				+ ", recevier=" + receiver + ", dateReport=" + dateReport + ", note=" + note + ", status=" + status
				+ "]";
	}


}

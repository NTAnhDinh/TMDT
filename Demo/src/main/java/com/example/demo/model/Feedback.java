package com.example.demo.model;

import javax.persistence.*;

@Entity
@Table(name = "feedback")
public class Feedback {
	@Id
	private int idFeedback;
	private String title;
	private int id_user;
	@OneToOne
	@JoinColumn(name = "id_user", insertable = false, updatable = false)
	private User user;
	@Column(name = "receiver")
	private String recevier;
	private String dateReport;
	private String note;
	private int status;
	public Feedback() {
	}

	public Feedback(int idFeedback, String title, int id_user, String recevier, String dateReport, String note,
			int status) {
		super();
		this.idFeedback = idFeedback;
		this.title = title;
		this.id_user = id_user;
		this.recevier = recevier;
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
	public String getRecevier() {
		return recevier;
	}
	public void setRecevier(String recevier) {
		this.recevier = recevier;
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


}

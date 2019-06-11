package com.example.demo.model;

import java.io.Serializable;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "user")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class User implements Serializable {
	@Id
	@GeneratedValue
	@Column(name = "id_user")
	private int idUser;

	private String name;
	private String password;
	@Column(name = "id_role")
	private int idRole;
	@OneToOne
	@JoinColumn(name = "id_role", insertable = false, updatable = false)
	private Role role;

	@Column(name = "image")
	private String image;
	private int status;

	public User() {
	}

	public User(int id_user, String name, String password, int idRole, int status) {
		super();
		this.idUser = id_user;
		this.name = name;
		this.password = password;
		this.idRole = idRole;
		this.status = status;
	}

	public int getId_user() {
		return idUser;
	}

	public void setId_user(int id_user) {
		this.idUser = id_user;
	}

	public int getIdRole() {
		return idRole;
	}

	public void setIdRole(int idRole) {
		this.idRole = idRole;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "User [id_user=" + idUser + ", name=" + name + ", password=" + password + ", idRole=" + idRole
				+ ", image=" + image + ", status=" + status + "]";
	}

}

package com.example.demo.model;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class User implements Serializable {
	@Id
	private int id_user;

	private String name;
	private String password;
	@Column(name = "id_role" )
	private int idRole;
	@OneToOne
	@JoinColumn(name = "id_role", insertable = false, updatable = false)
	private Role role;
	private int status;

	public User() {
	}

	

	public User(int id_user, String name, String password, int idRole, int status) {
		super();
		this.id_user = id_user;
		this.name = name;
		this.password = password;
		this.idRole = idRole;
		this.status = status;
	}



	public int getId_user() {
		return id_user;
	}



	public void setId_user(int id_user) {
		this.id_user = id_user;
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

}

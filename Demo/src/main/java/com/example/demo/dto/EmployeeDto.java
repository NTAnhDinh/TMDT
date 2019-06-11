package com.example.demo.dto;

import javax.validation.constraints.NotNull;

public class EmployeeDto {
	private String username;
	private String password;
	private String rePassword;
	@NotNull(message = "Not null")
	private String idRole;
	public EmployeeDto() {
	}
	
	public EmployeeDto(String username, String password, String rePassword, String idRole) {
		super();
		this.username = username;
		this.password = password;
		this.rePassword = rePassword;
		this.idRole = idRole;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRePassword() {
		return rePassword;
	}

	public void setRePassword(String rePassword) {
		this.rePassword = rePassword;
	}

	public String getIdRole() {
		return idRole;
	}

	public void setIdRole(String idRole) {
		this.idRole = idRole;
	}

	@Override
	public String toString() {
		return "EmployeeDto [username=" + username + ", password=" + password + ", rePassword=" + rePassword
				+ ", idRole=" + idRole + "]";
	}
	
}

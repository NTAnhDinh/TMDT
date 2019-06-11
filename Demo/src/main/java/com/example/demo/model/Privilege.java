package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name = "privilege")
public class Privilege implements Serializable {
    @Id
    @Column(name = "id")
    int stt;
    @Column(name = "id_user")
    int idUser;

    @Column(name = "path")
    String path;
    @Column(name = "insert")
    int insert;
    @Column(name = "update")
    int update;
    @Column(name = "delete")
    int delete;
    @Column(name = "retrieve")
    int retrieve;

    public Privilege() {
    }

  

    public Privilege(int stt, int idUser, String path, int insert, int update, int delete, int retrieve) {
		super();
		this.stt = stt;
		this.idUser = idUser;
		this.path = path;
		this.insert = insert;
		this.update = update;
		this.delete = delete;
		this.retrieve = retrieve;
	}



	public int getIdUser() {
		return idUser;
	}



	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}



	public void setStt(int stt) {
		this.stt = stt;
	}



	public int getStt() {
        return stt;
    }

  
    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public int getInsert() {
        return insert;
    }

    public void setInsert(int insert) {
        this.insert = insert;
    }

    public int getUpdate() {
        return update;
    }

    public void setUpdate(int update) {
        this.update = update;
    }

    public int getDelete() {
        return delete;
    }

    public void setDelete(int delete) {
        this.delete = delete;
    }

    public int getRetrieve() {
        return retrieve;
    }

    public void setRetrieve(int retrieve) {
        this.retrieve = retrieve;
    }
}

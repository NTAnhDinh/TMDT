package com.tmdt.ngohongthai.entities;

import java.sql.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table( name="booking")
public class Booking {
private int id;
private String status;
private int detail_id;
private Date  created;
private String username;
@ManyToMany
@JoinTable(name="booking_details", joinColumns=@JoinColumn(name="booking_id"),
inverseJoinColumns= @JoinColumn (name="room_id"))
private List<Room> listRoom;
}

package com.tmdt.ngohongthai.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table( name="room_type")
public class RoomType {
private int id;
private String name;
@OneToMany(mappedBy = "room_type")
private List<Room> listRoom;
}

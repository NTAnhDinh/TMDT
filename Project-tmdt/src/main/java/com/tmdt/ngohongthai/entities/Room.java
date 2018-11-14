package com.tmdt.ngohongthai.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ManyToAny;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table( name="room")

public class Room  implements Serializable{
    @Id
    @GeneratedValue
	private int room_id;
	private String room_name;
	private int room_status;
	private int room_number_guest;
	private int room_reviews;
	private int room_number_reviews;
	private String room_address;
	private int room_price;
	private String room_describe;
	private String room_information;
	@ManyToOne
	@JoinColumn(name="room_type")
	private RoomType room_type;
//	private int homestay_id;
	private String room_image;
	@ManyToOne
	@JoinColumn(name="homestay_id")
	private HomeStay homeStay;
	@ManyToMany
	@JoinTable(name="booking_details", joinColumns=@JoinColumn(name="room_id"),
	inverseJoinColumns= @JoinColumn (name="booking_id"))
	private List<Booking> listBook;
	public Room() {
	}
	public int getRoom_id() {
		return room_id;
	}
	public void setRoom_id(int room_id) {
		this.room_id = room_id;
	}
	public String getRoom_name() {
		return room_name;
	}
	public void setRoom_name(String room_name) {
		this.room_name = room_name;
	}
	public int getRoom_status() {
		return room_status;
	}
	public void setRoom_status(int room_status) {
		this.room_status = room_status;
	}
	public int getRoom_number_guest() {
		return room_number_guest;
	}
	public void setRoom_number_guest(int room_number_guest) {
		this.room_number_guest = room_number_guest;
	}
	public int getRoom_reviews() {
		return room_reviews;
	}
	public void setRoom_reviews(int room_reviews) {
		this.room_reviews = room_reviews;
	}
	public int getRoom_number_reviews() {
		return room_number_reviews;
	}
	public void setRoom_number_reviews(int room_number_reviews) {
		this.room_number_reviews = room_number_reviews;
	}
	public String getRoom_address() {
		return room_address;
	}
	public void setRoom_address(String room_address) {
		this.room_address = room_address;
	}
	public int getRoom_price() {
		return room_price;
	}
	public void setRoom_price(int room_price) {
		this.room_price = room_price;
	}
	public String getRoom_describe() {
		return room_describe;
	}
	public void setRoom_describe(String room_describe) {
		this.room_describe = room_describe;
	}
	public String getRoom_information() {
		return room_information;
	}
	public void setRoom_information(String room_information) {
		this.room_information = room_information;
	}
	

	public RoomType getRoom_type() {
		return room_type;
	}
	public void setRoom_type(RoomType room_type) {
		this.room_type = room_type;
	}
	public String getRoom_image() {
		return room_image;
	}
	public void setRoom_image(String room_image) {
		this.room_image = room_image;
	}
	public HomeStay getHomeStay() {
		return homeStay;
	}
	public void setHomeStay(HomeStay homeStay) {
		this.homeStay = homeStay;
	}

}

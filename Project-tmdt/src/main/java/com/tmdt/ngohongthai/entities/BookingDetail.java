package com.tmdt.ngohongthai.entities;




import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table( name="booking_details")

public class BookingDetail {
private int id;
private int room_id;
private Date checkIn ;
private Date checkOut;
private String customerFullname;
private String phone;
private String cardNumber;
private String dateOfBirth;
private int detailPrice;

}

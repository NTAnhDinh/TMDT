package com.tmdt.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "booking")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Booking implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int booking_id;
    private String user_name;
    private int room_id;
    @Temporal(TemporalType.DATE)
    private Date created;
    @Temporal(TemporalType.DATE)
    private Date check_in;
    @Temporal(TemporalType.DATE)
    private Date check_out;
    private String customer_fullname;
    private String customer_phone;
    private String customer_card_number;
    private Date customer_date_of_birth;
    private int booking_price;
    private int booking_status;

    @OneToOne
    @JoinColumn(name = "room_id", insertable = false, updatable = false)
    private Room room;

    @OneToOne
    @JoinColumn(name = "user_name", insertable = false, updatable = false)
    private Users users;
}

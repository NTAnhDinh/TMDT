package com.tmdt.ngohongthai.entities;

import lombok.*;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "homestay")
//@Getter
//@Setter
//@AllArgsConstructor
//@NoArgsConstructor
//@ToString
public class HomeStay {
    @Id
    @GeneratedValue
    private int homestay_id;
    private String homestay_name;
    private String homestay_image;
    private String homestay_description;
    private String homestay_location;
    private String homestay_master;
    private int homestay_reviews;
    private int homestay_number_reviews;

    @OneToOne
    @JoinColumn(name = "homestay_id")
    private Location location;
    
    @OneToMany(mappedBy = "homestay")
    private List<Room> listRoom;
}

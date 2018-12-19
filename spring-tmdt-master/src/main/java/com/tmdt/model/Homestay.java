package com.tmdt.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "homestay")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Homestay implements Serializable {
    @Id
    @GeneratedValue
    private int homestay_id;
    private String homestay_name;
    @Column(name = "homestay_image")
    private String homestay_image;
    private String homestay_description;
    private int homestay_location;
    private String homestay_master;
    private double homestay_reviews;
    private int homestay_number_reviews;

    @OneToOne
    @JoinColumn(name="homestay_master", insertable = false, updatable = false)
    private Users users;

    @OneToOne
    @JoinColumn(name = "homestay_location", insertable = false, updatable = false)
    private Location location;
}

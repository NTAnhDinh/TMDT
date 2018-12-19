package com.tmdt.model;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "reg_service")
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class RegisterService {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int reg_id;
    private int homestay_id;
    private int service_id;
    @Temporal(TemporalType.DATE)
    private Date date_started;
    @Temporal(TemporalType.DATE)
    private Date date_finished;
    private int price;

    @OneToOne
    @JoinColumn(name = "homestay_id", insertable = false, updatable = false)
    private Homestay homestay;

    @OneToOne
    @JoinColumn(name = "service_id", insertable = false, updatable = false)
    private Buy buy;
}

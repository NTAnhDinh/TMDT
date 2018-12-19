package com.tmdt.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "service")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Buy {
    @Id
    private int service_id;
    private String service_name;
    private int service_price;
}

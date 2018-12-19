package com.tmdt.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Entity
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class Users {
    @Id
    @NotBlank
    private String user_name;
    @NotBlank
    private String user_password;
    @NotBlank
    @Email
    private String user_email;
    @Temporal(TemporalType.DATE)
    private Date user_created;
    @NotBlank
    private String user_fullname;
    @NotBlank
    private String user_phone;
    @NotBlank
    private String user_address;
    private String user_type;
    private String user_card_number;
    @Temporal(TemporalType.DATE)
    private Date user_date_of_birth;
}

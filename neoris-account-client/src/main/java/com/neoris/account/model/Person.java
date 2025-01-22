package com.neoris.account.model;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.Date;

@Data
public class Person {

    private Long personId;

    private String name;

    private String surname;

    private String gender;

    private Date birthDate;

    private String identityNumber;

    private String address;

    private String phone;
}

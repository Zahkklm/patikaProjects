package com.patika.turizm.model;

import javax.persistence.*;
import lombok.*;
@Getter
@Setter
@Entity
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String address;
    private String email;
    private String phone;
    private String starRating;
    private String features;

    // Getters and Setters
}


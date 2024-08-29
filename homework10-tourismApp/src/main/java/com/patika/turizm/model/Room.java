package com.patika.turizm.model;



import javax.persistence.*;
import lombok.*;
@Getter
@Setter
@Entity
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String type;
    private int capacity;
    private double adultPrice;
    private double childPrice;
    private int stock;
    private String features;

    @ManyToOne
    private Hotel hotel;

    // Getters and Setters
}

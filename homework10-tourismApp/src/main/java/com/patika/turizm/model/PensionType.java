package com.patika.turizm.model;

import javax.persistence.*;
import lombok.*;
@Getter
@Setter
@Entity
public class PensionType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String type;

    @ManyToOne
    private Hotel hotel;

    // Getters and Setters
}

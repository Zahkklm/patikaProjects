package com.patika.turizm.model;


import javax.persistence.*;
import java.time.LocalDate;
import lombok.*;
@Getter
@Setter
@Entity
public class Season {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate startDate;
    private LocalDate endDate;

    @ManyToOne
    private Hotel hotel;

    // Getters and Setters
}

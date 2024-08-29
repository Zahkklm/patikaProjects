package com.patika.turizm.model;



import javax.persistence.*;
import java.time.LocalDate;
import lombok.*;
@Getter
@Setter
@Entity
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String guestName;
    private String guestEmail;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private double totalPrice;

    @ManyToOne
    private Room room;

    // Getters and Setters
}

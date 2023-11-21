package com.example.hotelreservation.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity@Getter@Setter
@Table(name = "reservationMaster")
public class ReservationMaster {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer reservationId;

    @ManyToOne
    @JoinColumn(name = "guest_id")
    @JsonBackReference
    private GuestMaster guestMaster;

    private String checkInDate;
    private String checkOutDate;


}

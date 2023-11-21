package com.example.hotelreservation.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter@Setter@Table(name = "guestMaster")
public class GuestMaster {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer guestId;

    private String name;

    @OneToMany(mappedBy = "guestMaster", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<ReservationMaster> reservations = new ArrayList<>();


}

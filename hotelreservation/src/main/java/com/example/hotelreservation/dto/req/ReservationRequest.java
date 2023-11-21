package com.example.hotelreservation.dto.req;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class ReservationRequest {
    private Integer guestId;
    private String checkInDate;
    private String checkOutDate;

}

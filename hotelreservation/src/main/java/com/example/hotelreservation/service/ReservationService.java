package com.example.hotelreservation.service;

import com.example.hotelreservation.dto.req.ReservationRequest;
import com.example.hotelreservation.dto.res.Message;
import com.example.hotelreservation.model.ReservationMaster;

import java.util.List;

public interface ReservationService {
    ReservationMaster createReservation(ReservationRequest request);

    Boolean updateReservationDates(Integer reservationId, ReservationRequest request);


    List<ReservationMaster> listGuestReservations(Integer guestId);

    Message cancelReservation(Integer reservationId);
}

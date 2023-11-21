package com.example.hotelreservation.service.impl;

import com.example.hotelreservation.dto.req.ReservationRequest;
import com.example.hotelreservation.dto.res.Message;
import com.example.hotelreservation.model.GuestMaster;
import com.example.hotelreservation.model.ReservationMaster;
import com.example.hotelreservation.repository.GuestRepository;
import com.example.hotelreservation.repository.ReservationRepository;
import com.example.hotelreservation.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class ReservationServiceImpl implements ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private GuestRepository guestRepository;

    @Override
    public ReservationMaster createReservation(ReservationRequest request) {
        GuestMaster guest = guestRepository.findById(request.getGuestId()).orElseThrow(() -> new EntityNotFoundException("Guest not found"));
        ReservationMaster reservation = new ReservationMaster();
        guest.setGuestId(request.getGuestId());
        reservation.setGuestMaster(guest);
        reservation.setCheckInDate(request.getCheckInDate());
        reservation.setCheckOutDate(request.getCheckOutDate());
        try {
            reservationRepository.save(reservation);
            return reservation;
        } catch (Exception e) {
            e.printStackTrace();
            return reservation;
        }
    }

    @Override
    public Boolean updateReservationDates(Integer reservationId, ReservationRequest request) {
        ReservationMaster reservation = reservationRepository.findById(reservationId)
                .orElseThrow(() -> new EntityNotFoundException("Reservation not found"));
        reservation.setCheckInDate(request.getCheckInDate());
        reservation.setCheckOutDate(request.getCheckOutDate());
        try {
            reservationRepository.save(reservation);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public void cancelReservation(Integer reservationId) {
        ReservationMaster reservation = reservationRepository.findById(reservationId)
                .orElseThrow(() -> new EntityNotFoundException("Reservation not found"));
        reservationRepository.delete(reservation);
    }
    @Override
    public List<ReservationMaster> listGuestReservations(Integer guestId) {
        GuestMaster guest = guestRepository.findById(guestId).orElseThrow(() -> new EntityNotFoundException("Guest not found"));
        return guest.getReservations();
    }

}

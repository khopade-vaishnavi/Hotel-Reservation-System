package com.example.hotelreservation.controller;

import com.example.hotelreservation.dto.req.ReservationRequest;
import com.example.hotelreservation.dto.res.Message;
import com.example.hotelreservation.model.ReservationMaster;
import com.example.hotelreservation.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reservation")
@CrossOrigin("*")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @PostMapping(value = "/createReservation")
    public ResponseEntity<ReservationMaster> createReservation(@RequestBody ReservationRequest request) {
        ReservationMaster reservation = reservationService.createReservation(request);
        return new ResponseEntity<>(reservation, HttpStatus.CREATED);
    }
    @PutMapping(value = "/updateReservationDates/{reservationId}")
    public ResponseEntity updateReservationDates(@PathVariable Integer reservationId, @RequestBody ReservationRequest request) {
       Boolean flag= reservationService.updateReservationDates(reservationId, request);
        return new ResponseEntity<>(flag,HttpStatus.OK);
    }
    @DeleteMapping(value = "/cancelReservation/{reservationId}")
    public ResponseEntity<Void> cancelReservation(@PathVariable Integer reservationId) {
        Message message=reservationService.cancelReservation(reservationId);
        HttpStatus status = message.isFlag() ? HttpStatus.NO_CONTENT : HttpStatus.BAD_REQUEST;

        return new ResponseEntity(message, status);

 }
    @GetMapping(value = "/guestIdWiseAllReservation/{guestId}")
    public ResponseEntity<List<ReservationMaster>> listGuestReservations(@PathVariable Integer guestId) {
        List<ReservationMaster> reservations = reservationService.listGuestReservations(guestId);
        return new ResponseEntity<>(reservations, HttpStatus.OK);
    }



}

package com.example.hotelreservation.controller;

import com.example.hotelreservation.dto.req.GuestRequest;
import com.example.hotelreservation.dto.res.Message;
import com.example.hotelreservation.service.GuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/guest")
@CrossOrigin("*")
public class GuestController {

    @Autowired
    private GuestService guestService;

    @PostMapping(value = "/createGuest")
    public ResponseEntity createGuest(@RequestBody GuestRequest guestRequest) {
        Message message = guestService.createGuest(guestRequest);
        return new ResponseEntity(message, HttpStatus.OK);
    }


}

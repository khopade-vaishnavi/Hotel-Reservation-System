package com.example.hotelreservation.service;

import com.example.hotelreservation.dto.req.GuestRequest;
import com.example.hotelreservation.dto.res.Message;

public interface GuestService {
    Message createGuest(GuestRequest guestRequest);
}

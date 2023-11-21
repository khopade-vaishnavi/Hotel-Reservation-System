package com.example.hotelreservation.service.impl;

import com.example.hotelreservation.dto.req.GuestRequest;
import com.example.hotelreservation.dto.res.Message;
import com.example.hotelreservation.model.GuestMaster;
import com.example.hotelreservation.repository.GuestRepository;
import com.example.hotelreservation.service.GuestService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GuestServiceImpl implements GuestService {

    @Autowired
    private GuestRepository guestRepository;

    @Override
    public Message createGuest(GuestRequest guestRequest) {
        Message message = new Message();
        GuestMaster guestMaster = new GuestMaster();
        guestMaster.setName(guestMaster.getName());
        try {
            guestRepository.save(guestMaster);
            message.setFlag(true);
            message.setResponseCode(200);
            message.setMsg("guest register successfully");
        } catch (Exception e) {
            e.printStackTrace();
            message.setFlag(false);
            message.setResponseCode(400);
            message.setMsg("guest not register successfully");
        }
        return message;
    }
}

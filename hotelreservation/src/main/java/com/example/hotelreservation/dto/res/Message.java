package com.example.hotelreservation.dto.res;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class Message {
    private Boolean flag;
    private String msg;
    private Integer responseCode;
}

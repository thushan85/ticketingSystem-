package com.esad.assignment.ticketingsystem.response;

import lombok.Getter;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Getter
public class ErrorResponse {
    private Integer success = 0;
    private Date timestamp = new Date();
    private Object data = null;
    private String message = null;

    public ErrorResponse(String message){
        this.message = message;
    }


}

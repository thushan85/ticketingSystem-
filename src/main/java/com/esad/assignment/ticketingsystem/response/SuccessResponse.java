package com.esad.assignment.ticketingsystem.response;

import java.util.Date;

public class SuccessResponse {

    private Date timestamp;
    private Object data;
    private String message;
    private Integer status = 1;

    public SuccessResponse(Object data) {
        super();
        this.data = data;
        this.timestamp = new Date();
        this.message = "Success";
    }

    public SuccessResponse(Object data, String message) {
        super();
        this.data = data;
        this.timestamp = new Date();
        this.message = message;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public Object getData() {
        return data;
    }

    public String getMessage() {
        return message;
    }

    public Integer getStatus() {
        return  status;
    }
}
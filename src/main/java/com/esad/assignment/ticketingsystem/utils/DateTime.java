package com.esad.assignment.ticketingsystem.utils;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTime {

    private static final SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static Timestamp getCurrentTimeStamp() {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        return  timestamp;
    }

    public static String getCurrentDateTime() {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        return dt.format(timestamp);
    }
}

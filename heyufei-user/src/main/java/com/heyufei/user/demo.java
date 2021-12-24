package com.heyufei.user;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class demo {
    public static void main(String[] args) throws ParseException {
        Date date = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSX").parse("2021-12-23T16:07:46.000+08:00");

        System.out.println(date);
    }
}

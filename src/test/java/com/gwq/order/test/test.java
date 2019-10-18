package com.gwq.order.test;


import java.text.SimpleDateFormat;
import java.util.Date;

public class test {

    public static void main(String[] args) {
        Date date = new Date();
        String now = new SimpleDateFormat("yyyyMMdd").format(date);
        System.out.println(now);
        System.out.println(System.currentTimeMillis());
    }
}

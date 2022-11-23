package com.biblioteca.helpers;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class ReturnDate {

    public static Date returnDate() {
        Date date = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, 8);
        date = cal.getTime();
        return date;
    }

    public static Date addDays(int days, Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, days);
        date = cal.getTime();
        return date;
    }

    public static List < String > returnDates(int month, int year) {
        List < String > fechas = new ArrayList < String > ();
        String first = year + "-" + month + "-01 00:00:00";
        String second = year + "-" + month + "-30 23:59:59";
        fechas.add(first);
        fechas.add(second);
        return fechas;
    }
}
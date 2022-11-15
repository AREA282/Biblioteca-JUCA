package com.biblioteca.helpers;

import java.util.Calendar;
import java.util.Date;

public class ReturnDate {

    public static Date returnDate(){
        Date date = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, 8);
        date = cal.getTime();
        return date;
    }

}

package com.craft;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by scorde on 7/2/2015.
 */
public class DateTransaction {

    private DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");


    public String getCurrentDate(){
        Date date = new Date();
        return dateFormat.format(date);
    }

}

package com.craft;

import java.util.Date;

/**
 * Created by scorde on 7/2/2015.
 */
public class Transaction {

    private String date;
    private int amount;


    public Transaction(String date, int amount){
        this.date = date;
        this.amount = amount;
    }

    public String getDate() {
        return date;
    }


    public int getAmount() {
        return amount;
    }


    @Override
    public String toString() {
        return "Transaction{" +
                "date='" + date + '\'' +
                ", amount=" + amount +
                '}';
    }

}

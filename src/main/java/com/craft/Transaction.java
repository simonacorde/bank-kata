package com.craft;

import java.util.Date;

/**
 * Created by scorde on 7/2/2015.
 */
public class Transaction {

    private String date;
    private int totalAfter;
    private int amount;

    public Transaction(String date, int total, int amount){
        this.date = date;
        this.totalAfter = total;
        this.amount = amount;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getTotalAfter() {
        return totalAfter;
    }

    public void setTotalAfter(int totalAfter) {
        this.totalAfter = totalAfter;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}

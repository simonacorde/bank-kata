package com.craft;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BankAccount implements Account {

    private int total;
    private List<Transaction> transactions;
    DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    Console console;
    DateTransaction dt;

    public BankAccount(Console console){
        this.total = 0;
        transactions = new ArrayList<Transaction>();
        this.console = console;
        dt= new DateTransaction();
    }

    public void deposit(int amount) {
        total+=amount;
        transactions.add(new Transaction(dt.getCurrentDate(), total, amount));
    }

    public void withdraw(int amount) {
        total-=amount;
        Date date = new Date();
        int amount1 = 0-amount;
        transactions.add(new Transaction(dt.getCurrentDate(), total, amount1));
    }

    public void printStatement() {
        console.printLine("DATE | AMOUNT | BALANCE");
        for(int i=transactions.size()-1;i>=0;i--){
            console.printLine(""+transactions.get(i).getDate()+" | "+(double)transactions.get(i).getAmount()+" | "+(double)transactions.get(i).getTotalAfter());
        }


    }

}

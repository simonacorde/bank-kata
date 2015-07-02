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


    public BankAccount(){
        this.total = 0;
        transactions = new ArrayList<Transaction>();
        console = new Console();
    }

    public void deposit(int amount) {
        total+=amount;
        Date date = new Date();
        transactions.add(new Transaction(dateFormat.format(date), total, amount));
    }

    public void withdraw(int amount) {
        total-=amount;
        Date date = new Date();
        int amount1 = 0-amount;
        transactions.add(new Transaction(dateFormat.format(date), total, amount1));
    }

    public String printStatement() {
        return "DATE | AMOUNT | BALANCE";
         //console.printLine("DATE | AMOUNT | BALANCE");
        //for(int i=transactions.size()-1;i>=0;i--){
        //    console.printLine(""+transactions.get(i).getDate()+" | "+transactions.get(i).getAmount()+" | "+transactions.get(i).getTotalAfter());
       // }

    }

}

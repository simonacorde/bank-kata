package com.craft;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BankAccount implements Account {

    private int total;
    private Console console;
    private DateTransaction dt;
    private TransactionRepository tr;

    public BankAccount(Console console){
        this.total = 0;
        this.console = console;
        dt= new DateTransaction();
        tr = new TransactionRepository();
    }

    public void deposit(int amount) {
        total+=amount;
        tr.addTransaction(dt.getCurrentDate(), total, amount);
    }

    public void withdraw(int amount) {
        total-=amount;
        int amount1 = 0-amount;
        tr.addTransaction(dt.getCurrentDate(), total, amount1);
    }

    public void printStatement() {
        console.printLine("DATE | AMOUNT | BALANCE");
        for(int i=tr.getTransactions().size()-1;i>=0;i--){
            console.printLine(""+tr.getTransactions().get(i).getDate()+" | "+(double)tr.getTransactions().get(i).getAmount()+" | "+(double)tr.getTransactions().get(i).getTotalAfter());
        }


    }

}

package com.craft;

import java.util.ArrayList;
import java.util.List;


public class Printer {

    private Console console;

    public Printer(Console console){
        this.console = console;
    }

    public void print(String s){
        console.printLine(s);
    }

    public void printTransactionsDescendent(List<Transaction> transactions) {
        console.printLine("DATE | AMOUNT | BALANCE");
        int total = 0;
        List<TransactionAmount> transactionList = new ArrayList<>();

        for(Transaction transaction: transactions){
            total+= transaction.getAmount();
            TransactionAmount transactionAmount = new TransactionAmount(transaction.getDate(), transaction.getAmount(), total);
            transactionList.add(0,transactionAmount);
        }

        for (TransactionAmount transaction : transactionList) {
            console.printLine("" + transaction.getDate() + " | " + (double) transaction.getAmount() + " | " + (double) transaction.getBalance());
        }
    }


    private class TransactionAmount extends Transaction {

        private int balance;

        public TransactionAmount(String date, int amount, int balance) {
            super(date, amount);
            this.balance = balance;
        }

        private int getBalance(){
            return this.balance;
        }
    }
}

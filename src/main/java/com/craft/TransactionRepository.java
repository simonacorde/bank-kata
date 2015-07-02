package com.craft;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by scorde on 7/2/2015.
 */
public class TransactionRepository {

    private List<Transaction> transactions;

    public TransactionRepository(){
        transactions = new ArrayList<Transaction>();
    }

    public void addTransaction(String date, int total, int amount){
        Transaction t = new Transaction(date, total, amount);
        transactions.add(t);
    }

    public List<Transaction> getTransactions(){
        return this.transactions;
    }


}

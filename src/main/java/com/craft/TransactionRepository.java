package com.craft;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by scorde on 7/2/2015.
 */
public class TransactionRepository {

    private List<Transaction> transactions;
    private DateTransaction dt;

    public TransactionRepository(DateTransaction dt){
        transactions = new ArrayList<>();
        this.dt = dt;
    }

    public void addTransaction(int amount){
        Transaction t = new Transaction(dt.getCurrentDate(),amount);
        transactions.add(t);
    }

    public List<Transaction> getTransactions(){
        return this.transactions;
    }


}

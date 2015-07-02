package com.craft;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by scorde on 7/2/2015.
 */
public class TransactionRepository {

    private List<Transaction> transactions;
    private DateTransaction dt;

    public TransactionRepository(DateTransaction dt){
        transactions = new ArrayList<Transaction>();
        this.dt = dt;
    }

    public void addTransaction(int total, int amount){
        Transaction t = new Transaction(dt.getCurrentDate(), total, amount);
        transactions.add(t);
    }

    public List<Transaction> getTransactions(){
        return this.transactions;
    }


}

package com.craft;

public class BankAccount implements Account {


    private TransactionRepository transactionRepository;
    private Printer printer;

    public BankAccount(Printer printer, TransactionRepository tr){
        this.printer = printer;
        this.transactionRepository = tr;
    }

    public void deposit(int amount) {
        transactionRepository.addTransaction(amount);
    }

    public void withdraw(int amount) {
        int amount1 = 0-amount;
        transactionRepository.addTransaction(amount1);
    }

    public void printStatement() {
       printer.printTransactionsDescendent(transactionRepository.getTransactions());
    }

}

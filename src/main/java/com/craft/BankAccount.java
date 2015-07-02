package com.craft;

public class BankAccount implements Account {

    private int total;
    private Console console;
    private TransactionRepository transactionRepository;

    public BankAccount(Console console, TransactionRepository tr){
        this.total = 0;
        this.console = console;
        this.transactionRepository = tr;
    }

    public void deposit(int amount) {
        total+=amount;
        transactionRepository.addTransaction(total, amount);
    }

    public void withdraw(int amount) {
        total-=amount;
        int amount1 = 0-amount;
        transactionRepository.addTransaction(total, amount1);
    }

    public void printStatement() {
        console.printLine("DATE | AMOUNT | BALANCE");
        for(int i= transactionRepository.getTransactions().size()-1;i>=0;i--){
            console.printLine(""+ transactionRepository.getTransactions().get(i).getDate()+" | "+(double) transactionRepository.getTransactions().get(i).getAmount()+" | "+(double) transactionRepository.getTransactions().get(i).getTotalAfter());
        }


    }

}

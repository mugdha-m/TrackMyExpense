package com.example.trackmyexpense.utils;

import com.example.trackmyexpense.models.Transaction;

import java.util.ArrayList;
import java.util.List;

public class TransactionManager {
    private Double globalAmount;
    private Double globalBudget;
    private List<Transaction> transactionList;

    public TransactionManager() {
        this.globalAmount = 0d;
        this.globalBudget = 1000d;
        this.transactionList = new ArrayList<Transaction>();
    }

    public boolean addTransaction(Transaction transaction) {
        globalAmount = globalAmount + transaction.getAmount();
        globalBudget = globalBudget - transaction.getAmount();

        transactionList.add(transaction);
        return transactionList.get(transactionList.size() - 1).equals(transaction);
    }
}

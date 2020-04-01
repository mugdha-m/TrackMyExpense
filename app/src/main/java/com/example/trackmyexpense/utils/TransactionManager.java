package com.example.trackmyexpense.utils;

import com.example.trackmyexpense.models.Transaction;

import java.util.ArrayList;
import java.util.List;

public class TransactionManager {
    // TODO: Should be specific to a user
    Double globalAmount;
    Double globalBudget;
    List<Transaction> transactionList;

    public TransactionManager() {
        this.globalAmount = Double.valueOf(0);
        this.globalBudget = Double.valueOf(1000);
        this.transactionList = new ArrayList<Transaction>();
    }

    public boolean addTransaction(Transaction transaction) {
        globalAmount = globalAmount + transaction.getAmount();
        globalBudget = globalBudget - transaction.getAmount();

        transactionList.add(transaction);
        return transactionList.get(transactionList.size() - 1).equals(transaction);
    }
}

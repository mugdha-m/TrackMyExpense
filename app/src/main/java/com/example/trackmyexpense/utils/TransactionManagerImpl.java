package com.example.trackmyexpense.utils;

import com.example.trackmyexpense.models.Transaction;

import java.util.ArrayList;
import java.util.List;

public class TransactionManagerImpl implements TransactionManager{
    private double remainingBudget;
    private double totalExpense;
    private List<Transaction> transactionList;

    public TransactionManagerImpl() {
        this.remainingBudget = 1000d;
        this.totalExpense = 0d;
        this.transactionList = new ArrayList<>();
    }

    @Override
    public double getRemainingBudget() {
        return remainingBudget;
    }

    @Override
    public double getTotalExpense() {
        return totalExpense;
    }

    @Override
    public List<Transaction> getTransactionList() {
        return transactionList;
    }

    @Override
    public boolean addTransaction(Transaction transaction) {
        if (transaction == null) {
            return false;
        }

        transactionList.add(transaction);
        totalExpense = totalExpense + transaction.getAmount();
        remainingBudget = remainingBudget - transaction.getAmount();

        return true;
    }
}

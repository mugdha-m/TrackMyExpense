package com.example.trackmyexpense.utils;

import com.example.trackmyexpense.models.Transaction;

import java.util.List;

public interface TransactionManager {
    public double getRemainingBudget();
    public double getTotalExpense();
    public List<Transaction> getTransactionList();
    public boolean addTransaction(Transaction transaction);
}

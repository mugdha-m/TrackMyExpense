package com.example.trackmyexpense.utils;

import com.example.trackmyexpense.models.Expense;

import java.util.List;

public interface ExpenseManager {

    public double getRemainingBudget();
    public double getTotalExpense();
    public List<Expense> getExpenseList();
    public boolean addExpense(Expense expense);
}

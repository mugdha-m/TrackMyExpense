package com.example.trackmyexpense.utils;

import com.example.trackmyexpense.models.Expense;

import java.util.ArrayList;
import java.util.List;

public class ExpenseManagerImpl implements ExpenseManager {

    private double remainingBudget;
    private double totalExpense;
    private List<Expense> expenseList;

    public ExpenseManagerImpl() {
        this.remainingBudget = 1000d;
        this.totalExpense = 0d;
        this.expenseList = new ArrayList<>();
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
    public List<Expense> getExpenseList() {
        return expenseList;
    }

    @Override
    public boolean addExpense(Expense expense) {
        if (expense == null) {
            return false;
        }

        expenseList.add(expense);
        totalExpense = totalExpense + expense.getExpenseAmount();
        remainingBudget = remainingBudget - expense.getExpenseAmount();

        return true;
    }
}

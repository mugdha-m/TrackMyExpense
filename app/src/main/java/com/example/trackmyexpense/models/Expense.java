package com.example.trackmyexpense.models;

import java.util.Date;

public class Expense {

    private int expenseId;
    private int categoryId;
    private Date expenseDate;
    private double expenseAmount;

    public Expense() {

    }

    public Expense(int categoryId, Date expenseDate, double expenseAmount) {
        this.categoryId = categoryId;
        this.expenseDate = expenseDate;
        this.expenseAmount = expenseAmount;
    }

    public Expense(int expenseId, int categoryId, Date expenseDate, double expenseAmount) {
        this.expenseId = expenseId;
        this.categoryId = categoryId;
        this.expenseDate = expenseDate;
        this.expenseAmount = expenseAmount;
    }

    public int getExpenseId() {
        return expenseId;
    }

    public void setExpenseId(int expenseId) {
        this.expenseId = expenseId;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public Date getExpenseDate() {
        return expenseDate;
    }

    public void setExpenseDate(Date expenseDate) {
        this.expenseDate = expenseDate;
    }

    public double getExpenseAmount() {
        return expenseAmount;
    }

    public void setExpenseAmount(double expenseAmount) {
        this.expenseAmount = expenseAmount;
    }
}

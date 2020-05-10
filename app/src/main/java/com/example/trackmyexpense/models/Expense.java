package com.example.trackmyexpense.models;

import java.util.Date;

public class Expense {

    private String expenseName;
    private int expenseId;
    private int categoryId;
    private Date expenseDate;
    private Double expenseAmount;

    public Expense() {

    }

    public Expense(int categoryId, Date expenseDate, double expenseAmount, String expenseName) {
        this.categoryId = categoryId;
        this.expenseDate = expenseDate;
        this.expenseAmount = expenseAmount;
        this.expenseName = expenseName;
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

    public Double getExpenseAmount() {
        return expenseAmount;
    }

    public void setExpenseAmount(Double expenseAmount) {
        this.expenseAmount = expenseAmount;
    }

    public String getExpenseName() { return expenseName; }

    public void setExpenseName(String expenseName) { this.expenseName = expenseName; }
}

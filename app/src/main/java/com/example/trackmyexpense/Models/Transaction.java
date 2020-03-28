package com.example.trackmyexpense.Models;

import java.util.Date;

public class Transaction {
    private Category category;
    private Date date;
    double amount;

    public Transaction(Category category, Date date, double amount) {
        this.category = category;
        this.date = date;
        this.amount = amount;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}

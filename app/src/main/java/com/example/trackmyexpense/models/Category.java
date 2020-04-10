package com.example.trackmyexpense.models;

public class Category {

    private int categoryId;
    private int parentCategoryId;
    private String categoryName;

    public Category() {

    }

    public Category(int parentCategoryId, String categoryName) {
        this.parentCategoryId = parentCategoryId;
        this.categoryName = categoryName;
    }

    public Category(int categoryId, int parentCategoryId, String categoryName) {
        this.categoryId = categoryId;
        this.parentCategoryId = parentCategoryId;
        this.categoryName = categoryName;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public int getParentCategoryId() {
        return parentCategoryId;
    }

    public void setParentCategoryId(int parentCategoryId) {
        this.parentCategoryId = parentCategoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}

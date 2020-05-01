package com.example.trackmyexpense.storage;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.trackmyexpense.models.Category;
import com.example.trackmyexpense.models.Expense;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {

    // Database name and version
    private static final String DATABASE_NAME = "TrackMyExpense";
    private static final int DATABASE_VERSION = 1;

    // Table names based on models
    private static final String TABLE_CATEGORY = "Category";
    private static final String TABLE_EXPENSE = "Expense";

    // Category table keys
    private static final String KEY_CATEGORY_ID = "category_id";
    private static final String KEY_PARENT_CATEGORY_ID = "parent_category_id";
    private static final String KEY_CATEGORY_NAME = "category_name";

    // Expense table keys
    private static final String KEY_EXPENSE_ID = "expense_id";
    private static final String KEY_EXPENSE_DATE = "expense_date";
    private static final String KEY_EXPENSE_AMOUNT = "expense_amount";

    // Category table create query
    private static final String CREATE_TABLE_CATEGORY = "CREATE TABLE "
            + TABLE_CATEGORY + "("
            + KEY_CATEGORY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + KEY_PARENT_CATEGORY_ID + " INTEGER,"
            + KEY_CATEGORY_NAME + " TEXT"
            + ")";

    // Expense table create query
    private static final String CREATE_TABLE_EXPENSE = "CREATE TABLE "
            + TABLE_EXPENSE + "("
            + KEY_EXPENSE_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + KEY_CATEGORY_ID + " INTEGER,"
            + KEY_EXPENSE_DATE + " DATETIME,"
            + KEY_EXPENSE_AMOUNT + " REAL,"
            + " FOREIGN KEY (" + KEY_CATEGORY_ID + ") REFERENCES "
            + TABLE_CATEGORY + "(" + KEY_CATEGORY_ID + ")"
            + ")";

    // Category table delete query
    private static final String DELETE_TABLE_CATEGORY = "DROP TABLE IF EXISTS "
            + TABLE_CATEGORY;

    // Expense table delete query
    private static final String DELETE_TABLE_EXPENSE = "DROP TABLE IF EXISTS "
            + TABLE_EXPENSE;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_TABLE_CATEGORY);
        sqLiteDatabase.execSQL(CREATE_TABLE_EXPENSE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(DELETE_TABLE_CATEGORY);
        sqLiteDatabase.execSQL(DELETE_TABLE_EXPENSE);
        onCreate(sqLiteDatabase);
        sqLiteDatabase.close();
    }

    public void addCategory(Category category) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_PARENT_CATEGORY_ID, category.getParentCategoryId());
        values.put(KEY_CATEGORY_NAME, category.getCategoryName());

        long returnId = sqLiteDatabase.insert(TABLE_CATEGORY, null, values);
        sqLiteDatabase.close();

        //return returnId != -1;
    }

    public List<Category> getAllCategories() {
        List<Category> categories = new ArrayList<>();
        String selectQuery = "SELECT * FROM " + TABLE_CATEGORY;

        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery(selectQuery, null);

        // Looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Category category = new Category();
                category.setCategoryId(cursor.getInt((cursor.getColumnIndex(KEY_CATEGORY_ID))));
                category.setParentCategoryId((cursor.getInt(cursor.getColumnIndex(KEY_PARENT_CATEGORY_ID))));
                category.setCategoryName(cursor.getString(cursor.getColumnIndex(KEY_CATEGORY_NAME)));

                categories.add(category);
            } while (cursor.moveToNext());
        }
        cursor.close();
        sqLiteDatabase.close();

        return categories;
    }

    public void addExpense(Expense expense) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_CATEGORY_ID, expense.getCategoryId());
        values.put(KEY_EXPENSE_DATE, expense.getExpenseDate().getTime());
        values.put(KEY_EXPENSE_AMOUNT, expense.getExpenseAmount());

        long returnId = sqLiteDatabase.insert(TABLE_EXPENSE, null, values);
        sqLiteDatabase.close();

        //return returnId != -1;
    }

    public List<Expense> getAllExpenses() {
        List<Expense> expenses = new ArrayList<>();
        String selectQuery = "SELECT * FROM " + TABLE_EXPENSE;

        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery(selectQuery, null);

        // Looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Expense expense = new Expense();
                expense.setExpenseId(cursor.getInt((cursor.getColumnIndex(KEY_EXPENSE_ID))));
                expense.setCategoryId(cursor.getInt((cursor.getColumnIndex(KEY_CATEGORY_ID))));
                expense.setExpenseDate(new Date(cursor.getLong(cursor.getColumnIndex(KEY_EXPENSE_DATE))));
                expense.setExpenseAmount(cursor.getDouble(cursor.getColumnIndex(KEY_EXPENSE_AMOUNT)));

                expenses.add(expense);
            } while (cursor.moveToNext());
        }
        cursor.close();
        sqLiteDatabase.close();

        return expenses;
    }

}

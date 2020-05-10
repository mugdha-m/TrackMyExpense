package com.example.trackmyexpense.activities;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.trackmyexpense.R;
import com.example.trackmyexpense.adapters.ExpenseAdapter;
import com.example.trackmyexpense.models.Expense;
import com.example.trackmyexpense.storage.DatabaseHelper;
import com.example.trackmyexpense.utils.ExpenseManager;
import com.example.trackmyexpense.utils.ExpenseManagerImpl;

import java.util.List;

public class HomeActivity extends AppCompatActivity {

    DatabaseHelper mDatabaseHelper;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        mDatabaseHelper = new DatabaseHelper(this);

        ExpenseManager expenseManager = new ExpenseManagerImpl(mDatabaseHelper);
        List<Expense> arrayOfUsers = expenseManager.getExpenseList();
        ExpenseAdapter adapter = new ExpenseAdapter(this, arrayOfUsers);
        ListView listView = findViewById(R.id.list_expense);
        listView.setAdapter(adapter);
    }
}

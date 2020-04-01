package com.example.trackmyexpense;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.trackmyexpense.models.Category;
import com.example.trackmyexpense.models.Transaction;
import com.example.trackmyexpense.utils.TransactionManager;

import java.sql.Date;
import android.widget.Toast;

public class AddTransactionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_transaction);
    }

    public void submitTransaction(View button) {
        final EditText dateField = (EditText) findViewById(R.id.edit_date);
        String date = dateField.getText().toString();

        final EditText amountField = (EditText) findViewById(R.id.edit_amount);
        Double amount = Double.valueOf(amountField.getText().toString());

        final EditText categoryField = (EditText) findViewById(R.id.edit_category);
        String category = categoryField.getText().toString();

        Category cat = new Category(category, null);
        Transaction transaction = new Transaction(cat, Date.valueOf(date), amount);

        TransactionManager transactionManager = new TransactionManager();
        boolean result = transactionManager.addTransaction(transaction);

        Toast.makeText(getApplicationContext(), String.valueOf(result), Toast.LENGTH_SHORT).show();
    }
}

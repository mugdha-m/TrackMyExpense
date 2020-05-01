package com.example.trackmyexpense.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.SurfaceControl;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.trackmyexpense.R;
import com.example.trackmyexpense.models.Category;
import com.example.trackmyexpense.models.Expense;
import com.example.trackmyexpense.storage.DatabaseHelper;
import com.example.trackmyexpense.utils.ExpenseManagerImpl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class AddExpenseActivity extends AppCompatActivity {

    DatePickerDialog picker;
    EditText etext;
    DatabaseHelper mdatabaseHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_expense);
        mdatabaseHelper = new DatabaseHelper(this);

        final EditText edittext= (EditText) findViewById(R.id.edit_date);
        edittext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar cldr = Calendar.getInstance();
                int day = cldr.get(Calendar.DAY_OF_MONTH);
                int month = cldr.get(Calendar.MONTH);
                int year = cldr.get(Calendar.YEAR);

                picker = new DatePickerDialog(AddExpenseActivity.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                                edittext.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);
                            }
                        }, year, month, day);
                picker.show();
            }
        });

        etext = edittext;
    }

    public void submitExpense(View button) throws ParseException {
        Date date = new SimpleDateFormat("dd/MM/yyyy").parse(etext.getText().toString());

        EditText amountField = (EditText) findViewById(R.id.edit_amount);
        double amount = Double.parseDouble(amountField.getText().toString());

        EditText categoryField = (EditText) findViewById(R.id.edit_category);
        String category = categoryField.getText().toString();

        Category cat = new Category(1,0, category);
        Expense expense= new Expense(1, date, amount);

        ExpenseManagerImpl expenseManager = new ExpenseManagerImpl(mdatabaseHelper);
        boolean result = expenseManager.addExpense(expense);

        Toast.makeText(getApplicationContext(), String.valueOf(result), Toast.LENGTH_SHORT).show();
    }

}

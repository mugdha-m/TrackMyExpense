package com.example.trackmyexpense.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import com.example.trackmyexpense.R;
import com.example.trackmyexpense.models.Category;
import com.example.trackmyexpense.models.Expense;
import com.example.trackmyexpense.storage.DatabaseHelper;
import com.example.trackmyexpense.utils.ExpenseManager;
import com.example.trackmyexpense.utils.ExpenseManagerImpl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class AddExpenseActivity extends AppCompatActivity {

    DatePickerDialog picker;
    EditText eDate;
    DatabaseHelper mDatabaseHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_expense);
        mDatabaseHelper = new DatabaseHelper(this);

        final EditText editDate= (EditText) findViewById(R.id.edit_date);
        editDate.setOnClickListener(new View.OnClickListener() {
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
                                editDate.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);
                            }
                        }, year, month, day);
                picker.show();
            }
        });

        eDate = editDate;
    }

    public void submitExpense(View button) throws ParseException {
        Date date = new SimpleDateFormat("dd/MM/yyyy").parse(eDate.getText().toString());

        EditText amountField = (EditText) findViewById(R.id.edit_amount);
        double amount = Double.valueOf(amountField.getText().toString());

        EditText categoryField = (EditText) findViewById(R.id.edit_category);
        String categoryName = categoryField.getText().toString();

        EditText expenseNameField = (EditText) findViewById(R.id.edit_expense_name);
        String expenseName = expenseNameField.getText().toString();

        Category category = new Category(1,0, categoryName);
        Expense expense= new Expense(1, date, amount, expenseName);

        ExpenseManager expenseManager = new ExpenseManagerImpl(mDatabaseHelper);
        boolean result = expenseManager.addExpense(expense);

        Toast.makeText(getApplicationContext(), String.valueOf(result), Toast.LENGTH_SHORT).show();
    }
}

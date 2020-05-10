package com.example.trackmyexpense.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.trackmyexpense.R;
import com.example.trackmyexpense.models.Expense;

import java.text.SimpleDateFormat;
import java.util.List;

public class ExpenseAdapter extends ArrayAdapter<Expense> {
    private static class ViewHolder {
        TextView expenseDate;
        TextView expenseName;
        TextView expenseAmount;
        TextView expenseCategory;
    }
    public ExpenseAdapter(Context context, List<Expense> expenses) {
        super(context, 0, expenses);
    }

    public View getView(int position, View convertView, ViewGroup parent) {

        // Get the data item for this position
        Expense expense = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        ViewHolder viewHolder; // view lookup cache stored in tag
        if (convertView == null) {
            // If there's no view to re-use, inflate a brand new view for row
            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.item_expense, parent, false);
            viewHolder.expenseDate = (TextView) convertView.findViewById(R.id.text_date);
            viewHolder.expenseName = (TextView) convertView.findViewById(R.id.text_expense_name);
            viewHolder.expenseAmount = (TextView) convertView.findViewById(R.id.text_expense_amount);
            viewHolder.expenseCategory = (TextView) convertView.findViewById(R.id.text_expense_category);
            // Cache the viewHolder object inside the fresh view
            convertView.setTag(viewHolder);
        } else {
            // View is being recycled, retrieve the viewHolder object from tag
            viewHolder = (ViewHolder) convertView.getTag();
        }
        // Populate the data from the data object via the viewHolder object
        // into the template view.

        viewHolder.expenseDate.setText(new SimpleDateFormat("MM-dd-yyyy").format(expense.getExpenseDate()));
        viewHolder.expenseName.setText(expense.getExpenseName());
        viewHolder.expenseAmount.setText(expense.getExpenseAmount().toString());
        viewHolder.expenseCategory.setText("Category_1");
        // Return the completed view to render on screen
        return convertView;
    }
}

package com.example.mybudget.fragments;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.mybudget.R;
import com.example.mybudget.database.DatabaseHelper;
import com.example.mybudget.models.Operation;

public class FragmentAddOperation extends Fragment {
    private final String[] currencies = { "USD", "RUB", "EUR", "BYR", "ZLOTY" };
    private final String[] categories = { "Food", "Activities", "Technics",
            "Games", "Transport", "Taxes", "Investments", "Credit", "Gifts", "Salary", "Cigarettes",
            "Carsharing" };
    private final String[] types = { "Income", "Expense" };


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_add_operation, container, false);
    }

    @Override
    public void onViewCreated(@NonNull @org.jetbrains.annotations.NotNull View view,
                              @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initializeSpinners(view);
    }

    private void initializeSpinners(View view) {
        Spinner currency_spinner = view.findViewById(R.id.currency_spinner);
        ArrayAdapter<String> cur_adapter = new ArrayAdapter<>(
                requireActivity().getApplicationContext(),
                R.layout.spinner_item,
                currencies
        );

        cur_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        currency_spinner.setAdapter(cur_adapter);

        Spinner category_spinner = view.findViewById(R.id.category_spinner);
        ArrayAdapter<String> cat_adapter = new ArrayAdapter<>(
                requireActivity().getApplicationContext(),
                R.layout.spinner_item,
                categories
        );

        cat_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        category_spinner.setAdapter(cat_adapter);

        Spinner type_spinner = view.findViewById(R.id.type_spinner);
        ArrayAdapter<String> type_adapter = new ArrayAdapter<>(
                requireActivity().getApplicationContext(),
                R.layout.spinner_item,
                types
        );

        type_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        type_spinner.setAdapter(type_adapter);
    }
}

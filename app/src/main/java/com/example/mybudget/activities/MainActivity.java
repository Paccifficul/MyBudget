package com.example.mybudget.activities;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.example.mybudget.R;
import com.example.mybudget.database.DatabaseHelper;
import com.example.mybudget.fragments.FragmentAddOperation;
import com.example.mybudget.fragments.FragmentOperations;
import com.example.mybudget.models.Operation;

import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.io.File;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    private final Fragment fragmentOperations = new FragmentOperations(); // Создаем фрагмент операций
    private final Fragment fragmentAddOperation = new FragmentAddOperation();
    private Fragment previousFragment;
    private Fragment currentFragment;
    FragmentManager fragmentManager = getSupportFragmentManager(); // Создаем менеджер фрагментов

    private DatabaseHelper databaseHelper;
    private SQLiteDatabase db;
    private Cursor cursor;


    @SuppressLint("NonConstantResourceId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Иначе не работает, ставим на readonly, чтобы не было попыток записи
        @SuppressLint("SdCardPath")
        File jar = getCodeCacheDir();
        jar.setReadOnly();

        // Устанавливаем при старте приложения главную страницу
        fragmentManager.beginTransaction()
                .add(R.id.fragmentContainerView, fragmentOperations)
                .commit();
        currentFragment = fragmentOperations;
    }


    public void onClickAddOperation(View view) {
        previousFragment = currentFragment;
        fragmentManager.beginTransaction()
                .replace(R.id.fragmentContainerView, fragmentAddOperation)
                .commit();

        currentFragment = fragmentAddOperation;
    }

    public void onClickConfirmOperation(View view) {
        databaseHelper = new DatabaseHelper(getApplicationContext());

        db = databaseHelper.getWritableDatabase();

        try {
            databaseHelper.setData(db, getDataFromFragment());
        }
        catch (Exception ex) {
            Log.e("SQL ERROR", Objects.requireNonNull(ex.getMessage()));
        }

        currentFragment = fragmentOperations;
        fragmentManager.beginTransaction().replace(R.id.fragmentContainerView, fragmentOperations)
                .commit();
    }

    public void onClickBackward(View view) {
        fragmentManager.beginTransaction()
                .replace(R.id.fragmentContainerView, previousFragment)
                .commit();
        currentFragment = previousFragment;
    }

    private Operation getDataFromFragment() {
        String operationName = ((EditText) findViewById(R.id.editNameGoods))
                .getText().toString();
        String operationDate = ((EditText) findViewById(R.id.editOpDate))
                .getText().toString();
        String operationCategory = ((Spinner) findViewById(R.id.category_spinner))
                .getSelectedItem().toString();
        int operationSum = Integer.parseInt(((EditText) findViewById(R.id.editTextPrice))
                .getText().toString());
        String operationDescription = "test";
        String operationCurrency = ((Spinner) findViewById(R.id.currency_spinner))
                .getSelectedItem().toString();
        String operationType = ((Spinner) findViewById(R.id.type_spinner))
                .getSelectedItem().toString();

        return new Operation(
                operationName,
                operationDate,
                operationCurrency,
                operationSum,
                operationType,
                operationDescription,
                operationCategory
        );
    }
}

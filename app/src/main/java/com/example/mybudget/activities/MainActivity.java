package com.example.mybudget.activities;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.example.mybudget.R;
import com.example.mybudget.database.DatabaseHelper;
import com.example.mybudget.fragments.FragmentAddOperation;
import com.example.mybudget.fragments.FragmentOperations;

import android.database.sqlite.SQLiteDatabase;
import android.view.View;

import java.io.File;

public class MainActivity extends AppCompatActivity {
    private final Fragment fragmentOperations = new FragmentOperations(); // Создаем фрагмент операций
    private final Fragment fragmentAddOperation = new FragmentAddOperation();
    private DatabaseHelper operationsDbHelper;
    private SQLiteDatabase sqLiteDatabase;
    FragmentManager fragmentManager = getSupportFragmentManager(); // Создаем менеджер фрагментов

    @SuppressLint("NonConstantResourceId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Иначе не работает, тсавим на readonly, чтобы не было попыток записи
        @SuppressLint("SdCardPath")
        File jar = getCodeCacheDir();
        jar.setReadOnly();

        sqLiteDatabase = getBaseContext().
                openOrCreateDatabase("operations.db", MODE_PRIVATE, null);

        operationsDbHelper = new DatabaseHelper(getApplicationContext());

        // Устанавливаем при старте приложения главную страницу
        fragmentManager.beginTransaction()
                .add(R.id.fragmentContainerView, fragmentOperations)
                .commit();
    }

    @Override
    public void onResume() {
        super.onResume();
        sqLiteDatabase = operationsDbHelper.getWritableDatabase();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        sqLiteDatabase.close();
    }

    public void onClickAddOperation(View view) {
        fragmentManager.beginTransaction()
                .replace(R.id.fragmentContainerView, fragmentAddOperation)
                .commit();
    }
}

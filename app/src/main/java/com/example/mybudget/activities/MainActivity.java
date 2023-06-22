package com.example.mybudget.activities;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.example.mybudget.R;
import com.example.mybudget.fragments.FragmentBanks;
import com.example.mybudget.fragments.FragmentOperations;


public class MainActivity extends AppCompatActivity {
    private final Fragment fragmentOperations = new FragmentOperations(); // Создаем фрагмент домашней страницы
    private final Fragment fragmentBanks = new FragmentBanks(); // Создаем фрагмент профиля

    FragmentManager fragmentManager = getSupportFragmentManager(); // Создаем менеджер фрагментов

    @SuppressLint("NonConstantResourceId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Устанавливаем при старте приложения главную страницу
        fragmentManager.beginTransaction()
                .add(R.id.fragmentContainerView, fragmentBanks)
                .commit();
    }

    public void onClickAddOperation(@NonNull View view) {
        Intent newIntent = new Intent(MainActivity.this, AddOperationActivity.class);
        startActivity(newIntent);
    }

    public void openFragmentOperations() {
        fragmentManager.beginTransaction()
                .add(R.id.fragmentContainerView, fragmentOperations)
                .commit();
    }
}

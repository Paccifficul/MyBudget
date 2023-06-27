package com.example.mybudget.activities;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.example.mybudget.R;
import com.example.mybudget.fragments.FragmentBanks;


public class MainActivity extends AppCompatActivity {
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
}

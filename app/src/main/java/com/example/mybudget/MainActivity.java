package com.example.mybudget;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.example.mybudget.fragments.FragmentHome;
import com.example.mybudget.fragments.FragmentProfile;


public class MainActivity extends AppCompatActivity {
    Fragment fragmentHome = new FragmentHome(); // Создаем фрагмент домашней страницы
    Fragment fragmentProfile = new FragmentProfile(); // Создаем фрагмент профиля
    FragmentManager fragmentManager = getSupportFragmentManager(); // Создаем менеджер фрагментов

    @SuppressLint("NonConstantResourceId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // устанавливаем при старте приложения главную страницу
        fragmentManager.beginTransaction()
                .add(R.id.fragmentContainerView, fragmentHome)
                .commit();
    }
}

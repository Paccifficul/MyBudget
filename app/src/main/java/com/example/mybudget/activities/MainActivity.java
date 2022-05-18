package com.example.mybudget.activities;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Toolbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.example.mybudget.R;
import com.example.mybudget.fragments.FragmentHome;
import com.example.mybudget.fragments.FragmentProfile;


public class MainActivity extends AppCompatActivity {
    private final Fragment fragmentHome = new FragmentHome(); // Создаем фрагмент домашней страницы
    private final Fragment fragmentProfile = new FragmentProfile(); // Создаем фрагмент профиля

    FragmentManager fragmentManager = getSupportFragmentManager(); // Создаем менеджер фрагментов

    @SuppressLint("NonConstantResourceId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Устанавливаем при старте приложения главную страницу
        fragmentManager.beginTransaction()
                .add(R.id.fragmentContainerView, fragmentHome)
                .commit();
    }

    public void onClickAddOperation(@NonNull View view) {
        Intent newIntent = new Intent(MainActivity.this, AddOperationActivity.class);
        startActivity(newIntent);
    }
}

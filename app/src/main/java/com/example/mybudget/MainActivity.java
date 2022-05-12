package com.example.mybudget;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.example.mybudget.fragments.FragmentHome;
import com.example.mybudget.fragments.FragmentProfile;
import com.google.android.material.bottomnavigation.BottomNavigationView;


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

        // Создаем объект нижней панели, указываем её id
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        // Создаем Listener для отслеживания нажатой кнопки
        bottomNavigationView.setOnNavigationItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.page_home:
                    fragmentManager.beginTransaction()
                            .replace(R.id.fragmentContainerView, fragmentHome)
                            .commit();
                    break;
                case R.id.page_profile:
                    fragmentManager.beginTransaction()
                            .replace(R.id.fragmentContainerView, fragmentProfile)
                            .commit();
                    break;
                default:
                    break;
            }

            return true;
        });
    }
}

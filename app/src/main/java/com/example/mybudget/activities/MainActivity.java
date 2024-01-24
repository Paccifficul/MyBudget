package com.example.mybudget.activities;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.example.mybudget.R;
import com.example.mybudget.fragments.FragmentAddOperation;
import com.example.mybudget.fragments.FragmentOperations;

import android.view.View;

import java.io.File;

public class MainActivity extends AppCompatActivity {
    private final Fragment fragmentOperations = new FragmentOperations(); // Создаем фрагмент операций
    private final Fragment fragmentAddOperation = new FragmentAddOperation();
    private Fragment previousFragment;
    private Fragment currentFragment;
    FragmentManager fragmentManager = getSupportFragmentManager(); // Создаем менеджер фрагментов

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

    }

    public void onClickBackward(View view) {
        fragmentManager.beginTransaction()
                .replace(R.id.fragmentContainerView, previousFragment)
                .commit();
        currentFragment = previousFragment;
    }
}

package com.example.mybudget;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.mybudget.fragments.FragmentHome;
import com.example.mybudget.fragments.FragmentProfile;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(bottomNavSelected);
    }

    @SuppressLint("NonConstantResourceId")
    private final BottomNavigationView.OnNavigationItemSelectedListener bottomNavSelected = item -> {
        Fragment fragment = null;

        switch (item.getItemId()) {
            case R.id.page_home:
                fragment = new FragmentHome();
                break;
            case R.id.page_profile:
                fragment = new FragmentProfile();
                break;
        }

        assert fragment != null;
        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainerView, fragment).commit();
        return false;
    };
}

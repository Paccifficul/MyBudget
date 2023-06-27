package com.example.mybudget.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mybudget.R;
import com.example.mybudget.activities.MainActivity;
import com.example.mybudget.adapters.BankAdapter;
import com.example.mybudget.interfaces.OnBankClickListener;
import com.example.mybudget.models.BankHolder;

import java.util.ArrayList;

public class FragmentBanks extends Fragment {
    private final ArrayList<BankHolder> banks = new ArrayList<>();
    private final Fragment fragmentBankAccounts = new FragmentBankAccounts();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        setInitialData();
        return inflater.inflate(R.layout.fragment_banks, container, false);
    }

    @Override
    public void onViewCreated(@NonNull @org.jetbrains.annotations.NotNull View view,
                              @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        updateAdapter();
    }

    private void setInitialData() {
        banks.clear();
        banks.add(new BankHolder(R.drawable.ic_bank_alfa, "Альфа", "???"));
        banks.add(new BankHolder(R.drawable.ic_bank_tinkoff, "Тинькофф", "???"));
        banks.add(new BankHolder(R.drawable.ic_bank_sber, "Сбер", "???"));
    }

    private void updateAdapter() {
        RecyclerView recyclerView = requireView().findViewById(R.id.recycler_view_banks_list);

        OnBankClickListener bankClickListener = (bank, position) -> {
            assert getFragmentManager() != null;
            FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.fragmentContainerView, fragmentBankAccounts);
            fragmentTransaction.commit();
        };

        recyclerView.setAdapter(new BankAdapter(
                getLayoutInflater(), banks, bankClickListener));
    }
}

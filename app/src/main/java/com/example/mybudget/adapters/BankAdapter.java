package com.example.mybudget.adapters;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.app.FragmentManager;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mybudget.R;
import com.example.mybudget.activities.MainActivity;
import com.example.mybudget.fragments.FragmentOperations;
import com.example.mybudget.interfaces.OnBankClickListener;
import com.example.mybudget.models.BankHolder;

import java.util.List;
import java.util.Objects;

public class BankAdapter extends RecyclerView.Adapter<BankViewHolder> {
    private final OnBankClickListener onClickListener;
    private final LayoutInflater inflater;
    private final List<BankHolder> banks;
    private final FragmentOperations fragmentOperations = new FragmentOperations();

    public BankAdapter(LayoutInflater layoutInflater,
                       List<BankHolder> banks, OnBankClickListener onClickListener) {
        this.banks = banks;
        this.inflater = layoutInflater;
        this.onClickListener = onClickListener;
    }

    @NonNull
    @Override
    public BankViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new BankViewHolder(
                inflater.inflate(R.layout.bank_holder_recycler_view_item, parent, false)
        );
    }

    @SuppressLint("RecyclerView")
    @Override
    public void onBindViewHolder(@NonNull BankViewHolder holder, int position) {
        BankHolder bank = banks.get(position);

        holder.getBankBalance().setText(bank.getBankBalance());
        holder.getBankIcon().setImageResource(bank.getBankIcon());
        holder.getBankName().setText(bank.getBankName());


        holder.itemView.setOnClickListener(view -> onClickListener.onBankClick(bank, position));
    }

    @Override
    public int getItemCount() {
        return banks.size();
    }
}

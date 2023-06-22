package com.example.mybudget.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mybudget.R;

public class BankViewHolder extends RecyclerView.ViewHolder {
    private final ImageView bankIcon;
    private final TextView bankName;
    private final TextView bankBalance;

    public BankViewHolder(@NonNull View view) {
        super(view);
        bankBalance = view.findViewById(R.id.bankBalance);
        bankIcon = view.findViewById(R.id.bankIcon);
        bankName = view.findViewById(R.id.bankName);
    }

    public ImageView getBankIcon() {
        return bankIcon;
    }

    public TextView getBankBalance() {
        return bankBalance;
    }

    public TextView getBankName() {
        return bankName;
    }
}

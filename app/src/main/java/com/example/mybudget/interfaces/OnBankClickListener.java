package com.example.mybudget.interfaces;

import com.example.mybudget.models.BankHolder;

public interface OnBankClickListener {
    void onCardClick(BankHolder card, int position);
}

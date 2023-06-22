package com.example.mybudget.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mybudget.R;
import com.example.mybudget.interfaces.OnBankClickListener;
import com.example.mybudget.models.BankHolder;

import java.util.List;

public class BankAdapter extends RecyclerView.Adapter<BankViewHolder> {
    private final OnBankClickListener onClickListener;
    private final LayoutInflater inflater;
    private final List<BankHolder> cards;

    public BankAdapter(LayoutInflater layoutInflater,
                       List<BankHolder> cards,
                       OnBankClickListener onClickListener) {
        this.onClickListener = onClickListener;
        this.cards = cards;
        this.inflater = layoutInflater;
    }

    @NonNull
    @Override
    public BankViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new BankViewHolder(
                inflater.inflate(R.layout.bank_holder_recycler_view_item, parent, false)
        );
    }

    @Override
    public void onBindViewHolder(@NonNull BankViewHolder holder, int position) {
        BankHolder card = cards.get(position);

        holder.getBankBalance().setText(card.getBankBalance());
        holder.getBankIcon().setImageResource(card.getBankIcon());
        holder.getBankName().setText(card.getBankName());


        holder.itemView.setOnClickListener(view ->
                onClickListener.onCardClick(card, position));
    }

    @Override
    public int getItemCount() {
        return cards.size();
    }
}

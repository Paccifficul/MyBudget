package com.example.mybudget.adapter;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mybudget.R;

public class ViewHolder extends RecyclerView.ViewHolder {
    private final TextView operationName;
    private final TextView operationSum;
    private final TextView operationAuthor;
    private final TextView operationDate;
    private final TextView operationDesc;

    public ViewHolder(@NonNull View view) {
        super(view);
        operationName = view.findViewById(R.id.operation_name);
        operationSum = view.findViewById(R.id.operation_sum);
        operationAuthor = view.findViewById(R.id.operation_author);
        operationDate = view.findViewById(R.id.operation_date);
        operationDesc = view.findViewById(R.id.operation_description);
    }

    public TextView getOperationName() {
        return operationName;
    }

    public TextView getOperationSum() {
        return operationSum;
    }

    public TextView getOperationAuthor() {
        return operationAuthor;
    }

    public TextView getOperationDate() {
        return operationDate;
    }

    public TextView getOperationDesc() {
        return operationDesc;
    }
}

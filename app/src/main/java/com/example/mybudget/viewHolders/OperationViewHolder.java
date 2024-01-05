package com.example.mybudget.viewHolders;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mybudget.R;

public class OperationViewHolder extends RecyclerView.ViewHolder {
    private final TextView operationName;
    private final TextView operationSum;
    private final TextView operationDate;
    private final TextView operationDesc;
    private final TextView operationCategory;

    public OperationViewHolder(@NonNull View view) {
        super(view);
        operationName = view.findViewById(R.id.operation_name);
        operationSum = view.findViewById(R.id.operation_sum);
        operationDate = view.findViewById(R.id.operation_date);
        operationDesc = view.findViewById(R.id.operation_description);
        operationCategory = view.findViewById(R.id.operation_category);
    }

    public TextView getOperationName() {
        return operationName;
    }

    public TextView getOperationSum() {
        return operationSum;
    }

    public TextView getOperationDate() {
        return operationDate;
    }

    public TextView getOperationDesc() {
        return operationDesc;
    }

    public TextView getOperationCategory() { return operationCategory; }
}

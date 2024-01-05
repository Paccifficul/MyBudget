package com.example.mybudget.adapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mybudget.R;
import com.example.mybudget.interfaces.OnOperationClickListener;
import com.example.mybudget.models.Operation;
import com.example.mybudget.viewHolders.OperationViewHolder;

import java.util.List;

public class OperationAdapter extends RecyclerView.Adapter<OperationViewHolder> {
    private final OnOperationClickListener onClickListener;
    private final LayoutInflater inflater;
    private final List<Operation> operations;

    public OperationAdapter(LayoutInflater layoutInflater,
                            List<Operation> operations,
                            OnOperationClickListener onClickListener) {
        this.onClickListener = onClickListener;
        this.operations = operations;
        this.inflater = layoutInflater;
    }

    @NonNull
    @Override
    public OperationViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new OperationViewHolder(
                inflater.inflate(R.layout.operation_recycler_view_item, parent, false)
        );
    }

    @Override
    public void onBindViewHolder(@NonNull OperationViewHolder holder, int position) {
        Operation operation = operations.get(position);

        holder.getOperationName().setText(operation.getOperationName());
        holder.getOperationSum().setText(operation.getOperationSum());
        holder.getOperationDate().setText(operation.getOperationDate());
        holder.getOperationDesc().setText(operation.getOperationDesc());
        holder.getOperationCategory().setText(operation.getOperationCategory());

        holder.itemView.setOnClickListener(view ->
                onClickListener.onOperationClick(operation, position));
    }

    @Override
    public int getItemCount() {
        return operations.size();
    }
}

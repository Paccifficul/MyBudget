package com.example.mybudget.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mybudget.R;
import com.example.mybudget.interfaces.OnOperationClickListener;
import com.example.mybudget.models.Operation;

import java.util.List;

public class OperationAdapter extends RecyclerView.Adapter<ViewHolder> {
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
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(
                inflater.inflate(R.layout.operation_recycler_view_item, parent, false)
        );
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Operation operation = operations.get(position);

        holder.getOperationName().setText(operation.getOperationName());
        holder.getOperationSum().setText(operation.getOperationSum());
        holder.getOperationAuthor().setText(operation.getOperationAuthor());
        holder.getOperationDate().setText(operation.getOperationDate());
        holder.getOperationDesc().setText(operation.getOperationDesc());

        holder.itemView.setOnClickListener(view ->
                onClickListener.onOperationClick(operation, position));
    }

    @Override
    public int getItemCount() {
        return operations.size();
    }
}

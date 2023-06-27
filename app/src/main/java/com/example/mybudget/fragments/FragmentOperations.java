package com.example.mybudget.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.mybudget.R;
import com.example.mybudget.adapters.OperationAdapter;
import com.example.mybudget.interfaces.OnOperationClickListener;
import com.example.mybudget.models.Operation;

import java.util.ArrayList;

public class FragmentOperations extends Fragment {
    private final ArrayList<Operation> operations = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        setInitialData();
        return inflater.inflate(R.layout.fragment_operations, container, false);
    }

    @Override
    public void onViewCreated(@NonNull @org.jetbrains.annotations.NotNull View view,
                              @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        updateAdapter();
    }

    private void setInitialData() {
        operations.clear();
        // for (int i = 0; i < 20; i++)
        operations.add(new Operation(
                "Теремок",
                "04.01.2022",
                341,
                "No Description"));
    }

    private void updateAdapter() {
        RecyclerView recyclerView = requireView().findViewById(R.id.recycler_view_operations_list);
        OnOperationClickListener operationClickListener = (operation, position) ->
                Toast.makeText(getContext(), "message", Toast.LENGTH_LONG).show();

        recyclerView.setAdapter(new OperationAdapter(
                getLayoutInflater(), operations, operationClickListener));
    }
}
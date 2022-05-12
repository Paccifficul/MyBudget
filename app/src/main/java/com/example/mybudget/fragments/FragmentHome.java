package com.example.mybudget.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.mybudget.R;
import com.example.mybudget.adapter.OperationAdapter;
import com.example.mybudget.interfaces.OnOperationClickListener;
import com.example.mybudget.models.Operation;

import java.util.ArrayList;

public class FragmentHome extends Fragment {
    ArrayList<Operation> operations = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.recycler_view_operations_list);

        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));

        setInitialData();

        // Определяем слушателя нажатия элемента в списке
        OnOperationClickListener operationClickListener = (operation, position) ->
                Toast.makeText(view.getContext(), "message", Toast.LENGTH_SHORT).show();

        recyclerView.setAdapter(new OperationAdapter(view.getContext(), operations, operationClickListener));

        return view;
    }

    private void setInitialData() {
        operations.clear();
        operations.add(new Operation(
                "Теремок",
                "Дмитрий",
                "04.01.2022",
                943));
    }
}
package com.example.mybudget.fragments;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.mybudget.R;
import com.example.mybudget.adapters.OperationAdapter;
import com.example.mybudget.database.DatabaseHelper;
import com.example.mybudget.interfaces.OnOperationClickListener;
import com.example.mybudget.models.Operation;

import java.util.ArrayList;
import java.util.Objects;

public class FragmentOperations extends Fragment {
    private final ArrayList<Operation> operations = new ArrayList<>();
    private DatabaseHelper databaseHelper;
    private SQLiteDatabase db;
    private Cursor cursor;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_operations, container, false);
    }

    @Override
    public void onViewCreated(@NonNull @org.jetbrains.annotations.NotNull View view,
                              @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setInitialData();
    }

    private void setInitialData() {
        operations.clear();

        databaseHelper = new DatabaseHelper(requireActivity().getApplicationContext());

        Thread getBdData = new Thread(() -> {

        });

       // getBdData.start();

        db = databaseHelper.getReadableDatabase();

        try {
            databaseHelper.createTable(db);
            cursor = databaseHelper.getData(db);


            if (cursor.getCount() == 0) {
                setDataInFragment(false);
                Log.e("TAG", "empty");
                return;
            } else {
                setDataInFragment(true);
                Log.e("TAG", "Sosi");

                while (cursor.moveToNext()) {
                    operations.add(
                            new Operation(
                                    cursor.getString(1),
                                    cursor.getString(3),
                                    cursor.getString(6),
                                    cursor.getInt(5),
                                    cursor.getString(7),
                                    cursor.getString(4),
                                    cursor.getString(2)
                            )
                    );
                }
            }

            updateAdapter();
            db.close();
            cursor.close();
        }
        catch (Exception ex) {
            Log.e("ERROR", Objects.requireNonNull(ex.getMessage()));
        }
    }

    private void updateAdapter() {
        RecyclerView recyclerView = requireView().findViewById(R.id.recycler_view_operations_list);
        OnOperationClickListener operationClickListener = (operation, position) ->
                Toast.makeText(getContext(), "message", Toast.LENGTH_LONG).show();

        recyclerView.setAdapter(new OperationAdapter(
                getLayoutInflater(), operations, operationClickListener));
    }

    @SuppressLint("ResourceType")
    private void setDataInFragment(boolean type) {
        int data;
        if (!type) {
            data = R.layout.empty_operations_recycler_view;
        }
        else {
            data = R.layout.recycler_view_element;
        }

        FragmentData.setData(data);
    }
}
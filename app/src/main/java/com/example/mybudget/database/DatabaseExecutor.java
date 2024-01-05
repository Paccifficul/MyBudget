package com.example.mybudget.database;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.SimpleCursorAdapter;

import com.example.mybudget.models.Operation;

import java.util.ArrayList;

public class DatabaseExecutor {
    private final DatabaseHelper databaseHelper;
    private SQLiteDatabase sqLiteDatabase;
    private Cursor cursor;
    private SimpleCursorAdapter cursorAdapter;
    private ArrayList<Operation> operations;

    public DatabaseExecutor(DatabaseHelper databaseHelper) {
        this.databaseHelper = databaseHelper;
    }

    public ArrayList<Operation> getData() {
        operations = new ArrayList<Operation>();
        /*sqLiteDatabase = databaseHelper.getReadableDatabase();

        cursor = sqLiteDatabase.rawQuery("SELECT * FROM " + DatabaseHelper.TABLE, null);

        if (cursor.moveToFirst()) {
            do {
                operations.add(new Operation(
                        cursor.getInt(0),
                        cursor.getString(1),
                        cursor.getString(5),
                        cursor.getInt(4),
                        cursor.getString(2),
                        cursor.getString(3)
                ));
            } while (cursor.moveToNext());
        }

        cursor.close();
        sqLiteDatabase.close();*/
        return operations;
    }

    public void addTransaction(Operation operation) {
        sqLiteDatabase = databaseHelper.getWritableDatabase();
    }

    public void updateTransaction(Operation operation) {

    }

    public void removeTransaction(Operation operation) {

    }
}

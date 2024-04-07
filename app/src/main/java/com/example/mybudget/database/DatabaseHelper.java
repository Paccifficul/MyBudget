package com.example.mybudget.database;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.Context;

import com.example.mybudget.models.Operation;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "operations.db";
    private static final int SCHEMA = 1;
    static final String TABLE_NAME = "data";

    public static final String COLUMN_ID = "id";
    public static final String COLUMN_OPERATION_NAME = "operName";
    public static final String COLUMN_OPERATION_DATE = "operDate";
    public static final String COLUMN_OPERATION_DESCRIPTION = "operDesc";
    public static final String COLUMN_OPERATION_SUM = "operSum";
    public static final String COLUMN_OPERATION_CATEGORY = "operCat";
    public static final String COLUMN_OPERATION_CURRENCY = "operCur";
    public static final String COLUMN_OPERATION_TYPE = "operType";


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, SCHEMA);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    public void createTable(SQLiteDatabase db) {db.execSQL(
                "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + " ("
                        + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_OPERATION_NAME + " TEXT, "
                        + COLUMN_OPERATION_CATEGORY + " TEXT, " + COLUMN_OPERATION_DATE + " DATE, "
                        + COLUMN_OPERATION_DESCRIPTION + " TEXT, " + COLUMN_OPERATION_SUM + " INTEGER, "
                        + COLUMN_OPERATION_CURRENCY + " TEXT, " + COLUMN_OPERATION_TYPE + " TEXT);"
        );

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public Cursor getData(SQLiteDatabase db) {
        if (!db.isOpen()) return null;

        return db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
    }

    public void setData(SQLiteDatabase db, Operation newOperation) {
        db.execSQL("INSERT INTO " + TABLE_NAME + " (" + COLUMN_OPERATION_NAME + ", "
                + COLUMN_OPERATION_CATEGORY + ", " + COLUMN_OPERATION_DATE + ", "
                + COLUMN_OPERATION_DESCRIPTION + ", " + COLUMN_OPERATION_SUM + ", "
                + COLUMN_OPERATION_CURRENCY + ", " + COLUMN_OPERATION_TYPE + ") VALUES ("
                + newOperation.getOperationName() + ", " + newOperation.getOperationCategory()
                + ", " + newOperation.getOperationDate() + ", " + newOperation.getOperationDesc()
                + ", " + newOperation.getOperationSumINT() + ", " + newOperation.getOperationCurrency()
                + ", " + newOperation.getOperationType() + ");");
    }

    private void dropTable(SQLiteDatabase db) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
    }
}

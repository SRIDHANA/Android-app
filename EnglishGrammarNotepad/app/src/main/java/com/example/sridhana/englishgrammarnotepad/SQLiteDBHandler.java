package com.example.sridhana.englishgrammarnotepad;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sridhana on 3/17/2017.
 */

public class SQLiteDBHandler  extends SQLiteOpenHelper {
    // Database Version
    private static final int DATABASE_VERSION = 1;
    // Database Name
    private static final String DATABASE_NAME = "userInfo";
    // Contacts table name
    private static final String TABLE_USERS = "users";
    // AccDetails Table Columns names
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "user_name";
    private static final String KEY_PASS = "password";
    private static final String KEY_EMAIL = "email";
    private static final String KEY_PHONE = "phone";
    private static final String KEY_SH_ADDR = "user_address";

    public SQLiteDBHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_CONTACTS_TABLE = "CREATE TABLE " + TABLE_USERS + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_NAME + " TEXT,"
                + KEY_PASS + " TEXT," + KEY_EMAIL + " TEXT,"
                + KEY_PHONE + " TEXT,"
                + KEY_SH_ADDR + " TEXT" + ")";
        db.execSQL(CREATE_CONTACTS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
// Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USERS);
// Creating tables again
        onCreate(db);
    }

    // Adding new AccDetails
    public void addAccDetails(AccDetails AccDetails) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME, AccDetails.getName());
        values.put(KEY_PASS, AccDetails.getAddress());
        values.put(KEY_EMAIL, AccDetails.getEmail());
        values.put(KEY_PHONE, AccDetails.getPhone());
        values.put(KEY_SH_ADDR, AccDetails.getAddress1());

// Inserting Row
        db.insert(TABLE_USERS, null, values);
        db.close(); // Closing database connection
    }


    // Getting one AccDetails
    public AccDetails getAccDetails(int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_USERS, new String[]{KEY_ID,
                        KEY_NAME, KEY_PASS, KEY_EMAIL, KEY_PHONE, KEY_SH_ADDR}, KEY_ID + "=?",
                new String[]{String.valueOf(id)}, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        AccDetails contact = new AccDetails(Integer.parseInt(cursor.getString(0)),
                cursor.getString(1), cursor.getString(2),
                cursor.getString(3), cursor.getString(4),
                cursor.getString(5));
// return AccDetails
        return contact;
    }


    // Getting All AccDetails
    public List<AccDetails> getAllAccDetails() {
        List<AccDetails> AccDetailsList = new ArrayList<AccDetails>();
// Select All Query
        String selectQuery = "SELECT * FROM " + TABLE_USERS;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

// looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                AccDetails AccDetails = new AccDetails();
                AccDetails.setId(Integer.parseInt(cursor.getString(0)));
                AccDetails.setName(cursor.getString(1));
                AccDetails.setAddress(cursor.getString(2));
                AccDetails.setEmail(cursor.getString(3));
                AccDetails.setPhone(cursor.getString(4));
                AccDetails.setAddress1(cursor.getString(5));

// Adding contact to list
                AccDetailsList.add(AccDetails);
            } while (cursor.moveToNext());
        }

// return contact list
        return AccDetailsList;
    }

    // Getting AccDetails Count
    public int getAccDetailsCount() {
        String countQuery = "SELECT * FROM " + TABLE_USERS;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();

// return count
        return cursor.getCount();
    }

    // Updating a AccDetails
    public int updateAccDetails(AccDetails AccDetails) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME, AccDetails.getName());
        values.put(KEY_PASS, AccDetails.getAddress());
        values.put(KEY_EMAIL, AccDetails.getEmail());
        values.put(KEY_PHONE, AccDetails.getPhone());
        values.put(KEY_SH_ADDR, AccDetails.getAddress1());

// updating row
        return db.update(TABLE_USERS, values, KEY_ID + " = ?",
                new String[]{String.valueOf(AccDetails.getId())});
    }

    // Deleting a AccDetails
    public void deleteAccDetails(AccDetails AccDetails) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_USERS, KEY_ID + " = ?",
                new String[]{String.valueOf(AccDetails.getId())});
        db.close();
    }

}


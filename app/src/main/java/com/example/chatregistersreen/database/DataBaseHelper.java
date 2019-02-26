package com.example.chatregistersreen.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.chatregistersreen.database.model.Registration;

public class DataBaseHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "form_db";




    public DataBaseHelper(Context context) {
        super(context, DATABASE_NAME,  null, DATABASE_VERSION);
    }
// overide function to create sql dataBase

    @Override
    public void onCreate(SQLiteDatabase db) {
        //  this implies that database.ececuteSQL then pass the CREATE_TABLE method of your model class "registratrion"
        db.execSQL(Registration.CREATE_TABLE);

    }
// on upgrade method only works when you want to update or change ur DB to a newer version
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        //check if table already exists , if it does , delete and create a new one
        db.execSQL("DROP TABLE IF EXISTS " + Registration.TABLE_NAME);
        onCreate(db);

    }

    //this method writes/saves to dataBase
    // it collects an argument of things to save

    public long insertUser ( String fullname , String phone, String location , String email , String password )
            throws SQLException {
        // getWritable , mates it able to write to th dB
        SQLiteDatabase db = this.getWritableDatabase();
        //
        ContentValues values = new ContentValues();
        //used to save argument passed in this insetUser method to the DBase
        values.put(Registration.COLUMN_FULLNAME , fullname);
        values.put(Registration.COLUMN_PHONENUMBER , phone);
        values.put(Registration.COLUMN_EMAIL , email);
        values.put(Registration.COLUMN_LOCATION , location);
        values.put(Registration.COLUMN_PASSWORD , password);

        //saves values to Reg.tablename
        long id = db.insert(Registration.TABLE_NAME , null , values);
        // closes dBase
        db.close();

        return id;


    }

    public Cursor readFromDBase (SQLiteDatabase db) {

        String [] projections = {Registration.COLUMN_ID, Registration.COLUMN_EMAIL ,
                Registration.COLUMN_PASSWORD ,Registration.COLUMN_PHONENUMBER,};

        Cursor cursor = db.query( Registration.TABLE_NAME, projections , null ,
                null , null, null ,  null);

        db.close();

        return cursor;
    }

}

package com.example.olal.sqiltedbforandroid;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by olal on 2/28/17.
 */

public class DBHandler  extends SQLiteOpenHelper {

    //All static variables
    //determine the Database version

    private static final int DATABASE_VERSION = 1;

    //Database Name
    private static final String DATABASE_NAME = "student";

    //Contacts table name
    private  static final String TABLE_STUDENT_DETAIL = "studentDetails";

    //Contacts Table Columns names

    private static final String KEY_ID = "id";
    private static final String KEY_ENROLL_NO = "enroll_no";
    private static final String KEY_NAME = "name";
    private static final String KEY_PHONE_NO = "phone_number";



    public DBHandler (Context context){ super(context, DATABASE_NAME, null, DATABASE_VERSION);

//creating tables


        @Override
        public void onCreate(SQLiteDatabase db) {

            String CREATE_STUDENT_DETAIL_TABLE = "CREATE TABLE" + TABLE_STUDENT_DETAIL + "("

                    + KEY_ID + " INTEGER PRIMARY KEY,"
                    + KEY_ENROLL_NO + " TEXT,"
                    + KEY_NAME + " TEXT,"
                    + KEY_PHONE_NO + " TEXT " + ")";

            db.execSQL(CREATE_STUDENT_DETAIL_TABLE);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

            //Drop older table if existed
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_STUDENT_DETAIL);

            //Create tables again
            onCreate(db);

        }

    }



}

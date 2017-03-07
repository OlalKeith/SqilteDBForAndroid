package com.example.olal.sqiltedbforandroid.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.olal.sqiltedbforandroid.model.MyWish;

import java.util.ArrayList;
import java.util.Date;


//A dbhandler class will handle our data

    //sqliteopenhelper helps instatiate our database, create our database and so forth
public class DBHandler extends SQLiteOpenHelper {

        //Arraylist of MyWish class
        private final ArrayList<MyWish> wishList = new ArrayList<>();

    public DBHandler(Context context) {
        super(context, Constants.DATABASE_NAME, null, Constants.DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
//create our table

        String CREATE_WISHES_TABLE = "CREATE TABLE" + Constants.TABLE_NAME +
                "(" + Constants.KEY_ID + " INTEGER PRIMARY KEY, " + Constants.TITLE_NAME + " TEXT, "
                + Constants.CONTENT_NAME + " TEXT, " + Constants.DATE_NAME + " LONG );";

        db.execSQL(CREATE_WISHES_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + Constants.TABLE_NAME);

        //create a new one
        onCreate(db);
    }

    //add content to table
        public  void addWshes(MyWish wish){

            SQLiteDatabase db = this.getWritableDatabase();

            ContentValues values = new ContentValues();
            values.put(Constants.TITLE_NAME, wish.getTitle());
            values.put(Constants.CONTENT_NAME, wish.getContent());
            values.put(Constants.DATE_NAME, java.lang.System.currentTimeMillis());

            db.insert(Constants.TABLE_NAME, null, values);
            db.close();
        }


        //Get all

        public ArrayList<MyWish> getWishes(){

            String selectQuery = "SELECT * FROM " + Constants.TABLE_NAME;

            SQLiteDatabase db = this.getReadableDatabase();

            Cursor cursor = db.query(Constants.TABLE_NAME, new String[]{Constants.KEY_ID,
                    //Constants.DATE_NAME + "DESC" in descending order
                    Constants.TITLE_NAME, Constants.CONTENT_NAME, Constants.DATE_NAME,}, null, null, null, null, Constants.DATE_NAME + "DESC");


            //loop through cusrsor

            if (cursor.moveToFirst()){

                do {
                    MyWish wish = new MyWish();
                    wish.setTitle(cursor.getString(cursor.getColumnIndex(Constants.TITLE_NAME)));
                    wish.setContent(cursor.getString(cursor.getColumnIndex(Constants.CONTENT_NAME)));

                    java.text.DateFormat dateFormat = java.text.DateFormat.getDateInstance();
                    String dataData = dateFormat.format(new Date(cursor.getLong(cursor.getColumnIndex(Constants.DATE_NAME))));


                    wish.setRecordDate(dataData);

                    wishList.add(wish);

                }while (cursor.moveToFirst());
            }

            return wishList;
        }
}

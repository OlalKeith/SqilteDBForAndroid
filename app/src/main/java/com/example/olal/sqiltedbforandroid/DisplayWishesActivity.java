package com.example.olal.sqiltedbforandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.olal.sqiltedbforandroid.data.DBHandler;
import com.example.olal.sqiltedbforandroid.model.MyWish;

import java.util.ArrayList;


public class DisplayWishesActivity extends AppCompatActivity {
//instantiate a databasehandler
    private DBHandler dba;
    //create an arraylist list which will contain our list.
    //the dbwishes will hold all our wishes
    private ArrayList<MyWish> dbWishes = new ArrayList<>();
    private WishAdapter wishAdapter;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_wishes);

        listView = (ListView) findViewById(R.id.list);

        //refresh method data
        refreshData();
    }

    //this is where we fetch our table and get data  frm db that we have previously saved
    private void refreshData() {

        dbWishes.clear();
        dba = new DBHandler(getApplicationContext());

        ArrayList<MyWish> wishesFromDB = dba.getWishes();

        for (int i = 0; i < wishesFromDB.size(); i++){

            String title = wishesFromDB.get(i).getTitle();
            String dateText = wishesFromDB.get(i).getRecordDate();
            String content = wishesFromDB.get(i).getContent();

            MyWish myWish = new MyWish();
            myWish.setTitle(title);
            myWish.setContent(content);
            myWish.setRecordDate(dateText);

            dbWishes.add(myWish);

        }

        dba.close();
    }
}

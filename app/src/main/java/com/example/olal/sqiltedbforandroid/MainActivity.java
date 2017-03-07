package com.example.olal.sqiltedbforandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.olal.sqiltedbforandroid.data.DBHandler;
import com.example.olal.sqiltedbforandroid.model.MyWish;

public class MainActivity extends AppCompatActivity {

    private EditText title;
    private EditText content;
    private Button saveButton;
    private DBHandler dba;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dba = new DBHandler(MainActivity.this);

        title = (EditText) findViewById(R.id.titleEditText);
        content = (EditText) findViewById(R.id.wishEditText);
        saveButton = (Button) findViewById(R.id.saveButton);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveToDB();
            }
        });
    }
//populating database
    private void saveToDB() {
        //adding what our users entering in our text
        MyWish wish = new MyWish();
        wish.setTitle(title.getText().toString().trim());
        wish.setTitle(content.getText().toString().trim());

        dba.addWshes(wish);
        dba.close();

        //clear our phone once the users click submit
        title.setText("");
        content.setText("");

        Intent i = new Intent(MainActivity.this, WishDetailActivity.class);
                startActivity(i);
    }
}

package com.landayan.landayan_labquiz;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    TextView tv_author, tv_quote;
    Button btn_back;
    SharedPreferences preferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        tv_author = (TextView) findViewById(R.id.tv_author);
        tv_quote = (TextView) findViewById(R.id.tv_quote);
        btn_back = (Button) findViewById(R.id.btn_back);

        preferences = getSharedPreferences("prefer", Context.MODE_WORLD_READABLE);

        String author = preferences.getString("author","");
        String quote = preferences.getString("quote","");

        tv_author.setText(author + " said:");
        tv_quote.setText("'"+ quote + "'");
    }

    public void goBack(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}

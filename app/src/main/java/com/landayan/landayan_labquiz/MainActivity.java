package com.landayan.landayan_labquiz;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText et_author, et_quote;
    Button btn_save, btn_next;
    SharedPreferences preferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_author = (EditText) findViewById(R.id.et_author);
        et_quote = (EditText) findViewById(R.id.et_quote);
        btn_save = (Button) findViewById(R.id.btn_save);
        btn_next = (Button) findViewById(R.id.btn_next);

        preferences = getSharedPreferences("prefer", Context.MODE_WORLD_READABLE);
    }

    public void saveQuote(View view) {
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("author", et_author.getText().toString());
        editor.putString("quote", et_quote.getText().toString());
        editor.commit();
        Toast.makeText(this, "Saved using Shared Preferences!", Toast.LENGTH_LONG).show();
    }

    public void goNext(View view) {
        Intent intent = new Intent(this, Main2Activity.class);
        startActivity(intent);
        finish();
    }
}

package com.example.sqlite_db_assignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {
    TextView t;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
         t =  (TextView) findViewById(R.id.textView) ;
        Intent x = getIntent();
        String name = x.getStringExtra("coursee_name");
        t.setText(name);

        //Toast.makeText(getApplicationContext(), name , Toast.LENGTH_LONG).show();
    }
}
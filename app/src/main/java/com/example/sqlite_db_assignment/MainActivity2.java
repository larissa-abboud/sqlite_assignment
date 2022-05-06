package com.example.sqlite_db_assignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {
    TextView t;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        // t =  (TextView) findViewById(R.id.textView) ;
        Intent x = getIntent();
        String name = x.getStringExtra("coursee_name");
       // t.setText(name);
        WebView view = (WebView) findViewById(R.id.webview);
        view.getSettings().setJavaScriptEnabled(true);
        view.setWebViewClient( new WebViewClient());
        Log.i("list",""+name);
        view.loadUrl(name);
        //view.loadData("<html> <body> <h1> Hello World! </h1> </body> </html>", "text/html; charset=UTF-8", null);

        //Toast.makeText(getApplicationContext(), name , Toast.LENGTH_LONG).show();
    }
}
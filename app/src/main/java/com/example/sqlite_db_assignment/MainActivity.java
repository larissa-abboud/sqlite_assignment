package com.example.sqlite_db_assignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
String flag ;
boolean name ;
String[] options ;
ArrayList the_list;
ArrayAdapter adapter;
ListView my_list;
    int x = 0;

@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    my_list = (ListView) findViewById(R.id.myList);
        try{

            SQLiteDatabase sql = this.openOrCreateDatabase("coursedb", MODE_PRIVATE, null);
            sql.execSQL("CREATE Table IF NOT EXISTS final (course_name VARCHAR ,final_exam_timeDate VARCHAR)");
            //sql.execSQL("DROP  coursedb ");//create a table
           // sql.execSQL("INSERT INTO final(course_name ,final_exam_timeDate ) VALUES ('mobil' , 'may 13' )  ");
            //sql.execSQL("INSERT INTO final(course_name,final_exam_timeDate ) VALUES ('cp3' , 'may 16' )  ");
           // sql.execSQL("INSERT INTO final(course_name ,final_exam_timeDate ) VALUES ('co' , 'may 12' )  ");

            Cursor c = sql.rawQuery("Select * from final", null);
            int fnameIndex = c.getColumnIndex("course_name");
            int lnameIndex = c.getColumnIndex("final_exam_timeDate");

            c.moveToFirst();



            while(c!= null & c.getCount()>x){
                x++;
                String name = c.getString(fnameIndex) + " " + c.getString(lnameIndex);

                Toast.makeText(getApplicationContext(), name, Toast.LENGTH_LONG).show();
                c.moveToNext();
            }
/**
 * create list view that stores*/
options = new String[]{"mobile : may 13 ","co : may 12","cp3 : may16"};

            the_list = new ArrayList<String>(Arrays.asList(options));


            adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,the_list);
            my_list.setAdapter(adapter);
            my_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    Toast.makeText(getApplicationContext(), ""+the_list.get(i), Toast.LENGTH_SHORT).show();
                    Intent obj = new Intent(getApplicationContext(), MainActivity2.class);
                    obj.putExtra("coursee_name", ""+the_list.get(i));

                    startActivity(obj);

                }
            });



            /**
             * if it does loop
             * so we don't insert
             * else we do
             *
             * or cond: it is not in,then we add*/

int i =0;



        }catch(Exception e){
            e.printStackTrace();
        }

    }
}
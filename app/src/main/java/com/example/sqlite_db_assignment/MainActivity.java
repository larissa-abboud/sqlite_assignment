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
ArrayList the_list , the_list2;
ArrayAdapter adapter;
ListView my_list;
    int x=0,j=0;

@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    my_list = (ListView) findViewById(R.id.myList);
        try{

            SQLiteDatabase sql = this.openOrCreateDatabase("coursedb", MODE_PRIVATE, null);
            sql.execSQL("CREATE Table IF NOT EXISTS finalss (course_name VARCHAR ,final_exam_timeDate VARCHAR ,web_url VARCHAR)");
            //sql.execSQL("DROP  coursedb ");//create a table
           // sql.execSQL("INSERT INTO finalss(course_name ,final_exam_timeDate,web_url ) VALUES ('mobil' , 'may 13','https://www.w3schools.com/sql/sql_drop_table.asp')  ");
           //sql.execSQL("INSERT INTO finalss(course_name,final_exam_timeDate,web_url ) VALUES ('cp3' , 'may 16','https://www.tutorialspoint.com/data_structures_algorithms/dsa_quick_guide.htm' )  ");
           //sql.execSQL("INSERT INTO finalss(course_name ,final_exam_timeDate,web_url ) VALUES ('co' , 'may 12','https://www.geeksforgeeks.org/last-minute-notes-computer-organization/' )  ");
            //sql.execSQL("DELETE FROM finalss where course_name = 'mobil'");
           //sql.execSQL("DELETE FROM finalss where course_name = 'cp3'");
            //sql.execSQL("DELETE FROM finalss where course_name = 'co'");


            Cursor c = sql.rawQuery("Select * from finalss", null);
            int fnameIndex = c.getColumnIndex("course_name");
            int lnameIndex = c.getColumnIndex("final_exam_timeDate");
            int wnameIndex = c.getColumnIndex("web_url");

            c.moveToFirst();
            //insert web url in database as well.


            String[] list = new String[c.getCount()];
             options = new String[c.getCount()];

            while(c!= null & c.getCount()>x){

                String name = c.getString(fnameIndex) + "        " + c.getString(lnameIndex);
                list[x] =  c.getString(wnameIndex);
                options[x] = name;
               // the_list.add(x ,name);
                Log.i("url",list[x]);
                Toast.makeText(getApplicationContext(), name, Toast.LENGTH_LONG).show();
                c.moveToNext(); x++;
            }the_list = new ArrayList<String>(Arrays.asList(list));
            the_list2 = new ArrayList<String>(Arrays.asList(options));
            for(j=0  ; j< c.getCount();j++){
               // Log.i("list",""+the_list.get(j)+""+j);

            }
/**
 * create list view that stores*/




            adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,the_list2);
            my_list.setAdapter(adapter);
            my_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    //Toast.makeText(getApplicationContext(), ""+the_list.get(i), Toast.LENGTH_SHORT).show();
                    Intent obj = new Intent(getApplicationContext(), MainActivity2.class);
                    //Log.i("list",""+the_list2.get(i));
                    obj.putExtra("coursee_name", ""+the_list.get(i));

                    startActivity(obj);

                }
            });








        }catch(Exception e){
            e.printStackTrace();
        }

    }
}
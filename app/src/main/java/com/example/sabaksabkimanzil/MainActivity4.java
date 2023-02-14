package com.example.sabaksabkimanzil;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        // this  is for main activity first button
        RecyclerView rc=findViewById(R.id.recycleractivityfour);
        DBHelper dbHelper=new DBHelper(this);
        StudentRecord std1=new StudentRecord();

        ArrayList<StudentRecord> list=dbHelper.getAllData();

        if(list.isEmpty())
        {
            Toast.makeText(this, "list is empty", Toast.LENGTH_SHORT).show();
        }
        StudentRecordAdapter adapters=new StudentRecordAdapter(list,this)   ;
        rc.setAdapter(adapters);
        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        rc.setLayoutManager(layoutManager);

    }
}
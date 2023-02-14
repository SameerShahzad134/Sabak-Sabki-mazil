package com.example.sabaksabkimanzil;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {

    // this activity is for recycler view to show all studnet details
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        RecyclerView rc=findViewById(R.id.recyclerView);

        DBHelper dbHelper=new DBHelper(this);

        ArrayList<Student> list=dbHelper.getAllStudent();
        StudentAdapter adapters=new StudentAdapter(list,this)   ;
        rc.setAdapter(adapters);
        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        rc.setLayoutManager(layoutManager);
    }
}
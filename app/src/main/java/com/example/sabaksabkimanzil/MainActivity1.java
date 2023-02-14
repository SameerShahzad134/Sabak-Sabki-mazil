package com.example.sabaksabkimanzil;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
public class MainActivity1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);

        Button addstd=findViewById(R.id.button);
        Button stdHistory=findViewById(R.id.stdHistoryMain);

        addstd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent inten=new Intent(MainActivity1.this,AddStudent.class);
                startActivity(inten);
            }
        });

        stdHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity1.this, MainActivity4.class);
                startActivity(intent);
            }
        });


    }
}
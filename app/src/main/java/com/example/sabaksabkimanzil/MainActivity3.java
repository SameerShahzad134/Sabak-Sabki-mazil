package com.example.sabaksabkimanzil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity3 extends AppCompatActivity {

    static int manzil=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faltu);
        // this is for the when we add click add record

        Button homepagebac=findViewById(R.id.buttonBack);
        Button addStdInfo=findViewById(R.id.buttonSubmit);
        EditText pararno=findViewById(R.id.editTextParano);
        EditText ayats=findViewById(R.id.editTextSAyat);
        EditText ayate=findViewById(R.id.editTextEAyat);


        homepagebac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity3.this,MainActivity1.class);
                startActivity(intent);
            }
        });
        DBHelper dbHelper=new DBHelper(this);
        addStdInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent intent=getIntent();
                String stdName=intent.getStringExtra("name");
                String paranoText=pararno.getText().toString();
                String ayatsText=ayats.getText().toString();
                String ayateText=ayate.getText().toString();

                int sabqi = Integer.parseInt(paranoText)-1;


               if (manzil==Integer.parseInt(paranoText))
                {
                    manzil =1;


                }

                 Boolean b=dbHelper.insert(stdName,paranoText,ayatsText,ayateText,String.valueOf(sabqi),String.valueOf(manzil+1));
                if(b)
                    {
                       Toast.makeText(MainActivity3.this, "student record added", Toast.LENGTH_SHORT).show();
                  }
                   else{
                        Toast.makeText(MainActivity3.this,0, Toast.LENGTH_SHORT).show();
                   }




            }
        });



    }
}
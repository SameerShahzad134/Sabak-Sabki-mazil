package com.example.sabaksabkimanzil;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class AddStudent extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_student);

        EditText txt1=findViewById(R.id.editTextTextPersonName);
        Button addStudent=findViewById(R.id.addStudentToList);
        Button view=findViewById(R.id.id2);

        DBHelper d=new DBHelper(this);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent inten=new Intent(AddStudent.this,MainActivity2.class);
                startActivity(inten);

            }
        });


        addStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                String name=txt1.getText().toString();
                if(!name.isEmpty())
                {
                    Boolean b=d.insertStd(name);
                    if(b)
                    {
                        Toast.makeText(AddStudent.this, name.toString(), Toast.LENGTH_SHORT).show();
                    }
                }
                Intent inten=new Intent(AddStudent.this,MainActivity2.class);
                startActivity(inten);

            }
        });

    }
}
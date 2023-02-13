package com.example.sabaksabkimanzil;


import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.viewHolder> {

    ArrayList<Student> list;
    Context context;
    //    create constructor of the both of the following will be used in the main class
    public StudentAdapter(ArrayList<Student> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.studentlayout,parent,false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        Student model=list.get(position);
        holder.name.setText(model.getName());
        holder.age.setText(model.getAge());

        // us pory item pe kahi pe click karo to ye onclick khul jay ga
        // pory 1 cardview pe click karo kahi b to new activity pe chalay jain gay
        holder.btnaddRec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent=new Intent(context,MainActivity3.class);
                intent.putExtra("name",model.getName());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        //        cardview (which is our layout) ko hum idher hi inflate kar lety ha

        TextView name;
        TextView age;
        Button btnaddRec;

        public viewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.Name);
            age = itemView.findViewById(R.id.Age);
            btnaddRec = itemView.findViewById(R.id.addrec);
        }
    }
}

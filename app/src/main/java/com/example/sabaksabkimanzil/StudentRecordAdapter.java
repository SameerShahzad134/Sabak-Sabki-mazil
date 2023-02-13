package com.example.sabaksabkimanzil;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class StudentRecordAdapter extends RecyclerView.Adapter<StudentRecordAdapter.viewHolder> {

    ArrayList<StudentRecord> list;
    Context context;
    //    create constructor of the both of the following will be used in the main class
    public StudentRecordAdapter(ArrayList<StudentRecord> list, Context context) {

        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.stdrecord,parent,false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        StudentRecord model=list.get(position);
        holder.stdrecname.setText(model.getName());
        holder.stdrecdate.setText("Date: "+ model.getDate());
        holder.stdrecmanzil.setText("Mazil:"+ model.getManzil());
        holder.stdrecayats.setText("starting Ayat: "+model.getAyats());
        holder.stdrecayate.setText("Ending ayat: "+model.getAyate());
        holder.stdreclastsabaq.setText("Sabaqi :"+model.getLastSabaq());
        holder.stdrecparano.setText("Parha no :"+model.getParano());



    }



    @Override
    public int getItemCount() {
        return list.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        //        cardview (which is our layout) ko hum idher hi inflate kar lety ha

        TextView stdrecname;
        TextView stdrecparano;
        TextView stdrecayats;
        TextView stdrecayate;

        TextView stdreclastsabaq;
        TextView stdrecmanzil;
        TextView stdrecdate;


        public viewHolder(@NonNull View itemView) {
            super(itemView);
            stdrecname = itemView.findViewById(R.id.stdrecname);
            stdrecparano = itemView.findViewById(R.id.stdrecparano);
            stdrecayats = itemView.findViewById(R.id.stdrecayats);
            stdrecayate= itemView.findViewById(R.id.stdrecayate);
            stdreclastsabaq= itemView.findViewById(R.id.stdrecLastsabaq);
            stdrecmanzil = itemView.findViewById(R.id.stdrecManzil);
            stdrecdate = itemView.findViewById(R.id.stdrecdate);
        }
    }
}


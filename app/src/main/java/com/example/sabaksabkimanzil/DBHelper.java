package com.example.sabaksabkimanzil.;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class DBHelper extends SQLiteOpenHelper
{

    public DBHelper(Context context ) {
        super(context, "Sabaq1.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

       String tbl1= "create Table std"+ "(id int primary key," +"name Text)";
        db.execSQL(tbl1);

       String table2="create Table studentrecord"+
                "(id int primary key," +
                "stdname Text," +
                "parano Text," +
                "ayats Text," +
                "ayate Text," +
                "lastsabaq Text," +
                "date Text," +
                "manzil Text)";

       db.execSQL(table2);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP Table if exists studentrecord");
        db.execSQL("DROP Table if exists std");
    }

    public boolean insert(String stdname,String parano,String ayats,String ayate,String lastsabaq,String manzil) {
        SQLiteDatabase mydb = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("stdname", stdname);
        contentValues.put("parano", parano);
        contentValues.put("ayats", ayats);
        contentValues.put("ayate", ayate);
        contentValues.put("lastsabaq", lastsabaq);
        contentValues.put("manzil", manzil);
        String date = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date());
        contentValues.put("date", date);


        long result = mydb.insert("studentrecord", null, contentValues);

        mydb.close();
        if(result==-1)
        {
            return  false;
        }
        return true;

    }

    public boolean insertStd(String name) {
        SQLiteDatabase mydb = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);
        long result = mydb.insert("std", null, contentValues);

        mydb.close();
        if(result==-1)
        {
            return false;
        }
        return true;

    }
    public int getManzil (String name)
    {
        SQLiteDatabase mydb=this.getWritableDatabase();
        Cursor cursor=mydb.rawQuery("select manzil from studentrecord where stdname=?",new String[]{String.valueOf(name)});
        int val=1;
        if (cursor.moveToFirst()) {

            if (cursor.getString(0).isEmpty())
            {
                val=1;
            }
            else {
                val = Integer.parseInt(cursor.getString(0));
            }
        }
        return val;

    }


    public ArrayList<Student> getAllStudent()
    {
        ArrayList<Student> list=new ArrayList<>();
        SQLiteDatabase mydb=this.getWritableDatabase();
        Cursor cursor=mydb.rawQuery("select name from std",null);
        if(cursor.moveToFirst())
        {
            while(cursor.moveToNext())
            {
                Student  q=new Student();
                q.setName(cursor.getString(0));
                list.add(q);
            }
        }
        cursor.close();
        mydb.close();
        return list;
    }

    public ArrayList<StudentRecord> getAllData()
    {
//        String table2="create Table studentrecord"+
//                "(id int primary key," +
//                "stdname Text," +
//                "parano Text," +
//                "ayats Text," +
//                "ayate Text," +
//                "lastsabaq Text," +
//                "date Text," +
//                "manzil Text)";
        ArrayList<StudentRecord> list=new ArrayList<>();
        SQLiteDatabase mydb=this.getWritableDatabase();
        Cursor cursor=mydb.rawQuery("select * from studentrecord",null);
        if(cursor.moveToFirst())
        {
            while(cursor.moveToNext())
            {
                StudentRecord q=new StudentRecord();
                q.setName(cursor.getString(1));
                q.setParano(cursor.getString(2));
                q.setAyats(cursor.getString(3));
                q.setAyate(cursor.getString(4));

                q.setLastSabaq(cursor.getString(5));
                q.setManzil(cursor.getString(7));
                q.setDate(cursor.getString(6));


                list.add(q);
            }
        }
        cursor.close();
        mydb.close();
        return list;
    }


}

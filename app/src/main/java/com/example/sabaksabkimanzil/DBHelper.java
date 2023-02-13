package com.example.sabaksabkimanzil;



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

public class DBHelper extends SQLiteOpenHelper {

    public DBHelper(Context context) {
        super(context, "Sabaq1.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String tbl1 = "create Table std" + "(id int primary key," + "name Text)";
        db.execSQL(tbl1);

        String table2 = "create Table studentrecord" +
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
}

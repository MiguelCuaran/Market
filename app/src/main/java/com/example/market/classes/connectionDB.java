package com.example.market.classes;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class connectionDB extends SQLiteOpenHelper {


    public connectionDB(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    //instanciar con market
    public void onCreate(SQLiteDatabase market) {
        //Create table(s)
        market.execSQL("create table users(" +
                "id integer primary key autoincrement," +
                "firstname text not null," +
                "lastname text not null," +
                "email text not null," +
                "password text not null)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}

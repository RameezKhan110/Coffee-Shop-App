package com.example.coffeeshoffee;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.coffeeshoffee.Models.CartModels;
import com.example.coffeeshoffee.Models.MainModel;

import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {

    final static String DBNAME = "mydatabse.db";
    final static int DBVERSION = 1;


    public DBHelper(@Nullable Context context){
        super(context, DBNAME, null,  DBVERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(
                "create table orders " +
                        "(id integer primary key autoincrement," +
                        "name text," +
                        "phone text," +
                        "price int," +
                        "quantity int," +
                        "image int," +
                        "foodname text)"
        );

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE if exists orders");
        onCreate(db);

    }

    public boolean insert(String names, String phone, int price, int quantity, int image, String foodname){
        SQLiteDatabase database = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("name", names);
        values.put("phone", phone);
        values.put("price", price);
        values.put("quantity", quantity);
        values.put("image", image);
        values.put("foodname", foodname);
        long id = database.insert("orders", null, values);
        if(id<= 0){
            return false;
        } else{
            return true;
        }
    }

    public  ArrayList<CartModels> getOrders(){
        ArrayList<CartModels> orders = new ArrayList<>();
        SQLiteDatabase database = this.getReadableDatabase();
        Cursor cursor = database.rawQuery("Select id, foodname, price, image from orders", null);
        if(cursor.moveToFirst()){
            while(cursor.moveToNext()){
                CartModels models = new CartModels();
                models.setCartorderNumber(cursor.getString(0)+"");
                models.setCartname(cursor.getString(1));
                models.setCartimage(cursor.getInt(2));
                models.setCartprice(cursor.getInt(3)+"");
                orders.add(models);

            }
        }
        cursor.close();
        database.close();
        return orders;
    }

}


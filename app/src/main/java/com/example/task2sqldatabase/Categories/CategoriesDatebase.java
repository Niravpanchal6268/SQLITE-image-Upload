package com.example.task2sqldatabase.Categories;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Bitmap;
import android.util.Log;

import com.example.task2sqldatabase.Categories.ModelCategories;

import java.io.ByteArrayOutputStream;

public class CategoriesDatebase extends SQLiteOpenHelper {
    private static final String DBName = "Category";
    private static final int DBVersion = 1;
    private ByteArrayOutputStream byteArrayOutputStream;
    private byte[] imagebytes;
    private Context context;

    public CategoriesDatebase(Context context) {
        super(context, DBName, null, DBVersion);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("create table categories(c_id integer primary key autoincrement,CategoriesName text,CategoriesImage Blod)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("drop table if exists categories");
        onCreate(db);
    }

    public void storedate(ModelCategories modelCategories) {
        SQLiteDatabase db = this.getWritableDatabase();
        Bitmap imagestoretobitmap = modelCategories.getCategoriesImage();

        byteArrayOutputStream = new ByteArrayOutputStream();
        imagestoretobitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
        imagebytes = byteArrayOutputStream.toByteArray();

        ContentValues contentValues = new ContentValues();
        contentValues.put("CategoriesName", modelCategories.getCategoriesName());
        contentValues.put("CategoriesImage", imagebytes);

        long checkIfQueryrun = db.insert("categories", null, contentValues);
        if (checkIfQueryrun != 1) {
            Log.d("InsertCategories", "Successfully");

        } else {
            Log.d("InsertCategories", "Fail to add data");
        }


    }

    public Cursor getCategories() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("Select * from categories", null);
        return cursor;

    }

    public Cursor GetCategoriesName() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select CategoriesName  from categories", null);
        return cursor;
    }


}

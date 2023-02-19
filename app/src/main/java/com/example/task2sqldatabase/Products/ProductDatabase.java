package com.example.task2sqldatabase.Products;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Bitmap;
import android.util.Log;

import androidx.annotation.Nullable;

import java.io.ByteArrayOutputStream;

public class ProductDatabase extends SQLiteOpenHelper {
    private  static final  String DBName="Products";
    private  static final int DBVersion=1;
    private ByteArrayOutputStream byteArrayOutputStream;
    private byte[] imagebytes;
    public ProductDatabase(Context context) {
        super(context, DBName, null,DBVersion);


    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table Product(p_id integer primary key autoincrement,ProductName text,ProductPrice text,ProductDiscount text,ProductDisPrice text,ProductCategories text,ProductDescription text,ProductImage blob)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists Product");
        onCreate(db);

    }

    public void AddProduct(ModelProducts modelProducts)
    {

        SQLiteDatabase db=this.getWritableDatabase();

        Bitmap bitmap=modelProducts.getProductImage();
        byteArrayOutputStream=new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG,100,byteArrayOutputStream);
        imagebytes=byteArrayOutputStream.toByteArray();

        ContentValues contentValues=new ContentValues();
        contentValues.put("ProductName",modelProducts.getProductName());
        contentValues.put("ProductPrice",modelProducts.getProductPrice());
        contentValues.put("ProductDiscount",modelProducts.getProductDiscount());
        contentValues.put("ProductDisPrice",modelProducts.getProductDiscountPrice());
        contentValues.put("ProductCategories",modelProducts.getProductCategories());
        contentValues.put("ProductDescription",modelProducts.getProductDescription());
        contentValues.put("ProductImage",imagebytes);


        long insert=db.insert("Product",null,contentValues);

        if (insert==-1)
        {
            Log.d("insert product","Successfully data insert");
        }
        else {
            Log.d("insert product","fail to data insert");
        }


    }
    public Cursor GetAllProducts()
    {
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor=db.rawQuery("select * from Product",null);
        return  cursor;
    }

    public Cursor GetProductList(String Categoryname)
    {
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor=db.rawQuery("Select * from product where ProductCategories=? ",new String[]{Categoryname});
        return cursor;
    }



}

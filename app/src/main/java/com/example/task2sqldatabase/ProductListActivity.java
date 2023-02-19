package com.example.task2sqldatabase;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;

import com.example.task2sqldatabase.Products.ModelP;
import com.example.task2sqldatabase.Products.ModelProducts;
import com.example.task2sqldatabase.Products.ProductAdapterClasss;
import com.example.task2sqldatabase.Products.ProductDatabase;

import java.util.ArrayList;

public class ProductListActivity extends AppCompatActivity {

    RecyclerView productlistrecyclerview;
    String CategoryName=null;
    ProductDatabase productDatabase;
    ProductAdapterClasss productAdapterClasss;
    ArrayList<ModelP> modelProductsArrayList=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_list);


        CategoryName=getIntent().getStringExtra("Categoryname");
        getSupportActionBar().setTitle(CategoryName);
        productlistrecyclerview=findViewById(R.id.productlist_recyclerview_id);
        productDatabase=new ProductDatabase(this);



        Cursor cursor=productDatabase.GetProductList(CategoryName);

        while (cursor.moveToNext())
        {
           ModelP modelP=new ModelP();
            modelP.setProductName(cursor.getString(1));
            modelP.setProductPrice(cursor.getString(2));
            modelP.setProductDiscount(cursor.getString(3));
            modelP.setProductDiscountPrice(cursor.getString(4));
            modelP.setProductDescription(cursor.getString(6));
            byte[] pimage=cursor.getBlob(cursor.getColumnIndexOrThrow("ProductImage"));
            modelP.setProductImage(pimage);
            modelProductsArrayList.add(modelP);
        }
        productAdapterClasss=new ProductAdapterClasss(this,modelProductsArrayList);
        productlistrecyclerview.setLayoutManager(new GridLayoutManager(this,2));
        productlistrecyclerview.setAdapter(productAdapterClasss);
        productAdapterClasss.notifyDataSetChanged();








    }
}
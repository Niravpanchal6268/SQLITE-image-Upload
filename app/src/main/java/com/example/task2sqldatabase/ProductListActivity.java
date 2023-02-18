package com.example.task2sqldatabase;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;

import com.example.task2sqldatabase.Products.ModelProducts;
import com.example.task2sqldatabase.Products.ProductAdapterClasss;
import com.example.task2sqldatabase.Products.ProductDatabase;

import java.util.ArrayList;

public class ProductListActivity extends AppCompatActivity {

    RecyclerView productlistrecyclerview;
    String CategoryName=null;
    ProductDatabase productDatabase;
    ProductAdapterClasss productAdapterClasss;
    ArrayList<ModelProducts> modelProductsArrayList=new ArrayList<>();
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
//            modelProductsArrayList.add(new ModelProducts(cursor.getString(1),cursor.getString(2)
//                    ,cursor.getString(3),cursor.getString(4),cursor.getString(6)));
        }
        productAdapterClasss=new ProductAdapterClasss(this,modelProductsArrayList);
        productlistrecyclerview.setLayoutManager(new GridLayoutManager(this,2));
        productlistrecyclerview.setAdapter(productAdapterClasss);
        productAdapterClasss.notifyDataSetChanged();








    }
}
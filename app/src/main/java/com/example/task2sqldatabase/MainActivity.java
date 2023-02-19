package com.example.task2sqldatabase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.task2sqldatabase.Categories.AddCategoriesActivity;
import com.example.task2sqldatabase.Categories.CategoriesAdapaterClass;
import com.example.task2sqldatabase.Categories.CategoriesDatebase;
import com.example.task2sqldatabase.Categories.Model;
import com.example.task2sqldatabase.Products.AddItemActivity;
import com.example.task2sqldatabase.Products.ModelP;
import com.example.task2sqldatabase.Products.ModelProducts;
import com.example.task2sqldatabase.Products.ProductAdapterClasss;
import com.example.task2sqldatabase.Products.ProductDatabase;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView categories_recyclerview, products_recyclerview;
    ArrayList<Model> modelCategoriesArrayList = new ArrayList<>();
    ArrayList<ModelP> modelProductsArrayList = new ArrayList<>();
    CategoriesDatebase db;
    ProductAdapterClasss productAdapterClasss;
    ProductDatabase productDatabase;
    Cursor cursor;
    TextView protext,cattext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        categories_recyclerview = findViewById(R.id.categories_recycler_view_id);
        products_recyclerview = findViewById(R.id.product_recyclerview_id);
        protext=findViewById(R.id.product_text_m_a_id);
        cattext=findViewById(R.id.categories_text_m_a_id);
        db = new CategoriesDatebase(this);



        categories_recyclerview.setLayoutManager(new GridLayoutManager(this, 3));
        cursor = db.getCategories();

        while (cursor.moveToNext()) {
            String catname = cursor.getString(1);
            byte[] cateimge = cursor.getBlob(cursor.getColumnIndexOrThrow("CategoriesImage"));
//            Bitmap bitmap= BitmapFactory.decodeByteArray(cateimge,0,cateimge.length);

            Model model=new Model();
            model.setCatename(catname);
            model.setCateimage(cateimge);
            modelCategoriesArrayList.add(model);

        }

        CategoriesAdapaterClass categoriesAdapaterClass = new CategoriesAdapaterClass(this, modelCategoriesArrayList);
        categories_recyclerview.setAdapter(categoriesAdapaterClass);
        categoriesAdapaterClass.notifyDataSetChanged();

        productAdapterClasss = new ProductAdapterClasss(this, modelProductsArrayList);
        products_recyclerview.setLayoutManager(new GridLayoutManager(this, 2));
        productDatabase = new ProductDatabase(this);

        cursor = productDatabase.GetAllProducts();
        while (cursor.moveToNext()) {

            System.out.println(cursor.getString(1));
            System.out.println(cursor.getString(2));
            System.out.println(cursor.getString(3));
            System.out.println(cursor.getString(4));
            System.out.println(cursor.getString(6));
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

        products_recyclerview.setAdapter(productAdapterClasss);
        categoriesAdapaterClass.notifyDataSetChanged();



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Intent intent;
        switch (item.getItemId()) {
            case R.id.add_categories_m_id:
                Toast.makeText(this, "add categories", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(MainActivity.this, AddCategoriesActivity.class));
                return true;
            case R.id.add_item_m_id:
                Toast.makeText(this, "add item", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(MainActivity.this, AddItemActivity.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);

        }

    }
}
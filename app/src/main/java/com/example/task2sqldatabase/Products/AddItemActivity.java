package com.example.task2sqldatabase.Products;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.task2sqldatabase.Categories.CategoriesDatebase;
import com.example.task2sqldatabase.R;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputLayout;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.single.PermissionListener;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class AddItemActivity extends AppCompatActivity {

    Spinner products_spinner;
    CategoriesDatebase categoriesDatebase;
    ArrayList categories = new ArrayList();

    TextInputLayout product_name, product_price, product_dicount, product_description;
    MaterialButton addproduct_btn;
    ProductDatabase productDatabase;
    ImageView productimage;
    private Uri imagepath;
    private Bitmap imagetostore;
    String P_Name, P_Price, P_Dicount, P_Description, P_Category, P_Discout_Price;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);
        getSupportActionBar().setTitle("Add Item");
        categoriesDatebase = new CategoriesDatebase(this);
        products_spinner = findViewById(R.id.products_spinner_id);
        product_name = findViewById(R.id.products_name_input_id);
        product_dicount = findViewById(R.id.products_discount_input_id);
        product_price = findViewById(R.id.products_price_input_id);
        product_description = findViewById(R.id.products_description_input_id);
        addproduct_btn = findViewById(R.id.add_product_btn_id);
        productDatabase = new ProductDatabase(this);
        Cursor cursor = categoriesDatebase.GetCategoriesName();
        while (cursor.moveToNext()) {
            categories.add(cursor.getString(0));
        }

        ArrayAdapter adapter = new ArrayAdapter(this, com.karumi.dexter.R.layout.support_simple_spinner_dropdown_item, categories);
        products_spinner.setAdapter(adapter);
        productimage = findViewById(R.id.product_image_id);

        productimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(AddItemActivity.this, "image pick", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(intent, 1);
            }
        });


        addproduct_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                P_Name = product_name.getEditText().getText().toString();
                P_Price = product_price.getEditText().getText().toString();
                P_Dicount = product_dicount.getEditText().getText().toString();
                P_Description = product_description.getEditText().getText().toString();
                P_Category = products_spinner.getSelectedItem().toString();

                if (P_Name.isEmpty() || P_Description.isEmpty() || P_Dicount.isEmpty() || P_Price.isEmpty()) {
                    Toast.makeText(AddItemActivity.this, "Fill the fields", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(AddItemActivity.this, "fill", Toast.LENGTH_SHORT).show();
                    long p = Long.parseLong(P_Price);
                    long d = Long.parseLong(P_Dicount);
                    long total = 100 - d;
                    long dp = (total * p) / 100;
                    P_Discout_Price = String.valueOf(dp);
                    productDatabase.AddProduct(new ModelProducts(P_Name, P_Price, P_Dicount, P_Discout_Price, P_Category, P_Description,imagetostore));

                    Toast.makeText(AddItemActivity.this, "add product successfully", Toast.LENGTH_SHORT).show();


                }


            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == 1 && resultCode == RESULT_OK) {
            try {
                imagepath = data.getData();
                imagetostore = MediaStore.Images.Media.getBitmap(getContentResolver(), imagepath);
                productimage.setImageBitmap(imagetostore);

            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        super.onActivityResult(requestCode, resultCode, data);
    }
}
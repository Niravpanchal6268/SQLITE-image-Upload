package com.example.task2sqldatabase.Categories;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.task2sqldatabase.MainActivity;
import com.example.task2sqldatabase.R;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputLayout;


import java.io.IOException;

public class AddCategoriesActivity extends AppCompatActivity {
    ImageView categories_imageView;
    TextInputLayout categories_nameinput;
    private Uri imagePath;
    private Bitmap imagetostore;
    CategoriesDatebase db;
    MaterialButton categoriesbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_categories);
        getSupportActionBar().setTitle("Add Item");

        categories_imageView = findViewById(R.id.categories_image_id);
        categories_nameinput=findViewById(R.id.categoies_name_id);
        categoriesbtn=findViewById(R.id.add_categories_btn_id);
        categoriesbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                storedata();
            }
        });
        categories_imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(AddCategoriesActivity.this, "Pick Image from gallery", Toast.LENGTH_SHORT).show();
                Intent intent=new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(intent, 1);

                 db=new CategoriesDatebase(AddCategoriesActivity.this);



//                Dexter.withContext(AddCategoriesActivity.this)
//                        .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
//                        .withListener(new PermissionListener() {
//                            @Override
//                            public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
//                                Intent intent=new Intent();
//                                intent.setType("image/*");
//                                intent.setAction(Intent.ACTION_GET_CONTENT);
//                                startActivityForResult(intent, 1);
//                            }
//
//                            @Override
//                            public void onPermissionDenied(PermissionDeniedResponse permissionDeniedResponse) {
//
//                            }
//
//                            @Override
//                            public void onPermissionRationaleShouldBeShown(PermissionRequest permissionRequest, PermissionToken permissionToken) {
//
//                                    permissionToken.continuePermissionRequest();
//
//                            }
//                        }).check();


            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == 1 && resultCode == RESULT_OK) {

            try {
                imagePath = data.getData();
                imagetostore = MediaStore.Images.Media.getBitmap(getContentResolver(), imagePath);
                categories_imageView.setImageBitmap(imagetostore);

            } catch (IOException e) {
                throw new RuntimeException(e);

            }

        }
        super.onActivityResult(requestCode, resultCode, data);

    }
    private void storedata()
    {
        if (categories_nameinput.getEditText().getText().toString().isEmpty()||imagetostore==null)
        {
            Toast.makeText(this, "fill the filds", Toast.LENGTH_SHORT).show();
        }
        else {
            db.storedate(new ModelCategories(categories_nameinput.getEditText().getText().toString(),imagetostore));
            Toast.makeText(this, "successfully add", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(AddCategoriesActivity.this, MainActivity.class));
            finish();

        }

    }
}
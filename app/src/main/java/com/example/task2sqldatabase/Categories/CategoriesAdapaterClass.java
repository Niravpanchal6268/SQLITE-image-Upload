package com.example.task2sqldatabase.Categories;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.task2sqldatabase.ProductListActivity;
import com.example.task2sqldatabase.R;

import java.util.ArrayList;

public class CategoriesAdapaterClass extends RecyclerView.Adapter<CategoriesAdapaterClass.CategoriesViewHolderClass> {

    private Context context;
    private ArrayList<Model> modelCategoriesArrayList;

    public CategoriesAdapaterClass(Context context, ArrayList<Model> modelCategoriesArrayList) {
        this.context = context;
        this.modelCategoriesArrayList = modelCategoriesArrayList;
    }

    @NonNull
    @Override
    public CategoriesViewHolderClass onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.categories_single_card, parent, false);
        return new CategoriesViewHolderClass(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoriesViewHolderClass holder, int position) {

        final Model modelCategories = modelCategoriesArrayList.get(position);

        holder.categoies_name_textView.setText(modelCategories.getCatename());
        byte[] image = modelCategories.getCateimage();
        Bitmap bitmap = BitmapFactory.decodeByteArray(image, 0, image.length);
        holder.categoires_imageView.setImageBitmap(bitmap);

        holder.categoires_imageView.setImageBitmap(bitmap);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ProductListActivity.class);
                intent.putExtra("Categoryname", holder.categoies_name_textView.getText().toString());
                // STOPSHIP: 18-02-2023
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return modelCategoriesArrayList.size();
    }

    public class CategoriesViewHolderClass extends RecyclerView.ViewHolder {
        ImageView categoires_imageView;
        TextView categoies_name_textView;

        public CategoriesViewHolderClass(@NonNull View itemView) {
            super(itemView);
            categoies_name_textView = itemView.findViewById(R.id.categoies_name_c_id);
            categoires_imageView = itemView.findViewById(R.id.categoies_image_c_id);
        }
    }
}

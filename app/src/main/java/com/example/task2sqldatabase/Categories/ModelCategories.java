package com.example.task2sqldatabase.Categories;

import android.graphics.Bitmap;

public class ModelCategories {
    private String CategoriesName;
    private Bitmap CategoriesImage;

    public ModelCategories(String categoriesName, Bitmap categoriesImage) {
        CategoriesName = categoriesName;
        CategoriesImage = categoriesImage;
    }

    public ModelCategories() {
    }

    public String getCategoriesName() {
        return CategoriesName;
    }

    public void setCategoriesName(String categoriesName) {
        CategoriesName = categoriesName;
    }

    public Bitmap getCategoriesImage() {
        return CategoriesImage;
    }

    public void setCategoriesImage(Bitmap categoriesImage) {
        CategoriesImage = categoriesImage;
    }
}

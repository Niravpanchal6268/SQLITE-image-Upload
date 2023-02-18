package com.example.task2sqldatabase.Products;

import android.graphics.Bitmap;

public class ModelProducts {
    private String ProductName,ProductPrice,ProductDiscount,ProductDiscountPrice,
        ProductCategories,ProductDescription;
    private Bitmap productimage;

    public ModelProducts(String productName, String productPrice, String productDiscount, String productDiscountPrice, String productCategories, String productDescription, Bitmap productimage) {
        ProductName = productName;
        ProductPrice = productPrice;
        ProductDiscount = productDiscount;
        ProductDiscountPrice = productDiscountPrice;
        ProductCategories = productCategories;
        ProductDescription = productDescription;
        this.productimage = productimage;
    }

    public ModelProducts(String productName, String productPrice, String productDiscount, String productDiscountPrice, String productDescription, Bitmap productimage) {
        ProductName = productName;
        ProductPrice = productPrice;
        ProductDiscount = productDiscount;
        ProductDiscountPrice = productDiscountPrice;
        ProductDescription = productDescription;
        this.productimage = productimage;
    }

    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String productName) {
        ProductName = productName;
    }

    public String getProductPrice() {
        return ProductPrice;
    }

    public void setProductPrice(String productPrice) {
        ProductPrice = productPrice;
    }

    public String getProductDiscount() {
        return ProductDiscount;
    }

    public void setProductDiscount(String productDiscount) {
        ProductDiscount = productDiscount;
    }

    public String getProductDiscountPrice() {
        return ProductDiscountPrice;
    }

    public void setProductDiscountPrice(String productDiscountPrice) {
        ProductDiscountPrice = productDiscountPrice;
    }

    public String getProductCategories() {
        return ProductCategories;
    }

    public void setProductCategories(String productCategories) {
        ProductCategories = productCategories;
    }

    public String getProductDescription() {
        return ProductDescription;
    }

    public void setProductDescription(String productDescription) {
        ProductDescription = productDescription;
    }

    public Bitmap getProductimage() {
        return productimage;
    }

    public void setProductimage(Bitmap productimage) {
        this.productimage = productimage;
    }
}

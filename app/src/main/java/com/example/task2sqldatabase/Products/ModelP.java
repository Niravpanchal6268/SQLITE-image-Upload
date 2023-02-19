package com.example.task2sqldatabase.Products;

import android.graphics.Bitmap;

public class ModelP {
    private String ProductName,ProductPrice,ProductDiscount,ProductDiscountPrice,ProductDescription;
    private byte[] ProductImage;

    public ModelP(String productName, String productPrice, String productDiscount, String productDiscountPrice, String productDescription, byte[] productImage) {

        ProductName = productName;
        ProductPrice = productPrice;
        ProductDiscount = productDiscount;
        ProductDiscountPrice = productDiscountPrice;
        ProductDescription = productDescription;
        ProductImage = productImage;
    }

    public ModelP() {
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

    public String getProductDescription() {
        return ProductDescription;
    }

    public void setProductDescription(String productDescription) {
        ProductDescription = productDescription;
    }

    public byte[] getProductImage() {
        return ProductImage;
    }

    public void setProductImage(byte[] productImage) {
        ProductImage = productImage;
    }
}

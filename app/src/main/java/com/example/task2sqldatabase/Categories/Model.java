package com.example.task2sqldatabase.Categories;

public class Model {
    private  String catename;
    private  byte[] cateimage;

    public Model(String catename, byte[] cateimage) {
        this.catename = catename;
        this.cateimage = cateimage;
    }

    public Model() {
    }

    public String getCatename() {
        return catename;
    }

    public void setCatename(String catename) {
        this.catename = catename;
    }

    public byte[] getCateimage() {
        return cateimage;
    }

    public void setCateimage(byte[] cateimage) {
        this.cateimage = cateimage;
    }
}

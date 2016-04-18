package com.example.protichi.hestia_first;

import android.graphics.drawable.Drawable;

public class Product {

    public String title;
    public Drawable productImage;
    public String description;
    public int price;
    public int dishPos;
    public boolean selected;



    public Product(String title, Drawable productImage, String description,
                   int price, int dishPos) {
        this.title = title;
        this.productImage = productImage;
        this.description = description;
        this.price = price;
        this.dishPos = dishPos;
    }

}
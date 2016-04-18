package com.example.protichi.hestia_first;

public class ShoppingCartEntry {

    private Product mProduct;
    /*private String mproductIndex;*/
    private int mQuantity;

    public ShoppingCartEntry(Product product, int quantity) {
        mProduct = product;
/*
        mproductIndex = productIndex;
*/
        mQuantity = quantity;
    }

    public Product getProduct() {
        return mProduct;
    }

    public int getQuantity() {
        return mQuantity;
    }

    public void setQuantity(int quantity) {
        mQuantity = quantity;
    }

    public int getItemPosition(){return mProduct.dishPos;}

}


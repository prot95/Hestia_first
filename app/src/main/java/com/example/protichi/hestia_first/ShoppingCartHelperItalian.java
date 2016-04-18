package com.example.protichi.hestia_first;

import android.content.res.Resources;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

/**
 * Created by Simran on 4/11/16.
 */
public class ShoppingCartHelperItalian {

    public static final String PRODUCT_INDEX = "PRODUCT_INDEX";

    private static List<Product> catalog;
    private static Map<Product, ShoppingCartEntry> cartMap = new HashMap<Product, ShoppingCartEntry>();

    public static List<Product> getCatalog(Resources res){
        if(catalog == null) {
            catalog = new Vector<Product>();


            //Italian +26

            catalog.add(new Product("Chicken Parmesan", res
                    .getDrawable(R.drawable.chickenparmesan_catalog),
                    "Anuradha Tanka", 180,27));
            catalog.add(new Product("Sicilian Pizza", res
                    .getDrawable(R.drawable.sicilianpizza),
                    "Anuradha Tankha", 160,28));
            catalog.add(new Product("Sicilian Pasta", res
                    .getDrawable(R.drawable.sicilianpasta),
                    "Shwta Kansal", 180,29));
            catalog.add(new Product("Lasagna", res
                    .getDrawable(R.drawable.lasagna),
                    "Nupur Sahney", 200,30));
            catalog.add(new Product("Italian Meat Balls", res
                    .getDrawable(R.drawable.italianmeatballs),
                    "Shivani Singh", 190,31));
            catalog.add(new Product("Pepper and Sausage", res
                    .getDrawable(R.drawable.pepperandsaucage),
                    "Ishita Gupta", 160,32));

        }

        return catalog;
    }

    public static void setQuantity(Product product, int quantity)
    {
        // Get the current cart entry
        ShoppingCartEntry curEntry = cartMap.get(product);

        // If the quantity is zero or less, remove the products
        if(quantity <= 0) {
            if(curEntry != null)
                removeProduct(product);
            return;
        }

        // If a current cart entry doesn't exist, create one
        if(curEntry == null)
        {
            curEntry = new ShoppingCartEntry(product, quantity);
            cartMap.put(product, curEntry);
            return;
        }

        // Update the quantity
        curEntry.setQuantity(quantity);
    }

    public static int getProductQuantity(Product product) {
        // Get the current cart entry
        ShoppingCartEntry curEntry = cartMap.get(product);

        if(curEntry != null)
            return curEntry.getQuantity();

        return 0;
    }

    public static void removeProduct(Product product) {
        cartMap.remove(product);
    }

    public static List<Product> getCartList() {
        List<Product> cartList = new Vector<Product>(cartMap.keySet().size());
        for(Product p : cartMap.keySet()) {
            cartList.add(p);
        }

        return cartList;
    }
}

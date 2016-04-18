package com.example.protichi.hestia_first;

import android.content.res.Resources;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

/**
 * Created by Simran on 4/11/16.
 */
public class ShoppingCartHelperChinese {

    public static final String PRODUCT_INDEX = "PRODUCT_INDEX";

    private static List<Product> catalog;
    private static Map<Product, ShoppingCartEntry> cartMap = new HashMap<Product, ShoppingCartEntry>();

    public static List<Product> getCatalog(Resources res){
        if(catalog == null) {
            catalog = new Vector<Product>();

            //Chinese +20

            catalog.add(new Product("Chowmein", res
                    .getDrawable(R.drawable.chowmein_catalog),
                    "Neha Patel", 80,21));
            catalog.add(new Product("Veg Fried Rice", res
                    .getDrawable(R.drawable.vegfriedrice),
                    "Nupur Sahney", 70,22));
            catalog.add(new Product("Veg Manchurian", res
                    .getDrawable(R.drawable.vegmanchurian),
                    "Neha Patel", 90,23));
            catalog.add(new Product("Chilli Chicken", res
                    .getDrawable(R.drawable.chillichicken),
                    "Nupur Sahney", 180,24));
            catalog.add(new Product("Veg Sweet and Sour", res
                    .getDrawable(R.drawable.vegsweetandsour),
                    "Zafeera Shakil", 120,25));
            catalog.add(new Product("Egg Fried Rice", res
                    .getDrawable(R.drawable.eggfriedrice),
                    "Naureen Mustafa", 120,26));


            //
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

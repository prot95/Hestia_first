package com.example.protichi.hestia_first;

import android.content.res.Resources;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

/**
 * Created by Simran on 4/11/16.
 */
public class ShoppingCartHelperMughlai {

    public static final String PRODUCT_INDEX = "PRODUCT_INDEX";

    private static List<Product> catalog;
    private static Map<Product, ShoppingCartEntry> cartMap = new HashMap<Product, ShoppingCartEntry>();

    public static List<Product> getCatalog(Resources res){
        if(catalog == null) {
            catalog = new Vector<Product>();

            //Mughali +14

            catalog.add(new Product("Shaami Kebab", res
                    .getDrawable(R.drawable.shamikebab),
                    "Nupur Sahney", 150,15));
            catalog.add(new Product("Sheermaal", res
                    .getDrawable(R.drawable.sheermaal),
                    "Nupur Sahney", 50,16));
            catalog.add(new Product("Ulte Tawe ka Parantha", res
                    .getDrawable(R.drawable.ultetawekaparantha),
                    "Archana Jha", 40,17));
            catalog.add(new Product("Galawati Kebab", res
                    .getDrawable(R.drawable.galautikebab),
                    "Archana Jha", 160,18));

            catalog.add(new Product("Chicken Quorma", res
                    .getDrawable(R.drawable.chickenquorma),
                    "Priti Sahay", 100,19));
            catalog.add(new Product("Veg Quorma", res
                    .getDrawable(R.drawable.vegquorma),
                    "Priti Sahay", 60,20));


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

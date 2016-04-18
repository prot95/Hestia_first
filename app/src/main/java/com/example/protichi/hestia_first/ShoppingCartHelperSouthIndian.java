package com.example.protichi.hestia_first;

import android.content.res.Resources;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

/**
 * Created by Simran on 4/11/16.
 */
public class ShoppingCartHelperSouthIndian {

    public static final String PRODUCT_INDEX = "PRODUCT_INDEX";

    private static List<Product> catalog;
    private static Map<Product, ShoppingCartEntry> cartMap = new HashMap<Product, ShoppingCartEntry>();

    public static List<Product> getCatalog(Resources res){
        if(catalog == null) {
            catalog = new Vector<Product>();

            //South Indian +32

            catalog.add(new Product("Idli Sambar", res
                    .getDrawable(R.drawable.idlisambar),
                    "Kunti Sharma", 60,33));
            catalog.add(new Product("Vada Sambar", res
                    .getDrawable(R.drawable.vadasambar),
                    "Richa Ringh", 90,34));
            catalog.add(new Product("Masala Dosa", res
                    .getDrawable(R.drawable.masaladosa),
                    "Indu Sharma", 80,35));
            catalog.add(new Product("Plain Dosa", res
                    .getDrawable(R.drawable.plaindosa),
                    "Indu Sharma", 50,36));
            catalog.add(new Product("Masala Dosa", res
                    .getDrawable(R.drawable.masaladosa),
                    "Nupur Sahney", 65,37));
            catalog.add(new Product("Idiyappam", res
                    .getDrawable(R.drawable.idiyappam),
                    "Nidhi Gupta", 60,38));

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

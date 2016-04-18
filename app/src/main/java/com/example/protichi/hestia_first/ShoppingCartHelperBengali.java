package com.example.protichi.hestia_first;

import android.content.res.Resources;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

/**
 * Created by Simran on 4/11/16.
 */
public class ShoppingCartHelperBengali {

    public static final String PRODUCT_INDEX = "PRODUCT_INDEX";

    private static List<Product> catalog;
    private static Map<Product, ShoppingCartEntry> cartMap = new HashMap<Product, ShoppingCartEntry>();

    public static List<Product> getCatalog(Resources res){
        if(catalog == null) {
            catalog = new Vector<Product>();

            //Bengali +9

            catalog.add(new Product("Avacado Paratha", res
                    .getDrawable(R.drawable.avacadoparatha),
                    "Indu Sehgal", 30,9));
            catalog.add(new Product("Paneer Chole", res
                    .getDrawable(R.drawable.paneerchole),
                    "Jena Ghosh", 90,10));
            catalog.add(new Product("Black Urad Khichdi", res
                    .getDrawable(R.drawable.blackuradkhichdi),
                    "Jena Ghosa", 70,11));
            catalog.add(new Product("Kaju Karela Sabji", res
                    .getDrawable(R.drawable.kajukarelasanji),
                    "Sonia Mojumdar", 100,12));
            catalog.add(new Product("Pabda Macher Jhol", res
                    .getDrawable(R.drawable.pabdmacherjhol),
                    "Sonia Mojumdar", 200,13));
            catalog.add(new Product("Lau Ghanta", res
                    .getDrawable(R.drawable.laughanta),
                    "Nupur Sahney", 170,14));



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

package com.example.protichi.hestia_first;

import android.content.res.Resources;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

public class ShoppingCartHelper
{

    public static final String PRODUCT_INDEX = "PRODUCT_INDEX";

    private static List<Product> catalog;
    private static Map<Product, ShoppingCartEntry> cartMap = new HashMap<Product, ShoppingCartEntry>();

    public static List<Product> getCatalog(Resources res){
        if(catalog == null) {
            catalog = new Vector<Product>();

            //general
            catalog.add(new Product("Arhar Dal", res
                    .getDrawable(R.drawable.yellowdal_catalog),
                    "Ishita Tiwari", 45,1));
            catalog.add(new Product("Chicken Curry", res
                    .getDrawable(R.drawable.chickencurry_catalog),
                    "Nikita Singhal", 100,2));
            catalog.add(new Product("Daal Makhani", res
                    .getDrawable(R.drawable.dalmakhani_catalog),
                    "Nupur Sahney", 80,3));
            catalog.add(new Product("Butter Paneer", res
                    .getDrawable(R.drawable.paneerbuttermasala_catalog),
                    "Neha Chauhan", 80,4));
            catalog.add(new Product("Shahi Paneer", res
                    .getDrawable(R.drawable.shahipaneer_catalog),
                    "Sangeeta Gupta", 75,5));
            catalog.add(new Product("Pasta", res
                    .getDrawable(R.drawable.pasta2_catalog),
                    "Alikya Tayal", 90,6));
            catalog.add(new Product("Chowmein", res
                    .getDrawable(R.drawable.chowmein_catalog),
                    "Nancy Moore", 50,7));
            catalog.add(new Product("Aalo Parantha", res
                    .getDrawable(R.drawable.alooparantha_catalog),
                    "Shivangi Gupta", 20,8));

            //Bengali +8

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
                    "Sonia Mojumdar",200,13));
            catalog.add(new Product("Lau Ghanta", res
                    .getDrawable(R.drawable.laughanta),
                    "Nupur Sahney", 170,14));
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

    public static int getProductPos(Product product) {
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
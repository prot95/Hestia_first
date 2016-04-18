package com.example.protichi.hestia_first;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by agrawalamod on 4/9/16.
 */
public class User {

    String firstName;
    String lastName;
    String emailID;
    String phoneNum;
    String location;
    String speciality;
    ArrayList<String> availability = new ArrayList();

    //Protichi added the following

    HashMap<String, MenuDetails> breakfastHashMap = new HashMap(); //mapping of availibity and menu
    HashMap<String, MenuDetails> lunchHashMap = new HashMap(); //mapping of availibity and menu
    HashMap<String, MenuDetails> dinnerHashMap = new HashMap(); //mapping of availibity and menu



    public static User user = new User();
    private User()
    {

    }

    public static User getInstance()
    {
        return user;
    }


}

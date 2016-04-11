package com.example.protichi.hestia_first;

import java.util.ArrayList;

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
    ArrayList availability = new ArrayList();



    public static User user = new User();
    private User()
    {

    }

    public static User getInstance()
    {
        return user;
    }


}

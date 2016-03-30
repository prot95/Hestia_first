package com.example.protichi.hestia_first;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CookUserOption extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cook_user_option);


        Button cook = (Button) findViewById(R.id.cook);
        cook.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
                Intent i = new Intent(getApplicationContext(), Cook_homepage.class);
                startActivity(i);
            }
        });
        Button customer = (Button) findViewById(R.id.customer);
        customer.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
                Intent i = new Intent(getApplicationContext(), Availability.class);
                startActivity(i);

            }
        });


    }
}

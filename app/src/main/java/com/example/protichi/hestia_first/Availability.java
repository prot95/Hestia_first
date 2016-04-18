package com.example.protichi.hestia_first;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Locale;
import java.util.Objects;

public class Availability extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_availability);

        //getActionBar().setDisplayShowTitleEnabled(false);
        //getActionBar().setDisplayShowCustomEnabled(true);
        //getSupportActionBar().setCustomView(R.layout.actionbar_layout);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Set Availability");

        final CheckBox box1 = (CheckBox) findViewById(R.id.checkBox);
        final CheckBox box2 = (CheckBox) findViewById(R.id.checkBox2);
        final CheckBox box3 = (CheckBox) findViewById(R.id.checkBox3);
        final CheckBox box4 = (CheckBox) findViewById(R.id.checkBox4);
        final CheckBox box5 = (CheckBox) findViewById(R.id.checkBox5);
        final CheckBox box6 = (CheckBox) findViewById(R.id.checkBox6);
        final CheckBox box7 = (CheckBox) findViewById(R.id.checkBox7);
        Button save = (Button) findViewById(R.id.button2);

        final ArrayList available = new ArrayList();
        ArrayList current_availability = User.getInstance().availability;
        if(!current_availability.isEmpty())
        {
            Log.v("Current Availability", current_availability.toString());

        }

        Calendar c = Calendar.getInstance();

        System.out.println("Current time => " + c.getTime());
        SimpleDateFormat df = new SimpleDateFormat("dd MMM yyyy");
        SimpleDateFormat dayFormat = new SimpleDateFormat("EEEE", Locale.US);

        final String formattedDate1 = df.format(c.getTime());
        String weekDay = dayFormat.format(c.getTime());
        box1.setText(formattedDate1 + " : " + weekDay + " " + "(Today)");
        Log.v("Availability", formattedDate1);
        if(current_availability.contains((Object)formattedDate1))
        {
            Log.v("Availability", "True");
            box1.setChecked(true);
        }
        else
        {
            Log.v("Availability", "False");

        }

        c.add(Calendar.DATE, 1);
        final String formattedDate2 = df.format(c.getTime());
        weekDay = dayFormat.format(c.getTime());
        box2.setText(formattedDate2 + " : " + weekDay);
        //Log.v("NEXT DATE : ", formattedDate);
        if(current_availability.contains((Object)formattedDate2))
        {
            box2.setChecked(true);
        }


        c.add(Calendar.DATE, 1);
        final String formattedDate3 = df.format(c.getTime());
        weekDay = dayFormat.format(c.getTime());
        box3.setText(formattedDate3 + " : " + weekDay);
        //Log.v("NEXT DATE : ", formattedDate);
        if(current_availability.contains((Object)formattedDate3))
        {
            box3.setChecked(true);
        }

        c.add(Calendar.DATE, 1);
        final String formattedDate4 = df.format(c.getTime());
        weekDay = dayFormat.format(c.getTime());
        box4.setText(formattedDate4 + " : " + weekDay);
        //Log.v("NEXT DATE : ", formattedDate);
        if(current_availability.contains((Object)formattedDate4))
        {
            box4.setChecked(true);
        }

        c.add(Calendar.DATE, 1);
        final String formattedDate5 = df.format(c.getTime());
        weekDay = dayFormat.format(c.getTime());
        box5.setText(formattedDate5 + " : " + weekDay);
        //Log.v("NEXT DATE : ", formattedDate);
        if(current_availability.contains((Object)formattedDate5))
        {
            box5.setChecked(true);
        }

        c.add(Calendar.DATE, 1);
        final String formattedDate6 = df.format(c.getTime());
        weekDay = dayFormat.format(c.getTime());
        box6.setText(formattedDate6 + " : " + weekDay);
        //Log.v("NEXT DATE : ", formattedDate);
        if(current_availability.contains((Object)formattedDate6))
        {
            box6.setChecked(true);
        }

        c.add(Calendar.DATE, 1);
        final String formattedDate7 = df.format(c.getTime());
        weekDay = dayFormat.format(c.getTime());
        box7.setText(formattedDate7 + " : " + weekDay);
       // Log.v("NEXT DATE : ", formattedDate);
        if( current_availability.contains((Object)formattedDate7))
        {
            box7.setChecked(true);
        }




        save.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click

                if(box1.isChecked())
                {
                    available.add(formattedDate1);
                }
                if(box2.isChecked())
                {
                    available.add(formattedDate2);
                }
                if(box3.isChecked())
                {
                    available.add(formattedDate3);
                }if(box4.isChecked())
                {
                    available.add(formattedDate4);
                }if(box5.isChecked())
                {
                    available.add(formattedDate5);
                }if(box6.isChecked())
                {
                    available.add(formattedDate6);
                }if(box7.isChecked())
                {
                    available.add(formattedDate7);
                }
                Log.v("Saved Availability",available.toString());
                User user = User.getInstance();
                user.availability = available;

                //protichi added this
                for(String d:user.availability)
                {
                    user.breakfastHashMap.put(d, null);
                    user.lunchHashMap.put(d,null);
                    user.dinnerHashMap.put(d,null);
                }

                Intent i = new Intent(getApplicationContext(), Cook_homepage.class);
                i.putStringArrayListExtra("availability", available);
                startActivity(i);

            }
        });



    }


}

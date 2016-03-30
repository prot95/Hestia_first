package com.example.protichi.hestia_first;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

public class Availability extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_availability);

        //getSupportActionBar().setDisplayShowTitleEnabled(false);
        //getSupportActionBar().setDisplayShowCustomEnabled(true);
        //getSupportActionBar().setCustomView(R.layout.actionbar_layout);


        final CheckBox box1 = (CheckBox) findViewById(R.id.checkBox);
        final CheckBox box2 = (CheckBox) findViewById(R.id.checkBox2);
        final CheckBox box3 = (CheckBox) findViewById(R.id.checkBox3);
        final CheckBox box4 = (CheckBox) findViewById(R.id.checkBox4);
        final CheckBox box5 = (CheckBox) findViewById(R.id.checkBox5);
        final CheckBox box6 = (CheckBox) findViewById(R.id.checkBox6);
        final CheckBox box7 = (CheckBox) findViewById(R.id.checkBox7);
        Button save = (Button) findViewById(R.id.button2);

        final ArrayList available = new ArrayList();

        Calendar c = Calendar.getInstance();

        System.out.println("Current time => " + c.getTime());
        SimpleDateFormat df = new SimpleDateFormat("dd MMM yyyy");
        SimpleDateFormat dayFormat = new SimpleDateFormat("EEEE", Locale.US);

        final String formattedDate1 = df.format(c.getTime());
        String weekDay = dayFormat.format(c.getTime());
        //System.out.println(formattedDate);
        box1.setText(formattedDate1 + " : " + weekDay + " " + "(Today)");

        c.add(Calendar.DATE, 1);
        final String formattedDate2 = df.format(c.getTime());
        weekDay = dayFormat.format(c.getTime());
        box2.setText(formattedDate2 + " : " + weekDay);
        //Log.v("NEXT DATE : ", formattedDate);


        c.add(Calendar.DATE, 1);
        final String formattedDate3 = df.format(c.getTime());
        weekDay = dayFormat.format(c.getTime());
        box3.setText(formattedDate3 + " : " + weekDay);
        //Log.v("NEXT DATE : ", formattedDate);

        c.add(Calendar.DATE, 1);
        final String formattedDate4 = df.format(c.getTime());
        weekDay = dayFormat.format(c.getTime());
        box4.setText(formattedDate4 + " : " + weekDay);
        //Log.v("NEXT DATE : ", formattedDate);

        c.add(Calendar.DATE, 1);
        final String formattedDate5 = df.format(c.getTime());
        weekDay = dayFormat.format(c.getTime());
        box5.setText(formattedDate5 + " : " + weekDay);
        //Log.v("NEXT DATE : ", formattedDate);

        c.add(Calendar.DATE, 1);
        final String formattedDate6 = df.format(c.getTime());
        weekDay = dayFormat.format(c.getTime());
        box6.setText(formattedDate6 + " : " + weekDay);
        //Log.v("NEXT DATE : ", formattedDate);

        c.add(Calendar.DATE, 1);
        final String formattedDate7 = df.format(c.getTime());
        weekDay = dayFormat.format(c.getTime());
        box7.setText(formattedDate7 + " : " + weekDay);
       // Log.v("NEXT DATE : ", formattedDate);

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
                Log.v("Availability",available.toString());
                Intent i = new Intent(getApplicationContext(), Cook_homepage.class);
                i.putStringArrayListExtra("availability", available);

                startActivity(i);

            }
        });



    }


}
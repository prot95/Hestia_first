package com.example.protichi.hestia_first;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class Add_item extends AppCompatActivity {
    User user = User.getInstance();
    String date, mealType;
    TextView displayDate;
    private ArrayList<String> dates = new ArrayList();
    private String hardcodeDate[] = {"15 Apr 2016", "16 Apr 2016", "17 Apr 2016", "18 Apr 2016", "19 Apr 2016", "20 Apr 2016", "21 Apr 2016"};
    MenuDetails menu = new MenuDetails();
    String itemName, rate, unit, description;
    CheckBox[] checkBoxes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);

        getSupportActionBar().setTitle("ADD ITEM");
        getSupportActionBar().setDisplayShowCustomEnabled(true);

        Intent intent = getIntent();
        date = intent.getStringExtra("date");
        mealType = intent.getStringExtra("mealType");

        displayDate = (TextView)findViewById(R.id.date);
        displayDate.setText(date);

        LinearLayout lm = (LinearLayout)findViewById(R.id.checkList);
        getAvailableDays();
        checkBoxes = new CheckBox[dates.size()];
        for(String d: dates)
        {
            int j=0;
            checkBoxes[j] = (new CheckBox(this));
            if(d.equals(date))
                checkBoxes[j].setChecked(true);
            else
                checkBoxes[j].setChecked(false);
            checkBoxes[j].setText(d);
            checkBoxes[j].setId(j);
           // lm.addView(checkBoxes[j]);
            j++;
        }

    }


    //@amod remove the if condition once the app works fine with availibility
    private void getAvailableDays()
    {
        Log.i("TAG", Integer.toString(user.availability.size()));

            dates = user.availability;

        Log.i("TAG", Integer.toString(dates.size()));

    }

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.veg:
                if (checked)
                    // Pirates are the best
                    menu.isVeg =1;
                    break;
            case R.id.nonveg:
                if (checked)
                    // Ninjas rule
                    menu.isVeg=0;
                    break;
        }
    }

    public void additem(View view)
    {
        Button button = (Button)findViewById(R.id.submit);
        itemName = ((EditText)findViewById(R.id.itemName)).getText().toString();
        rate = ((EditText)findViewById(R.id.rate)).getText().toString();
        description = ((EditText)findViewById(R.id.description)).getText().toString();



        if(itemName.equals("")||rate.equals("")||description.equals(""))
        {
            Toast.makeText(this, "Enter all the fields", Toast.LENGTH_SHORT).show();
        }
        else
        {
            Intent browserIntent =
                    new Intent(this, upload_menu.class);
            menu.itemName = itemName;

            menu.rate = rate;
            menu.description = description;
            int vegButton = ((RadioGroup)findViewById(R.id.vegGroup)).getCheckedRadioButtonId();
            if(vegButton== R.id.veg)
                menu.isVeg=1;
            else menu.isVeg=0;

            int unitButton = ((RadioGroup)findViewById(R.id.unitGroup)).getCheckedRadioButtonId();
            if(unitButton==R.id.plate)
                unit = "Plate";
            else if(unitButton==R.id.pc)
                unit = "Pc";
            else
                unit = "Kg";
            menu.unit = unit;
            //add menu for that particular date
            if(mealType.equals("breakfast"))
                user.breakfastHashMap.put(date, menu);
            else if(mealType.equals("lunch"))
                user.lunchHashMap.put(date, menu);
            else
                user.dinnerHashMap.put(date, menu);

            //addMenu(); //can't make this work
            startActivity(browserIntent);
        }



    }

    // i am not able to make the checklists work. See if you can do anything, otherwise, hata de checklists
    public void addMenu()
    {
        for(String d:dates)
        {
            int j=0;

            if(checkBoxes[j].isChecked())
            {

                user.breakfastHashMap.put(d, menu);
                Log.i("TAG", d + " menu added");
            }
            j++;
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_add_item, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

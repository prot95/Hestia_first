package com.example.protichi.hestia_first;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;


public class upload_lunch extends Fragment {

    User user = User.getInstance();

    private ArrayList<String> date = new ArrayList();
    private String hardcodeDate[] = {"15 Apr 2016", "16 Apr 2016", "17 Apr 2016", "18 Apr 2016", "19 Apr 2016", "20 Apr 2016", "21 Apr 2016"};

    public upload_lunch() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View setView = inflater.inflate(R.layout.fragment_upload_menu, container, false);

        return setView;
    }


    //@amod remove the if condition once the app works fine with availibility
    private void getAvailableDays()
    {
        Log.i("TAG", Integer.toString(user.availability.size()));
        if(user.availability.size() == 0 ) //remove after checking with availibility button
        {
            date = new ArrayList<String>(Arrays.asList(hardcodeDate));
            if(user.lunchHashMap.size()==0)
            {
                for(String d: date)
                {
                    user.lunchHashMap.put(d, null);
                }
            }

        }

        else
            date = user.availability;

        Log.i("TAG", Integer.toString(date.size()));

    }


    @Override
    public void onActivityCreated(Bundle savedInstanceState)
    {
        super.onActivityCreated(savedInstanceState);
        LinearLayout lm = (LinearLayout) getView().findViewById(R.id.fragments_menu_layout);

        //for buttons
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                ActionBar.LayoutParams.MATCH_PARENT, ActionBar.LayoutParams.WRAP_CONTENT);
        params.gravity = Gravity.CENTER;

        LinearLayout.LayoutParams lineParam = new LinearLayout.LayoutParams(
                ActionBar.LayoutParams.MATCH_PARENT, ActionBar.LayoutParams.MATCH_PARENT);

        float scale = getResources().getDisplayMetrics().density; // use this scale to convert dp to pixels(ref: http://stackoverflow.com/questions/20948793/how-can-we-set-height-and-width-dp-for-imageview-in-android)


        Log.i("TAG", "Entered");

        getAvailableDays();
        if(user.lunchHashMap.size()==0)
        {
            LinearLayout ll = new LinearLayout(getActivity());
            ll.setOrientation(LinearLayout.HORIZONTAL);

            //display date
            TextView displaydate = new TextView(getActivity());
            displaydate.setText("Set Availiblity First");
            displaydate.setGravity(Gravity.CENTER);
            ll.addView(displaydate);

            lm.addView(ll);
            Log.i("TAG", "hash map empty");
        }
        else

        {
            for(final String d:date)
            {
                int j=0;
                LinearLayout ll = new LinearLayout(getActivity());
                ll.setOrientation(LinearLayout.VERTICAL);

                //display date
                TextView displaydate = new TextView(getActivity());
                displaydate.setText(d);
                displaydate.setTextSize((7 * scale));
                displaydate.setGravity(Gravity.CENTER);
                ll.addView(displaydate);



                View v = new View(getActivity());
                v.setLayoutParams(new LinearLayout.LayoutParams(
                        ActionBar.LayoutParams.MATCH_PARENT,
                        5
                ));
                v.setBackgroundColor(Color.parseColor("#B3B3B3"));
                ll.addView(v);

                if(user.lunchHashMap.get(d)==null)
                {
                    Button btn = new Button(getActivity());
                    // Give button an ID
                    btn.setId(j);
                    btn.setText("Add Item To Menu");
                    // set the layoutParams on the button

                    btn.setLayoutParams(params);
                    btn.setBackgroundColor(getResources().getColor(R.color.actionbar_background));

                    final int index = j;
                    // Set click listener for button
                    btn.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View v) {

                            Log.i("TAG", "index :" + index);
                            Intent i = new Intent(getView().getContext(), Add_item.class);
                            i.putExtra("date", d);
                            i.putExtra("mealType", "lunch");
                            startActivity(i);

                        }
                    });
                    btn.setGravity(Gravity.CENTER);
                    ll.addView(btn);

                    lm.addView(ll);
                }
                else
                {
                    MenuDetails m = user.lunchHashMap.get(d);

                    //display date
                    TextView product = new TextView(getActivity());

                    product.setText(m.itemName);
                    product.setTextSize((6 * scale));
                    product.setTypeface(null, Typeface.BOLD);
                    product.setGravity(Gravity.CENTER);
                    ll.addView(product);

                    TextView rate = new TextView(getActivity());

                    rate.setText("Rate: " + m.rate + " per " + m.unit);
                    rate.setTextSize((5 * scale));
                    rate.setTypeface(null, Typeface.BOLD);
                    rate.setGravity(Gravity.CENTER);
                    ll.addView(rate);

                    TextView foodType = new TextView(getActivity());
                    if(m.isVeg==1)
                        foodType.setText("Veg");
                    else foodType.setText("Non Veg");
                    foodType.setTextSize((5 * scale));
                    foodType.setTypeface(null, Typeface.BOLD);
                    foodType.setGravity(Gravity.CENTER);
                    ll.addView(foodType);

                    TextView description = new TextView(getActivity());

                    description.setText(m.description);
                    description.setTextSize((5 * scale));
                    description.setTypeface(null, Typeface.BOLD);
                    description.setGravity(Gravity.CENTER);
                    ll.addView(description);

                    //edit button
                    Button btn = new Button(getActivity());
                    // Give button an ID
                    btn.setId(j);
                    btn.setText("Edit Item");
                    // set the layoutParams on the button
                    btn.setLayoutParams(params);
                    btn.setBackgroundColor(getResources().getColor(R.color.actionbar_background));

                    final int index = j;
                    // Set click listener for button
                    btn.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View v) {

                            Log.i("TAG", "index :" + index);

                        }
                    });
                    btn.setGravity(Gravity.CENTER);
                    //ll.addView(btn);
                    lm.addView(ll);
                }


                j++;
                Log.i("TAG", "not empty");
            }
        }

    }



}

package com.example.protichi.hestia_first;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ListView;
import android.support.v4.view.ViewPager;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class order_fragment extends Fragment {

    static final String[] time = new String[] {"10:00 AM", "02:00 PM", "08:00PM"};
    static final String[] orderNum = new String[]{"5", "7", "2"};
    static final String orderWord = " orders";

    public order_fragment()
    {
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

        return inflater.inflate(R.layout.order_event_layout, container, false);

    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState)
    {
        super.onActivityCreated(savedInstanceState);

        //set Time
        TextView welcomeTextView = (TextView)getView().findViewById(R.id.breakfast_time);
        welcomeTextView.setText(time[0]);

        welcomeTextView = (TextView)getView().findViewById(R.id.lunch_time);
        welcomeTextView.setText(time[1]);

        welcomeTextView = (TextView)getView().findViewById(R.id.dinner_time);
        welcomeTextView.setText(time[2]);

        //num Order
        welcomeTextView = (TextView)getView().findViewById(R.id.num_break);
        welcomeTextView.setText(orderNum[0] + orderWord);

        welcomeTextView = (TextView)getView().findViewById(R.id.num_lunch);
        welcomeTextView.setText(orderNum[1] + orderWord);

        welcomeTextView = (TextView)getView().findViewById(R.id.num_dinner);
        welcomeTextView.setText(orderNum[2] + orderWord);

    }


}

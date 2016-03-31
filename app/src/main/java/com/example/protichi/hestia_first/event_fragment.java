package com.example.protichi.hestia_first;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class event_fragment extends Fragment {

    static final String[] time = new String[] {"10:00 AM", "2:00 PM"};
    static final String[] event = new String[]{"Italian Food Class", "Dosa class"};
    public event_fragment(){}

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.order_event_layout, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState)
    {
        super.onActivityCreated(savedInstanceState);
        TextView welcomeTextView = (TextView)getView().findViewById(R.id.breakfast_time);
        welcomeTextView.setText(time[0]);

        welcomeTextView = (TextView)getView().findViewById(R.id.lunch_time);
        welcomeTextView.setText(time[1]);

        welcomeTextView = (TextView)getView().findViewById(R.id.breakfast);
        welcomeTextView.setText(event[0]);

        welcomeTextView = (TextView)getView().findViewById(R.id.lunch);
        welcomeTextView.setText(event[1]);

        welcomeTextView = (TextView)getView().findViewById(R.id.dinner);
        welcomeTextView.setText("");

    }

}

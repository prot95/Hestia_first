package com.example.protichi.hestia_first;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;


public class upload_breakfast extends Fragment {

    // TODO: Rename and change types and number of parameters

    public upload_breakfast() {
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

    @Override
    public void onActivityCreated(Bundle savedInstanceState)
    {
        super.onActivityCreated(savedInstanceState);
        LinearLayout layout_upload_menu = (LinearLayout)getView(). findViewById(R.id.fragments_menu_layout);
        View child = getActivity().getLayoutInflater().inflate(R.layout.fragment_upload_lunch, null);

        layout_upload_menu.addView(child);
        TextView t_child = (TextView)getView().findViewById(R.id.day);
        t_child.setText("MONDAY");

    }

}







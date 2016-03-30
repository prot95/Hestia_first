package com.example.protichi.hestia_first;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class Home_cook extends Fragment {
    //receive this field from register/sign in page
    private String name="Rachna";

    private String welcomeText = "Namaste, Chef ";
    private ViewPager viewPager;
    private TabLayout tabLayout;

    public Home_cook() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getChildFragmentManager());
        adapter.addFragment(new order_fragment(), "ORDERS");
        adapter.addFragment(new event_fragment(), "EVENTS");
        viewPager.setAdapter(adapter);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View setView = inflater.inflate(R.layout.fragment_home_cook, container, false);
        // Inflate the layout for this fragment

        return setView;

    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState)
    {
        TextView welcomeTextView = (TextView)getView().findViewById(R.id.welcomeText);
        Button availability = (Button) getView().findViewById(R.id.availability);
        availability.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click

                // Change to Customer Activity
                Intent i = new Intent(getView().getContext(), Availability.class);
                startActivity(i);

            }
        });


        Button menu = (Button) getView().findViewById(R.id.menu);

        String text = welcomeText + name;
        welcomeTextView.setText(text);
        viewPager = (ViewPager)getView().findViewById(R.id.viewpager);
        setupViewPager(viewPager);
        tabLayout = (TabLayout)getView().findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
        super.onActivityCreated(savedInstanceState);

    }

    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }

}

package com.example.protichi.hestia_first;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class User_homepage extends AppCompatActivity {

    private static final String TAG = User_homepage.class.getSimpleName();
    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_homepage);


        Log.e(TAG,"USER HOMEPAGE ACTIVITY STARTED" );

        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setCustomView(R.layout.actionbar_layout);

        viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);

    }

    public void onClickTrending(View view)
    {
        Intent intent = new Intent(this, ChineseCatalog.class);
        startActivity(intent);
    }

    public void onClickChinese(View view)
    {
        Intent intent = new Intent(this, ChineseCatalog.class);
        startActivity(intent);
    }

    public void onClickItalian(View view)
    {
        Intent intent = new Intent(this, ItalianCatalog.class);
        startActivity(intent);
    }

    public void onClickMughlai(View view)
    {
        Intent intent = new Intent(this, MughlaiCatalog.class);
        startActivity(intent);
    }

    public void onClickBengali(View view)
    {
        Intent intent = new Intent(this, BengaliCatalog.class);
        startActivity(intent);
    }

    public void onClickSouthIndian(View view)
    {
        Intent intent = new Intent(this, SouthIndianCatalog.class);
        startActivity(intent);
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new Home_user(), "HOME");
        adapter.addFragment(new Profile_user(), "PROFILE"); //change
        viewPager.setAdapter(adapter);
    }

    public void onFinalSearch(View view)
    {
        Intent intent = new Intent(this, EmployeeList.class);
        startActivity(intent);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_cook_homepage, menu);
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
    public void onActionButtonClickCart(View view)
    {
        Intent intent = new Intent(this, ShoppingCartActivity.class);
        startActivity(intent);
    }
}
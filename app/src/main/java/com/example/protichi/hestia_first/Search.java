package com.example.protichi.hestia_first;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class Search extends Activity {

    private static final String TAG = EmployeeList.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
    }

    public static void search(View view)
    {
        Log.d(TAG, "search of Search activity");
    }
}
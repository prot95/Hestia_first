package com.example.protichi.hestia_first;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Chanchal on 4/15/2016.
 */
public class UserOrderDetails extends AppCompatActivity {

    int flag;

    EditText name;
    EditText address;
    EditText mobile;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_order_detail);

        name = (EditText) findViewById(R.id.Name);
        address = (EditText) findViewById(R.id.Address);
        mobile = (EditText) findViewById(R.id.Mobile);
        flag =0;
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setCustomView(R.layout.actionbar_layout);

        User user = User.getInstance();

        name.setText(user.firstName + " " + user.lastName);
        address.setText(user.location);
        mobile.setText(user.phoneNum);
    }

    public void onClickOrderNow(View view)
    {

        if(name.getText().toString().equals("") || address.getText().toString().equals("") || mobile.getText().toString().equals(""))
        {
            flag =1;
            Log.v("TEST", "Something is null");

        }
        Log.v("TEST",name.getText().toString() +"_" +  address.getText().toString() + "_" + mobile.getText().toString());



        if(flag ==1)
        {
            Toast.makeText(getApplicationContext(), "Please make sure all fields are filled properly", Toast.LENGTH_LONG).show();
            Log.v("TEST", "Something is null");
        }
        else {
            Log.v("TEST", "Nothing is null");
            Intent intent = new Intent(this, UserOrderCheck.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
        }
    }
}

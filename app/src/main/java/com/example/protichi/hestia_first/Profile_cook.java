package com.example.protichi.hestia_first;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;


public class Profile_cook extends Fragment {
    public Profile_cook() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    public void onActivityCreated(Bundle savedInstanceState)
    {
        super.onActivityCreated(savedInstanceState);

        EditText firstName = (EditText) getView().findViewById(R.id.editText);
        EditText lastName = (EditText) getView().findViewById(R.id.editText2);
        EditText location = (EditText) getView().findViewById(R.id.editText3);
        EditText phone = (EditText) getView().findViewById(R.id.editText5);
        EditText email = (EditText) getView().findViewById(R.id.editText6);
        Switch user_toggle = (Switch) getView().findViewById(R.id.switch1);

        User user = User.getInstance();
        firstName.setText(user.firstName);
        lastName.setText(user.lastName);
        email.setText(user.emailID);
        phone.setText(user.phoneNum);
        location.setText(user.location);


        /*if(getActivity().getIntent().getStringArrayExtra("Name") == null) {
                firstName.setText("Rachna");
        }
        else
        {
            firstName.setText(user.firstName);
        }
        if(getActivity().getIntent().getStringArrayExtra("Name") == null) {
            lastName.setText("Agrawal");
        }
        else
        {
            lastName.setText(user.lastName);
        }
        if(getActivity().getIntent().getStringArrayExtra("Email") == null) {
            email.setText("rachnagr@gmail.com");
        }
        else
        {
            email.setText(user.emailID);
        }
        //email.setText(getActivity().getIntent().getStringExtra("Email"));
        if(getActivity().getIntent().getStringArrayExtra("Phone") == null) {

            phone.setText("9013130999");
        }
        else
        {
            phone.setText(getActivity().getIntent().getStringExtra("Email"));
        }
        if(getActivity().getIntent().getStringArrayExtra("Address") == null) {

            location.setText("IIIT-Delhi, Okhla Phase 3");
        }
        else
        {
            phone.setText();
        }*/



        //set the switch to ON
        user_toggle.setChecked(true);
        //attach a listener to check for changes in state
        user_toggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {

            @Override
            public void onCheckedChanged(CompoundButton buttonView,
                                         boolean isChecked) {

                if (isChecked) {
                    //Switch to Cook UI
                    Log.v("Toggle Button", "Cook UI");

                } else {
                    Log.v("Toggle Button", "User UI");
                    Intent i = new Intent(getContext(), User_homepage.class);
                    startActivity(i);

                }

            }
        });


    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile_cook, container, false);
    }
    public Bitmap getRoundedShape(Bitmap scaleBitmapImage) {
        int targetWidth = 50;
        int targetHeight = 50;
        Bitmap targetBitmap = Bitmap.createBitmap(targetWidth,
                targetHeight,Bitmap.Config.ARGB_8888);

        Canvas canvas = new Canvas(targetBitmap);
        Path path = new Path();
        path.addCircle(((float) targetWidth - 1) / 2,
                ((float) targetHeight - 1) / 2,
                (Math.min(((float) targetWidth),
                        ((float) targetHeight)) / 2),
                Path.Direction.CCW);

        canvas.clipPath(path);
        Bitmap sourceBitmap = scaleBitmapImage;
        canvas.drawBitmap(sourceBitmap,
                new Rect(0, 0, sourceBitmap.getWidth(),
                        sourceBitmap.getHeight()),
                new Rect(0, 0, targetWidth, targetHeight), null);
        return targetBitmap;
    }

}

package com.example.protichi.hestia_first;

import android.app.Activity;
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
        EditText lasttName = (EditText) getView().findViewById(R.id.editText2);
        EditText location = (EditText) getView().findViewById(R.id.editText3);
        EditText phone = (EditText) getView().findViewById(R.id.editText6);
        EditText email = (EditText) getView().findViewById(R.id.editText7);
        Switch user_toggle = (Switch) getView().findViewById(R.id.switch1);

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

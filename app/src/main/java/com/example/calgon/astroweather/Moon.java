package com.example.calgon.astroweather;

/**
 * Created by Calgon on 2016-04-24.
 */

import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class Moon extends Fragment {
    // Store instance variables
    private String title;
    private int page;
    SimpleDateFormat sdf;
    String currentDateandTime;

    // newInstance constructor for creating fragment with arguments
    public static Moon newInstance(int page, String title) {
        Moon fragmentSecond = new Moon();
        Bundle args = new Bundle();
        args.putInt("someInt", page);
        args.putString("someTitle", title);
        fragmentSecond.setArguments(args);
        return fragmentSecond;
    }

    // Store instance variables based on arguments passed
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        page = getArguments().getInt("someInt", 0);
        title = getArguments().getString("someTitle");
    }

    // Inflate the view for the fragment based on layout XML
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sun, container, false);
        final TextView text = (TextView) view.findViewById(R.id.sunText);
        sdf = new SimpleDateFormat("HH:mm:ss dd-MM-yyyy");
        CountDownTimer newtimer = new CountDownTimer(1000000000, 1000) {

            public void onTick(long millisUntilFinished) {
                currentDateandTime = sdf.format(new Date());
                text.setText("Current Time:\n" + currentDateandTime);
            }

            public void onFinish() {

            }
        };
        newtimer.start();
        return view;
    }
}

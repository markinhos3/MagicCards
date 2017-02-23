package com.example.markinhos3.magiccards;


import android.app.Application;
import android.util.Log;

import com.squareup.picasso.Picasso;

public class DrawCardApplication extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        Log.d("Application", "Creating application");

        Picasso.with(getApplicationContext()).setLoggingEnabled(true);
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        Log.d("Application", "Low memory detected");
    }


}

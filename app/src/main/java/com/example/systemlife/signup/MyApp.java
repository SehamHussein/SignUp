package com.example.systemlife.signup;

import android.app.Application;

import com.activeandroid.ActiveAndroid;

/**
 * Created by pc on 23/09/2017.
 */

public class MyApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        ActiveAndroid.initialize(this);
    }
}

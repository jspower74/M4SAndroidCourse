package com.example.js.firebasestudent;

import android.app.Application;

import com.firebase.client.Firebase;
/**
 * Created by ADMIN on 17/08/2016.
 */
public class Config extends Application {

    @Override
    public void onCreate(){
        super.onCreate();
        Firebase.setAndroidContext(this);

    }
}
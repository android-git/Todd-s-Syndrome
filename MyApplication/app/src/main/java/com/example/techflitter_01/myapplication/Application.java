package com.example.techflitter_01.myapplication;

import android.content.Context;

public class Application extends android.app.Application {

    private static Application mApp = null;

    @Override
    public void onCreate() {
        super.onCreate();
        mApp = this;
    }

    public static Context context() {
        return mApp.getApplicationContext();
    }

}

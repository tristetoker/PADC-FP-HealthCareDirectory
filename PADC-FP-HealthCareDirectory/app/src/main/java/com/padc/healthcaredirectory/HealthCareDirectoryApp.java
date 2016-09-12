package com.padc.healthcaredirectory;

import android.app.Application;
import android.content.Context;

/**
 * Created by Phyoe Khant on 9/4/2016.
 */
public class HealthCareDirectoryApp extends Application {

    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
    }

    public static Context getContext() {
        return context;
    }
}

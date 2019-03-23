package com.azhar.biodatanabi;

import android.app.Application;

import com.azhar.biodatanabi.utils.PreferencesApp;

/**
 * Created by Azhar Rivaldi on 23/03/2018.
 */

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        PreferencesApp.initPreferences(this);
    }
}

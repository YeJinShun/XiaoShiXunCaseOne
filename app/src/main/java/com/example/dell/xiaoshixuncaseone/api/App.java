package com.example.dell.xiaoshixuncaseone.api;

import android.app.Application;

public class App extends Application {
    public static App app;

    @Override
    public void onCreate() {
        super.onCreate();
        app = this;
    }

    public static App getApp() {
        return app;
    }
}

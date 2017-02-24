package com.u1fukui.android.demo.dagger.droidkaigi2017.di.module;

import android.app.Application;
import android.content.Context;
import android.net.ConnectivityManager;
import android.os.Handler;
import android.os.Looper;
import android.view.WindowManager;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AndroidModule {
    private final Application application;

    public AndroidModule(Application application) {
        this.application = application;
    }

    @Provides
    @Singleton
    Handler handler() {
        return new Handler(Looper.getMainLooper());
    }

    @Provides
    @Singleton
    ConnectivityManager provideConnectivityManager() {
        return (ConnectivityManager) application.getSystemService(Context.CONNECTIVITY_SERVICE);
    }

    @Provides
    @Singleton
    WindowManager windowManager() {
        return (WindowManager) application.getSystemService(Context.WINDOW_SERVICE);
    }
}

package com.u1fukui.android.demo.dagger.droidkaigi2017.di.module;

import android.support.v7.app.AppCompatActivity;

import dagger.Module;
import dagger.Provides;

@Module
public class ActivityModule {

    final AppCompatActivity activity;

    public ActivityModule(AppCompatActivity activity) {
        this.activity = activity;
    }

    @Provides
    public AppCompatActivity activity() {
        return activity;
    }
}

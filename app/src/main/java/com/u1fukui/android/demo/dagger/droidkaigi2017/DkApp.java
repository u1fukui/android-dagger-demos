package com.u1fukui.android.demo.dagger.droidkaigi2017;

import android.app.Application;
import android.support.annotation.NonNull;

import com.u1fukui.android.demo.dagger.droidkaigi2017.di.component.AppComponent;
import com.u1fukui.android.demo.dagger.droidkaigi2017.di.component.DaggerAppComponent;
import com.u1fukui.android.demo.dagger.droidkaigi2017.di.module.AppModule;
import com.u1fukui.android.demo.dagger.droidkaigi2017.di.module.AndroidModule;

public class DkApp extends Application {

    AppComponent appComponent;

    @NonNull
    public AppComponent getComponent() {
        return appComponent;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .androidModule(new AndroidModule(this))
                .build();
        appComponent.inject(this);
    }
}

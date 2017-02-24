package com.u1fukui.android.demo.dagger.droidkaigi2017.di.component;

import com.u1fukui.android.demo.dagger.droidkaigi2017.DkApp;
import com.u1fukui.android.demo.dagger.droidkaigi2017.di.module.ActivityModule;
import com.u1fukui.android.demo.dagger.droidkaigi2017.di.module.AndroidModule;
import com.u1fukui.android.demo.dagger.droidkaigi2017.di.module.AppModule;
import com.u1fukui.android.demo.dagger.droidkaigi2017.di.HttpClientModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AppModule.class, AndroidModule.class, HttpClientModule.class})
public interface AppComponent {

    void inject(DkApp application);

    ActivityComponent plus(ActivityModule module);
}


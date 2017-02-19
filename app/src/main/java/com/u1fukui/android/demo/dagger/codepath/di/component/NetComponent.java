package com.u1fukui.android.demo.dagger.codepath.di.component;

import android.content.SharedPreferences;

import com.u1fukui.android.demo.dagger.codepath.di.module.CodePathAppModule;
import com.u1fukui.android.demo.dagger.codepath.di.module.NetModule;

import javax.inject.Singleton;

import dagger.Component;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

@Singleton
@Component(modules = {CodePathAppModule.class, NetModule.class})
public interface NetComponent {

    // downstream components need these exposed
    Retrofit retrofit();

    OkHttpClient okHttpClient();

    SharedPreferences sharedPreferences();
}

package com.u1fukui.android.demo.dagger.droidkaigi2017.di.module;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import com.u1fukui.android.demo.dagger.api.GitHubApi;
import com.u1fukui.android.demo.dagger.droidkaigi2017.network.RequestInterceptor;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class AppModule {

    static final String SHARED_PREF_NAME = "preferences";

    private Context context;

    public AppModule(Application app) {
        context = app;
    }

    @Provides
    public Context provideContext() {
        return context;
    }

    @Provides
    public SharedPreferences provideSharedPreferences(Context context) {
        return context.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
    }

    @Provides
    public Interceptor provideRequestInterceptor(RequestInterceptor interceptor) {
        return interceptor;
    }

    @Singleton
    @Provides
    public GitHubApi provideGitHubApi(OkHttpClient client) {
        return new Retrofit.Builder().client(client)
                .baseUrl("https://api.github.com")
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(createGson()))
                .build()
                .create(GitHubApi.class);
    }

    private static Gson createGson() {
        return new GsonBuilder().setDateFormat("yyyy/MM/dd HH:mm:ss").create();
    }
}

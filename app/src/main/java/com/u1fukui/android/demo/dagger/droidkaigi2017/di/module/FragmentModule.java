package com.u1fukui.android.demo.dagger.droidkaigi2017.di.module;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import dagger.Module;
import dagger.Provides;

@Module
public class FragmentModule {

    final Fragment fragment;

    public FragmentModule(Fragment fragment) {
        this.fragment = fragment;
    }

    @Provides
    public FragmentManager provideFragmentManager() {
        return fragment.getFragmentManager();
    }
}

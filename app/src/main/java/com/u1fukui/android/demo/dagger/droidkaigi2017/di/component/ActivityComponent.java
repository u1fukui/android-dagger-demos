package com.u1fukui.android.demo.dagger.droidkaigi2017.di.component;

import android.support.v7.app.AppCompatActivity;

import com.u1fukui.android.demo.dagger.droidkaigi2017.DkMainActivity;
import com.u1fukui.android.demo.dagger.droidkaigi2017.di.module.ActivityModule;
import com.u1fukui.android.demo.dagger.droidkaigi2017.di.module.FragmentModule;
import com.u1fukui.android.demo.dagger.droidkaigi2017.di.scope.ActivityScope;

import dagger.Subcomponent;

@ActivityScope
@Subcomponent(modules = ActivityModule.class)
public interface ActivityComponent {

    void inject(DkMainActivity activity);

    FragmentComponent plus(FragmentModule module);
}

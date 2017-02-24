package com.u1fukui.android.demo.dagger.droidkaigi2017.di.component;

import com.u1fukui.android.demo.dagger.droidkaigi2017.HomeFragment;
import com.u1fukui.android.demo.dagger.droidkaigi2017.MyPageFragment;
import com.u1fukui.android.demo.dagger.droidkaigi2017.di.module.FragmentModule;
import com.u1fukui.android.demo.dagger.droidkaigi2017.di.scope.FragmentScope;

import dagger.Subcomponent;

@FragmentScope
@Subcomponent(modules = FragmentModule.class)
public interface FragmentComponent {

    void inject(HomeFragment fragment);

    void inject(MyPageFragment fragment);
}

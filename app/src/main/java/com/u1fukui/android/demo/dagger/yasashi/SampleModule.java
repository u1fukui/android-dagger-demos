package com.u1fukui.android.demo.dagger.yasashi;

import dagger.Module;
import dagger.Provides;

@Module
public class SampleModule {

    @Provides
    Dog provideDog() {
        return new Dog();
    }
}

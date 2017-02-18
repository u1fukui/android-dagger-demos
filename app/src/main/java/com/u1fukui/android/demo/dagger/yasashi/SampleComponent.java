package com.u1fukui.android.demo.dagger.yasashi;

import dagger.Component;

@Component(modules = SampleModule.class)
public interface SampleComponent {

    void inject(YasashiSampleActivity activity);
}

package com.u1fukui.android.demo.dagger.yasashi;

import javax.inject.Inject;

public class Owner {

    private Dog dog;

    @Inject
    public Owner(Dog dog) {
        this.dog = dog;
    }

    public String getPetName() {
        return dog.getName();
    }
}

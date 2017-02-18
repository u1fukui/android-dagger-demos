package com.u1fukui.android.demo.dagger.yasashi;

import javax.inject.Inject;

public class Owner {

    private Pet pet;

    @Inject
    public Owner(Pet pet) {
        this.pet = pet;
    }

    public String getPetName() {
        return pet.getName();
    }
}

package com.u1fukui.android.demo.dagger.yasashi;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class OwnerTest {

    private static final String NAME = "ペットの名前";

    @Test
    public void getPetName() throws Exception {
        Owner owner = new Owner(new Pet() {
            @Override
            public String getName() {
                return NAME;
            }
        });

        assertThat(owner.getPetName(), is(NAME));
    }
}

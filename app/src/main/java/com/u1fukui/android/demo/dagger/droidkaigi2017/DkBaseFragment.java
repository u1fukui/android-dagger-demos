package com.u1fukui.android.demo.dagger.droidkaigi2017;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;

import com.u1fukui.android.demo.dagger.droidkaigi2017.di.component.FragmentComponent;
import com.u1fukui.android.demo.dagger.droidkaigi2017.di.module.FragmentModule;

public abstract class DkBaseFragment extends Fragment {

    private FragmentComponent fragmentComponent;

    @NonNull
    public FragmentComponent getComponent() {
        if (fragmentComponent != null) {
            return fragmentComponent;
        }

        Activity activity = getActivity();
        if (activity instanceof DkBaseActivity) {
            fragmentComponent = ((DkBaseActivity) activity).getComponent().plus(new FragmentModule(this));
            return fragmentComponent;
        } else {
            throw new IllegalStateException(
                    "The activity of this fragment is not an instance of BaseActivity");
        }
    }
}
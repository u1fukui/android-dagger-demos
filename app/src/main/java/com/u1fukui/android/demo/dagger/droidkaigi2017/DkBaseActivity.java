package com.u1fukui.android.demo.dagger.droidkaigi2017;

import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.u1fukui.android.demo.dagger.droidkaigi2017.di.component.ActivityComponent;
import com.u1fukui.android.demo.dagger.droidkaigi2017.di.module.ActivityModule;

public abstract class DkBaseActivity extends AppCompatActivity {

    private ActivityComponent activityComponent;

    @NonNull
    public ActivityComponent getComponent() {
        if (activityComponent == null) {
            DkApp app = (DkApp) getApplication();
            activityComponent = app.getComponent().plus(new ActivityModule(this));
        }
        return activityComponent;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    final void replaceFragment(@NonNull Fragment fragment, @IdRes @LayoutRes int layoutResId) {
        final FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(layoutResId, fragment, fragment.getClass().getSimpleName());
        ft.commit();
    }

    final void initBackToolbar(Toolbar toolbar) {
        setSupportActionBar(toolbar);

        ActionBar bar = getSupportActionBar();
        if (bar != null) {
            bar.setTitle(toolbar.getTitle());
            bar.setDisplayHomeAsUpEnabled(true);
            bar.setDisplayShowHomeEnabled(true);
            bar.setDisplayShowTitleEnabled(true);
            bar.setHomeButtonEnabled(true);
        }
    }
}

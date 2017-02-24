package com.u1fukui.android.demo.dagger.droidkaigi2017;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.MenuItem;

import com.u1fukui.android.demo.dagger.R;

/**
 * https://github.com/DroidKaigi/conference-app-2017
 */
public class DkMainActivity extends DkBaseActivity {

    private BottomNavigationView bottomNav;

    private Fragment homeFragment;

    private Fragment myPageFragment;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_droidkaigi);

        bottomNav = (BottomNavigationView) findViewById(R.id.bottom_nav);

        getComponent().inject(this);

        initViews();
        initFragments(savedInstanceState);
    }

    private void initViews() {
        bottomNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                item.setChecked(true);
                switch (item.getItemId()) {
                    case R.id.nav_home:
                        switchFragment(homeFragment, HomeFragment.TAG);
                        break;
                    case R.id.nav_mypage:
                        switchFragment(myPageFragment, MyPageFragment.TAG);
                        break;
                }
                return false;
            }
        });
    }

    private void initFragments(Bundle savedInstanceState) {
        FragmentManager manager = getSupportFragmentManager();
        homeFragment = manager.findFragmentByTag(HomeFragment.TAG);
        myPageFragment = manager.findFragmentByTag(MyPageFragment.TAG);

        if (homeFragment == null) {
            homeFragment = HomeFragment.newInstance();
        }
        if (myPageFragment == null) {
            myPageFragment = MyPageFragment.newInstance();
        }

        if (savedInstanceState == null) {
            switchFragment(homeFragment, HomeFragment.TAG);
        }
    }

    private boolean switchFragment(@NonNull Fragment fragment, @NonNull String tag) {
        if (fragment.isAdded()) {
            return false;
        }

        final FragmentManager manager = getSupportFragmentManager();
        final FragmentTransaction ft = manager.beginTransaction();

        final Fragment currentFragment = manager.findFragmentById(R.id.content_view);
        if (currentFragment != null) {
            ft.detach(currentFragment);
        }
        if (fragment.isDetached()) {
            ft.attach(fragment);
        } else {
            ft.add(R.id.content_view, fragment, tag);
        }
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                .commit();

        // NOTE: When this method is called by user's continuous hitting at the same time,
        // transactions are queued, so necessary to reflect commit instantly before next transaction starts.
        manager.executePendingTransactions();

        return true;
    }
}

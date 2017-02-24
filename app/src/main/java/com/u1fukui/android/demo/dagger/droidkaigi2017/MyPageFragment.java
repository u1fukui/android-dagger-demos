package com.u1fukui.android.demo.dagger.droidkaigi2017;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.u1fukui.android.demo.dagger.R;

public class MyPageFragment extends DkBaseFragment {

    public static final String TAG = MyPageFragment.class.getSimpleName();

    public static MyPageFragment newInstance() {
        return new MyPageFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.text, container, false);

        TextView textView = (TextView) view.findViewById(R.id.text);
        textView.setText("MY PAGE");

        return view;
    }
}

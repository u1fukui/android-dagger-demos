package com.u1fukui.android.demo.dagger.droidkaigi2017;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.u1fukui.android.demo.dagger.R;
import com.u1fukui.android.demo.dagger.api.GitHubApi;
import com.u1fukui.android.demo.dagger.api.model.GitHubRepository;

import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeFragment extends DkBaseFragment {

    public static final String TAG = HomeFragment.class.getSimpleName();

    @Inject
    GitHubApi gitHubApi;

    public static HomeFragment newInstance() {
        return new HomeFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.text, container, false);

        final TextView textView = (TextView) view.findViewById(R.id.text);

        getComponent().inject(this);
        gitHubApi.getRepositories("octocat").enqueue(new Callback<List<GitHubRepository>>() {
            @Override
            public void onResponse(Call<List<GitHubRepository>> call, Response<List<GitHubRepository>> response) {
                StringBuilder sb = new StringBuilder();
                for (GitHubRepository repo : response.body()) {
                    sb.append(repo.getName()).append('\n');
                }
                textView.setText(sb.toString());
            }

            @Override
            public void onFailure(Call<List<GitHubRepository>> call, Throwable t) {
                textView.setText(t.getMessage());
            }
        });

        return view;
    }
}

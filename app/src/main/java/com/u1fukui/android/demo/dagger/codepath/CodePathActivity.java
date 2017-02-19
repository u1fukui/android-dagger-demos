package com.u1fukui.android.demo.dagger.codepath;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.u1fukui.android.demo.dagger.R;
import com.u1fukui.android.demo.dagger.codepath.api.GitHubApi;
import com.u1fukui.android.demo.dagger.codepath.model.GitHubRepository;

import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * https://guides.codepath.com/android/Dependency-Injection-with-Dagger-2
 */
public class CodePathActivity extends AppCompatActivity {

    @Inject
    GitHubApi gitHubApi;

    @Inject
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text);

        // assign singleton instances to fields
        // We need to cast to `CodePathApp` in order to get the right method
        ((CodePathApp) getApplication()).getGitHubComponent().inject(this);

        final TextView textView = (TextView) findViewById(R.id.text);
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
    }
}

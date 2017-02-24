package com.u1fukui.android.demo.dagger.api;

import com.u1fukui.android.demo.dagger.api.model.GitHubRepository;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface GitHubApi {

    @GET("/users/{user_name}/repos")
    Call<List<GitHubRepository>> getRepositories(@Path("user_name") String userName);
}

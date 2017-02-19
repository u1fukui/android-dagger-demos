package com.u1fukui.android.demo.dagger.codepath.api;

import com.u1fukui.android.demo.dagger.codepath.model.GitHubRepository;

import java.util.List;

import lombok.Getter;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface GitHubApi {

    @GET("/users/{user_name}/repos")
    Call<List<GitHubRepository>> getRepositories(@Path("user_name") String userName);
}

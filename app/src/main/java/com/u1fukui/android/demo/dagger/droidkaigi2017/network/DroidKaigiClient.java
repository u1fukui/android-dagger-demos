package com.u1fukui.android.demo.dagger.droidkaigi2017.network;

import com.u1fukui.android.demo.dagger.api.GitHubApi;
import com.u1fukui.android.demo.dagger.api.model.GitHubRepository;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import retrofit2.Call;
import retrofit2.Response;

@Singleton
public class DroidKaigiClient {

    private final GitHubApi gitHubApi;

    private static final int INCLUDE_ANONYMOUS = 1;

    private static final int MAX_PER_PAGE = 100;

    @Inject
    public DroidKaigiClient(GitHubApi gitHubApi) {
        this.gitHubApi = gitHubApi;
    }

    public Call<List<GitHubRepository>> getContributors() {
        return gitHubApi.getRepositories("octocat");
    }
}

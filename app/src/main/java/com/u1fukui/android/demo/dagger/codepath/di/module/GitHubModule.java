package com.u1fukui.android.demo.dagger.codepath.di.module;

import com.u1fukui.android.demo.dagger.codepath.api.GitHubApi;
import com.u1fukui.android.demo.dagger.codepath.di.scope.UserScope;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

@Module
public class GitHubModule {

    @Provides
    @UserScope
    public GitHubApi provideGitHubApi(Retrofit retrofit) {
        return retrofit.create(GitHubApi.class);
    }
}

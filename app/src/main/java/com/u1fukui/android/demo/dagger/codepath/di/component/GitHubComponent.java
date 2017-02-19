package com.u1fukui.android.demo.dagger.codepath.di.component;

import com.u1fukui.android.demo.dagger.codepath.CodePathActivity;
import com.u1fukui.android.demo.dagger.codepath.di.module.GitHubModule;
import com.u1fukui.android.demo.dagger.codepath.di.scope.UserScope;

import dagger.Component;

@UserScope
@Component(dependencies = NetComponent.class, modules = GitHubModule.class)
public interface GitHubComponent {

    void inject(CodePathActivity activity);
}

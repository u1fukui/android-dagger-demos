package com.u1fukui.android.demo.dagger.codepath;

import android.app.Application;

import com.u1fukui.android.demo.dagger.codepath.di.component.DaggerGitHubComponent;
import com.u1fukui.android.demo.dagger.codepath.di.component.DaggerNetComponent;
import com.u1fukui.android.demo.dagger.codepath.di.component.GitHubComponent;
import com.u1fukui.android.demo.dagger.codepath.di.module.CodePathAppModule;
import com.u1fukui.android.demo.dagger.codepath.di.module.GitHubModule;
import com.u1fukui.android.demo.dagger.codepath.di.component.NetComponent;
import com.u1fukui.android.demo.dagger.codepath.di.module.NetModule;

import lombok.Getter;

public class CodePathApp extends Application {

    @Getter
    private NetComponent netComponent;

    @Getter
    private GitHubComponent gitHubComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        netComponent = DaggerNetComponent.builder()
                // list of modules that are part of this component need to be created here too
                .codePathAppModule(new CodePathAppModule(this)) // This also corresponds to the name of your module: %component_name%Module
                .netModule(new NetModule("https://api.github.com"))
                .build();

        gitHubComponent = DaggerGitHubComponent.builder()
                .netComponent(netComponent)
                .gitHubModule(new GitHubModule())
                .build();
    }
}

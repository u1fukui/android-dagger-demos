package com.u1fukui.android.demo.dagger.yasashi;

import dagger.Module;
import dagger.Provides;

@Module
public class HttpClientModule {

    static final String CACHE_FILE_NAME = "okhttp.cache";

    static final long MAX_CACHE_SIZE = 4 * 1024 * 1024;

    @Singleton
    @Provides
    public OkHttpClient provideHttpClient(Context context, Interceptor interceptor) {
        File cacheDir = new File(context.getCacheDir(), CACHE_FILE_NAME);
        Cache cache = new Cache(cacheDir, MAX_CACHE_SIZE);

        OkHttpClient.Builder c = new OkHttpClient.Builder().cache(cache).addInterceptor(interceptor);
        return c.build();
    }
}

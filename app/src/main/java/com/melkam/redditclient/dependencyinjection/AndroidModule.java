package com.melkam.redditclient.dependencyinjection;

import android.app.Application;

import com.melkam.redditclient.RedditClientApp;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * A module for Android-specific dependencies which require a {@link android.content.Context} or
 * {@link android.app.Application} to create. Also may be used for singleton objects,
 * such logger and shared preference.
 *
 * @author Melkamu
 */
@Module(
        includes = {
            ApiModule.class,
        },
        injects = {
            RedditClientApp.class,
        },

        library = true
)
public class AndroidModule {

    private final RedditClientApp mApplication;

    public AndroidModule(RedditClientApp application) {
        mApplication = application;
    }

    @Provides
    @Singleton
    Application provideApplication() {
        return mApplication;
    }
}

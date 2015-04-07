package com.melkam.redditclient;

import android.app.Application;

import com.melkam.redditclient.dependencyinjection.AndroidModule;

import java.util.Arrays;
import java.util.List;

import dagger.ObjectGraph;

/**
 * @author Melkamu A
 */
public class RedditClientApp extends Application {

    private static RedditClientApp sInstance;

    private ObjectGraph mGraph;

    /**
     * Only use this for easy access to inject function
     */
    public static RedditClientApp getInstance()
    {
        return sInstance;
    }

    @Override
    public void onCreate()
    {
        super.onCreate();

        // Create ability to get instance
        sInstance = this;

        // Setup DI
        mGraph = ObjectGraph.create(getModules().toArray());
    }

    public RedditClientApp()
    {
        super();
    }

    /**
     * Used for injecting dependencies
     *
     * @param object object that needs dependencies injected
     */
    public void inject(Object object)
    {
        mGraph.inject(object);
    }

    /**
     * Gets mGraph.
     *
     * @return Value of mGraph.
     */
    public ObjectGraph getApplicationGraph()
    {
        return mGraph;
    }

    /**
     * Creates a list containing all the modules required for dagger
     */
    private List<Object> getModules()
    {
        return Arrays.<Object>asList(
                new AndroidModule(this)
        );
    }
}

package com.melkam.redditclient.dependencyinjection;

import android.content.Context;

import com.melkam.redditclient.activity.BaseActivity;
import com.melkam.redditclient.activity.MainActivity;
import com.melkam.redditclient.fragment.TopicListFragment;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * This module represents objects which exist only for the scope of a single activity. We can
 * safely create singletons using the activity instance because this entire object graph will
 * only ever exist inside of that activity.
 *
 * @author Melkamu
 */
@Module(
        addsTo = AndroidModule.class,
        injects = {
                // Activities
                MainActivity.class,

                // Fragments
                TopicListFragment.class
        },
        complete = false,
        library = true
)
public class ActivityModule {

    private final BaseActivity activity;

    public ActivityModule(BaseActivity activity)
    {
        this.activity = activity;
    }

    /**
     * Allow the activity context to be injected but require that it be annotated with {@link
     * {package}.dependencyinjection.annotations.ForActivity @ForActivity} to explicitly differentiate it from
     * application context.
     */
    @Provides
    @Singleton
    Context provideActivityContext()
    {
        return activity;
    }
}

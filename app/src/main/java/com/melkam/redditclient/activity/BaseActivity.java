package com.melkam.redditclient.activity;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;

import com.melkam.redditclient.R;
import com.melkam.redditclient.RedditClientApp;
import com.melkam.redditclient.dependencyinjection.ActivityModule;

import java.util.Arrays;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import dagger.ObjectGraph;

/**
 * @author Melkamu
 */
public class BaseActivity extends ActionBarActivity
{
    private ObjectGraph mActivityGraph;

    @InjectView(R.id.redditclient_actionbar)
    Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        // Set up object graph before calling super.onCreate so we guarantee mObjectGraph
        // is non-null before child fragments' onAttach is called
        injectSelf();

        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

        ButterKnife.inject(this);

        setSupportActionBar(mToolbar);
    }

    @Override
    protected void onDestroy()
    {
        // Eagerly clear the reference to the activity graph to allow
        // it to be garbage collected as soon as possible.
        mActivityGraph = null;
        super.onDestroy();
    }

    protected List<Object> getModules()
    {
        return Arrays.<Object>asList(
                new ActivityModule(this)
        );
    }

    private void injectSelf()
    {
        // Inject objects into the object graph at the activity level, this is for
        // objects that need values that aren't available until the activity is created.
        RedditClientApp application = RedditClientApp.getInstance();
        mActivityGraph = application
                .getApplicationGraph()
                .plus(
                        getModules().toArray()
                );

        mActivityGraph.inject(this);
    }

    /**
     * Inject Dagger
     * <p/>
     * Uses Dagger to inject the object with this object's Dagger object graph
     */
    public void injectDagger(Object object)
    {
        mActivityGraph.inject(object);
    }

}

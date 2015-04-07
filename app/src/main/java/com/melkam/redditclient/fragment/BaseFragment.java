package com.melkam.redditclient.fragment;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;

import com.melkam.redditclient.R;
import com.melkam.redditclient.activity.BaseActivity;

/**
 * @author Melkamu
 */
public abstract class BaseFragment extends Fragment
{
    @Override
    public void onActivityCreated(Bundle savedInstanceState)
    {
        super.onActivityCreated(savedInstanceState);

        this.injectDagger();
    }

    /**
     * Inject Dagger
     * <p/>
     * Uses Dagger to inject the current class with the base activity
     * dependencies.
     * This method may not be overridden, as fragments do not need their own
     * dependency graph.
     */
    final protected void injectDagger()
    {
        BaseActivity parentActivity = (BaseActivity) this.getActivity();
        parentActivity.injectDagger(this);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        // Default to showing app name as title
        activity.setTitle(R.string.app_name);
    }
}


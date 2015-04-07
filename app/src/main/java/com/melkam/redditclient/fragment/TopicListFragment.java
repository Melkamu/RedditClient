package com.melkam.redditclient.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.melkam.redditclient.R;
import com.melkam.redditclient.adapter.TopTopicsAdapter;
import com.melkam.redditclient.api.ApiEndPoint;
import com.melkam.redditclient.api.TopicResponseHandler;
import com.melkam.redditclient.decoration.DividerItemDecoration;
import com.melkam.redditclient.model.Topic;

import java.util.List;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.InjectView;
import retrofit.RetrofitError;

/**
 * Fragment to display top 25 reddit entries
 *
 * @author Melkamu
 */
public class TopicListFragment extends BaseFragment implements TopicResponseHandler.Listener{

    @InjectView(R.id.content_container) View mContentContainer;
    @InjectView(R.id.topics)
    RecyclerView mTopicsView;
    @InjectView(R.id.loading_indicator)
    ProgressBar mLoadingView;
    @InjectView(R.id.error)
    TextView mErrorView;

    @Inject
    ApiEndPoint mApiEndPoint;

    private TopTopicsAdapter mAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        activity.setTitle(R.string.top_topics_title);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_toplist, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.inject(this, view);

        mTopicsView.setLayoutManager(new LinearLayoutManager(getActivity(),
                LinearLayoutManager.VERTICAL, false));
        mTopicsView.addItemDecoration(new DividerItemDecoration(getActivity(),
                DividerItemDecoration.VERTICAL_LIST));

        mAdapter = new TopTopicsAdapter(getActivity());
        mTopicsView.setAdapter(mAdapter);

        // assuming content is not fetched yet
        mLoadingView.setVisibility(View.VISIBLE);
        mContentContainer.setVisibility(View.GONE);
    }

    @Override
    public void onResume() {
        super.onResume();
        // fetch api
        fetchTopTopics();
    }

    private void fetchTopTopics() {
        if (mApiEndPoint != null) {
            mApiEndPoint.fetchTopTopics(new TopicResponseHandler(this));
        }
    }

    @Override
    public void onFetchSuccess(List<Topic> topics) {
        mContentContainer.setVisibility(View.VISIBLE);
        mLoadingView.setVisibility(View.GONE);
        mErrorView.setVisibility(View.GONE);
        mAdapter.setTopics(topics);
    }

    @Override
    public void onError(RetrofitError retrofitError) {
        mContentContainer.setVisibility(View.GONE);
        mLoadingView.setVisibility(View.GONE);
        mErrorView.setVisibility(View.VISIBLE);
    }
}

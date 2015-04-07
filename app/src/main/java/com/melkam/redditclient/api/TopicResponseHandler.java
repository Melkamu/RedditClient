package com.melkam.redditclient.api;

import android.util.Log;

import com.google.gson.Gson;
import com.melkam.redditclient.model.Child;
import com.melkam.redditclient.model.HotResponse;
import com.melkam.redditclient.model.Topic;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * @author Melkamu
 */
public class TopicResponseHandler implements Callback<HotResponse>
{
    public interface Listener
    {
        public void onFetchSuccess(List<Topic> topics);
        public void onError(final RetrofitError retrofitError);
    }

    private Collection<Listener> mListeners = new ArrayList<Listener>();

    public TopicResponseHandler(Listener listener) {
        mListeners.add(listener);
    }

    @Override
    public void success(HotResponse hotResponse, Response response) {

        ArrayList<Topic> topics = new ArrayList<>();

        if (hotResponse != null) {
            for (Child child : hotResponse.getData().getChildren()) {
                topics.add(child.getTopic());
            }
        }

        for (Listener listener : mListeners) {
            listener.onFetchSuccess(topics);
        }
    }

    @Override
    public void failure(RetrofitError error) {
        for (Listener listener : mListeners) {
            listener.onError(error);
        }
    }
}

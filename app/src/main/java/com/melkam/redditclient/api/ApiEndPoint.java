package com.melkam.redditclient.api;

import com.melkam.redditclient.model.HotResponse;

import retrofit.Callback;
import retrofit.http.GET;

/**
 * Reddit topics api endpoint
 *
 * @author Melkamu
 */
public interface ApiEndPoint {

    @GET("/hot/.json")
    public void fetchTopTopics(Callback<HotResponse> callback);

}

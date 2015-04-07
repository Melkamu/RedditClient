package com.melkam.redditclient.model;

import com.google.gson.annotations.SerializedName;

/**
 * @author Melkamu
 */
public class HotResponse {

    @SerializedName("data")
    private Data mData;

    public HotResponse(Data data) {
        mData = data;
    }

    public Data getData() {
        return mData;
    }

}

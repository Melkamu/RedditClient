package com.melkam.redditclient.model;

import com.google.gson.annotations.SerializedName;


/**
 * @author Melkamu
 */
public class Child {

    @SerializedName("kind")
    private String mKind;
    @SerializedName("data")
    private Topic mTopic;

    public Topic getTopic() {
        return mTopic;
    }

    public void setTopic(Topic topic) {
        this.mTopic = topic;
    }

    public String getmKind() {
        return mKind;
    }

    public void setmKind(String mKind) {
        this.mKind = mKind;
    }
}

package com.melkam.redditclient.model;

import com.google.gson.annotations.SerializedName;

/**
 * Model mapping Reddit Topics
 *
 * @author Melkamu
 */
public class Topic {

    @SerializedName("title")
    private String mTitle;

    @SerializedName("id")
    private String mId;

    @SerializedName("author")
    private String mAuthor;

    @SerializedName("thumbnail")
    private String mThumbnail;

    @SerializedName("url")
    private String mUrl;

    @SerializedName("score")
    private int mScore;

    @SerializedName("num_comments")
    private int mNumComments;

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public String getId() {
        return mId;
    }

    public void setId(String id) {
        mId = id;
    }

    public String getAuthor() {
        return mAuthor;
    }

    public void setAuthor(String author) {
        mAuthor = author;
    }

    public String getThumbnail() {
        return mThumbnail;
    }

    public void setThumbnail(String thumbnail) {
        mThumbnail = thumbnail;
    }

    public String getUrl() {
        return mUrl;
    }

    public void setUrl(String url) {
        mUrl = url;
    }

    public int getScore() {
        return mScore;
    }

    public void setScore(int score) {
        mScore = score;
    }

    public int getNumComments() {
        return mNumComments;
    }

    public void setNumComments(int numComments) {
        mNumComments = numComments;
    }
}

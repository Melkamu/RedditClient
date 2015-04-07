package com.melkam.redditclient.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * @author Melkamu
 */
public class Data {

    @SerializedName("kind")
    private String mKind;
    @SerializedName("modhash")
    private String mModhash;
    @SerializedName("data")
    private Data mData;
    @SerializedName("children")
    private List<Child> mChildren;

    public String getModhash() {
        return mModhash;
    }

    public void setModhash(String modhash) {
        mModhash = modhash;
    }

    public Data getData() {
        return mData;
    }

    public void setData(Data data) {
        mData = data;
    }

    public List<Child> getChildren() {
        return mChildren;
    }

    public void setChildren(List<Child> children) {
        mChildren = children;
    }

    public String getKind() {
        return mKind;
    }

    public void setKind(String kind) {
        mKind = kind;
    }
}

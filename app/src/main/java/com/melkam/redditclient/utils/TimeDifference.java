package com.melkam.redditclient.utils;

import android.text.format.DateUtils;

/**
 * @author Melkamu
 */
public class TimeDifference {

    /**
     * Returns the time difference between two time stamps in the format "3 minutes ago."
     *
     * @param time
     * @return String time difference
     */
    public static String getTimeStamp(long time) {
        // change to mills
        long postTime = time * 1000;
        long currentTime = System.currentTimeMillis();

        // gives the difference
        String tStamp = (String) DateUtils.getRelativeTimeSpanString(postTime, currentTime, 0);
        return tStamp;
    }
}

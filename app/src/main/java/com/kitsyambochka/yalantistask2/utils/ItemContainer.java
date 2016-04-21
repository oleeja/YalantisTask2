package com.kitsyambochka.yalantistask2.utils;

/**
 * Created by Developer on 17.04.2016.
 */
public class ItemContainer {
    private String mEconomy;
    private String mAddress;
    private String mDate;
    private String mDays;
    private String mLike;
    private int mIcon;

    public ItemContainer(String economy, String address, String date, String days, String like, int icon) {
        mEconomy = economy;
        mAddress = address;
        mDate = date;
        mDays = days;
        mLike = like;
        mIcon = icon;
    }

    public String getAddress() {
        return mAddress;
    }

    public String getEconomy() {
        return mEconomy;
    }

    public String getDate() {
        return mDate;
    }

    public String getDays() {
        return mDays;
    }

    public String getLike() {
        return mLike;
    }

    public int getIcon() {
        return mIcon;
    }
}

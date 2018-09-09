package com.lucas.changelogdialog;


import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.List;

public class Release {
    private int mVersionMajor;
    private int mVersionMinor;
    private int mVersionPatch;
    private String mReleaseDescription;
    private List<ChangelogItem> mItems; //todo umbenennen
    private Calendar mReleaseDate;

    public Release(int major, @Nullable Integer minor, @Nullable Integer patch, @NonNull Calendar releaseDate, String releaseInformation, List<ChangelogItem> items) {

        mVersionMajor = major;
        mVersionMinor = minor != null ? minor : 0;
        mVersionPatch = patch != null ? patch : 0;

        mReleaseDate = releaseDate;

        mReleaseDescription = releaseInformation;

        mItems = items;
    }

    public void setReleaseDescription(String releaseInformation) {
        mReleaseDescription = releaseInformation;
    }

    public String getReleaseDescription() {
        return mReleaseDescription;
    }

    public void addChangelogItem(ChangelogItem item) {
        mItems.add(item);
    }

    public void addChangelogItems(List<ChangelogItem> items) {

        mItems.addAll(items);
    }

    public List<ChangelogItem> getItems() {
        return mItems;
    }

    public String getReleaseVersion() {

        return String.format("%s.%s.%s", mVersionMajor, mVersionMinor, mVersionPatch);
    }

    public String getReleaseDate() {

        return DateFormat.getDateInstance(DateFormat.SHORT).format(mReleaseDate.getTimeInMillis());
    }
}

package com.lucas.changelogdialog;

public class Bug implements ChangelogItem {
    private static final String BUG = "Bug";

    private String mDescription;

    public Bug(String additionalInformation) {
        mDescription = additionalInformation != null ? additionalInformation : "";
    }

    @Override
    public String getDescription() {
        return mDescription;
    }

    @Override
    public String getType() {
        return BUG;
    }
}

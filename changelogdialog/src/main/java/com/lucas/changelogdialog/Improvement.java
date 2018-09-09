package com.lucas.changelogdialog;

public class Improvement implements ChangelogItem {
    private static final String IMPROVEMENT = "Improvement";

    private String description;

    public Improvement(String description) {

        this.description = description;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public String getType() {
        return IMPROVEMENT;
    }
}

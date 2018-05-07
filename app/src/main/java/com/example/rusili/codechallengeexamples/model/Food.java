package com.example.rusili.codechallengeexamples.model;

public class Food {
    private String title;
    private String image;

    // Removed all setters.
    public String getTitle() {
        return title;
    }

    // Renamed the getter because the field is confusing.
    public String getImageEndpoint() {
        return image;
    }
}

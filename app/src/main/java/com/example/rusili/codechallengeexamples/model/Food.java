package com.example.rusili.codechallengeexamples.model;

public class Food {

    private String image; // After making quick fixes, I found out this field holds the image Url endpoint. This is an example of bad naming.
    private String title;

    // Don't actually need setters. Useless code.
    public void setImage(String image) {
        this.image = image;
    }

    public String getImage() {
        return image;
    }

    // Don't actually need setters. Useless code.
    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}

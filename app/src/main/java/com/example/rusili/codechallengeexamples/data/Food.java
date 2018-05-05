package com.example.rusili.codechallengeexamples.data;

import android.support.annotation.Nullable;

public class Food {
    private String title;
    private String image;

    @Nullable
    public String getTitle() {
        return title;
    }

    @Nullable
    public String getImageEndpoint() {
        return image;
    }
}

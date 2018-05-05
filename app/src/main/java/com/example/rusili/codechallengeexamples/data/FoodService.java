package com.example.rusili.codechallengeexamples.data;

import android.support.annotation.NonNull;

import com.example.rusili.codechallengeexamples.R;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class FoodService {
    private Retrofit retrofit;

    public FoodService(@NonNull String domain) {
        retrofit = new Retrofit.Builder()
                .baseUrl(domain)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    @NonNull
    public FoodApi getFoodApi() {
        return retrofit.create(FoodApi.class);
    }
}
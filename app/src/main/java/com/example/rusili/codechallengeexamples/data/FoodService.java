package com.example.rusili.codechallengeexamples.data;

import android.support.annotation.NonNull;

import com.example.rusili.codechallengeexamples.R;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created a separate class just to create the service.
 * Presenters and Views don't need to know about this.
 */
public class FoodService {
    private Retrofit retrofit;

    /**
     * Passing in the domain since I have no reference to context/resources here.
     * Notice I'm only creating the retrofit object once--in the constructor.
     * Otherwise, I can get the Food Api as many times as I want.
     */
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
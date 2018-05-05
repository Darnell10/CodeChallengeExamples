package com.example.rusili.codechallengeexamples.data;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface FoodApi {
    @GET("/assets/cmx/us/messages/collections.json")
    Call<List<Food>> getFoodList();
}

package com.example.rusili.codechallengeexamples.service;

import com.example.rusili.codechallengeexamples.model.Food;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface FoodService {
    @GET("/assets/cmx/us/messages/collections.json")
    Call<List<Food>> listFood();
}

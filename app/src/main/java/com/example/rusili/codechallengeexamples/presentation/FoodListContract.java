package com.example.rusili.codechallengeexamples.presentation;

import com.example.rusili.codechallengeexamples.data.Food;

import java.util.List;

public interface FoodListContract {

    interface View{
        void setRecyclerView(List<Food> foodList);
    }
}

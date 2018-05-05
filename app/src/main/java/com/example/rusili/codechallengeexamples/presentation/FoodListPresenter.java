package com.example.rusili.codechallengeexamples.presentation;

import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.util.Log;

import com.example.rusili.codechallengeexamples.R;
import com.example.rusili.codechallengeexamples.data.Food;
import com.example.rusili.codechallengeexamples.data.FoodApi;
import com.example.rusili.codechallengeexamples.data.FoodService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class FoodListPresenter implements FoodListContract.Presenter {
    private final static String TAG = FoodListActivity.class.getSimpleName();

    private FoodListContract.View viewImpl;
    private FoodService foodService;
    private Resources resources;

    public FoodListPresenter(@NonNull FoodListContract.View viewImpl,
                             @NonNull FoodService foodService,
                             @NonNull Resources resources) {
        this.viewImpl = viewImpl;
        this.foodService = foodService;
        this.resources = resources;
    }

    @Override
    public void getFoodList() {
        FoodApi foodApi = foodService.getFoodApi();
        Call<List<Food>> foodCall = foodApi.getFoodList();

        foodCall.enqueue(new Callback<List<Food>>() {
            @Override
            public void onResponse(Call<List<Food>> call, Response<List<Food>> response) {
                List<Food> foodList = response.body();
                viewImpl.setRecyclerView(foodList);
            }

            @Override
            public void onFailure(Call<List<Food>> call, Throwable t) {
                Log.e(TAG, t.getMessage());
                viewImpl.showSnackBar(resources.getString(R.string.error_no_internet));
            }
        });
    }
}

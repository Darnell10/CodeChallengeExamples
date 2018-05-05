package com.example.rusili.codechallengeexamples;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.rusili.codechallengeexamples.adapter.FoodListAdapter;
import com.example.rusili.codechallengeexamples.model.Food;
import com.example.rusili.codechallengeexamples.service.FoodService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private final static String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Retrofit retrofit = createRetrofit();
        callService(retrofit);
    }

    @NonNull
    private Retrofit createRetrofit() {
        return new Retrofit.Builder()
                .baseUrl(getString(R.string.WW_Domain))
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    private void callService(@NonNull Retrofit retrofit) {
        FoodService foodService = retrofit.create(FoodService.class);
        Call<List<Food>> foodCall = foodService.getFoodList();
        foodCall.enqueue(new Callback<List<Food>>() {
            @Override
            public void onResponse(Call<List<Food>> call, Response<List<Food>> response) {
                List<Food> foodList = response.body();
                setFoodAdapter(foodList);
            }

            @Override
            public void onFailure(Call<List<Food>> call, Throwable t) {
                Log.e(TAG, t.getMessage());
            }
        });
    }

    private void setFoodAdapter(@Nullable List<Food> foodList) {
        RecyclerView recyclerView = findViewById(R.id.food_rv);
        FoodListAdapter adapter = new FoodListAdapter(foodList);
        recyclerView.setAdapter(adapter);
    }
}
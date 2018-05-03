package com.example.rusili.codechallengeexamples;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.rusili.codechallengeexamples.adapter.FoodListAdapter;
import com.example.rusili.codechallengeexamples.model.Food;
import com.example.rusili.codechallengeexamples.service.FoodService;
import com.example.rusili.codechallengeexamples.util.JSONConstants;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        callService();
    }

    private void callService() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(JSONConstants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        FoodService foodService = retrofit.create(FoodService.class);
        Call<List<Food>> foodCall = foodService.listFood();
        foodCall.enqueue(new Callback<List<Food>>() {
            @Override
            public void onResponse(Call<List<Food>> call, Response<List<Food>> response) {
                List<Food> foodList = response.body();
                setupView(foodList);
            }

            @Override
            public void onFailure(Call<List<Food>> call, Throwable t) {
                Log.e(TAG, t.toString());
            }
        });
    }

    private void setupView(List<Food> foodList) {
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        final RecyclerView recyclerView = findViewById(R.id.foodRecyclerview);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setAdapter(new FoodListAdapter(foodList, R.layout.food_list_row, getApplicationContext()));
    }
}
package com.example.rusili.codechallengeexamples.presentation;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.RecyclerView;

import com.example.rusili.codechallengeexamples.R;
import com.example.rusili.codechallengeexamples.data.Food;
import com.example.rusili.codechallengeexamples.data.FoodService;
import com.example.rusili.codechallengeexamples.presentation.recyclerview.FoodListAdapter;

import java.util.List;

public class FoodListActivity extends AppCompatActivity implements FoodListContract.View {
    private RecyclerView foodRecyclerview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_list);

        foodRecyclerview = findViewById(R.id.food_rv);
        foodRecyclerview.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));

        FoodListPresenter presenter = new FoodListPresenter(this,
                new FoodService(getString(R.string.WW_Domain)),
                getResources());
        presenter.getFoodList();
    }

    @Override
    public void setRecyclerView(@Nullable List<Food> foodList) {
        FoodListAdapter adapter = new FoodListAdapter(foodList);
        foodRecyclerview.setAdapter(adapter);
    }

    @Override
    public void showSnackBar(@NonNull String message) {
        Snackbar.make(findViewById(android.R.id.content), message, Snackbar.LENGTH_SHORT).show();
    }
}
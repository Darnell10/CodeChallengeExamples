package com.example.rusili.codechallengeexamples.presentation.recyclerview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.rusili.codechallengeexamples.data.Food;
import com.example.rusili.codechallengeexamples.R;

import java.util.List;

public class FoodListAdapter extends RecyclerView.Adapter<FoodListViewHolder> {
    private List<Food> foodList;

    public FoodListAdapter(@Nullable List<Food> foodList) {
        this.foodList = foodList;
    }

    @NonNull
    @Override
    public FoodListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View viewHolder = LayoutInflater.from(parent.getContext()).inflate(R.layout.food_viewholder, parent, false);
        return new FoodListViewHolder(viewHolder);
    }

    @Override
    public void onBindViewHolder(@NonNull FoodListViewHolder holder, int position) {
        Food food = foodList.get(position);
        holder.bind(food);
    }

    @Override
    public int getItemCount() {
        return foodList.size();
    }
}

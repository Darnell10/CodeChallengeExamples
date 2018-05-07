package com.example.rusili.codechallengeexamples.presentation.recyclerview;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.rusili.codechallengeexamples.R;
import com.example.rusili.codechallengeexamples.data.Food;

import java.util.List;

/**
 * Separated the ViewHolder class. Notice how clean this class looks now.
 * No Android/context related code here.
 */
public class FoodListAdapter extends RecyclerView.Adapter<FoodListViewHolder> {
    private List<Food> foodList;

    /**
     * Once again, only passing in the list.
     */
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

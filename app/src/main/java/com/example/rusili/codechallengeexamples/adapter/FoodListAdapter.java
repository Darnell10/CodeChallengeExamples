package com.example.rusili.codechallengeexamples.adapter;

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
import com.example.rusili.codechallengeexamples.model.Food;
import com.example.rusili.codechallengeexamples.R;

import java.util.List;

public class FoodListAdapter extends RecyclerView.Adapter<FoodListAdapter.FoodListViewHolder> {
    private List<Food> foodList;
    private View viewHolder;

    public FoodListAdapter(@Nullable List<Food> foodList) {
        this.foodList = foodList;
    }

    @NonNull
    @Override
    public FoodListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        viewHolder = LayoutInflater.from(parent.getContext()).inflate(R.layout.food_viewholder, parent, false);
        return new FoodListViewHolder(viewHolder);
    }

    @Override
    public void onBindViewHolder(@NonNull FoodListViewHolder holder, int position) {
        Food food = foodList.get(position);
        holder.foodName.setText(food.getTitle());

        Context context = viewHolder.getContext();
        String imageUrl = context.getString(R.string.WW_Domain) + food.getImageEndpoint();
        RequestOptions options = createRequestOptions();
        Glide.with(context)
                .load(imageUrl)
                .apply(options)
                .into(holder.foodImage);
    }

    @NonNull
    private RequestOptions createRequestOptions() {
        return new RequestOptions()
                .centerCrop()
                .placeholder(R.drawable.ic_replay_black_24dp)
                .error(R.drawable.ic_error_outline_black_24dp);
    }

    @Override
    public int getItemCount() {
        return foodList.size();
    }

    class FoodListViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView foodName;
        private ImageView foodImage;

        private FoodListViewHolder(View view) {
            super(view);

            foodName = view.findViewById(R.id.food_name);
            foodImage = view.findViewById(R.id.food_image);
            foodImage.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            Snackbar.make(view, R.string.great_choice, Snackbar.LENGTH_SHORT).show();
        }
    }
}

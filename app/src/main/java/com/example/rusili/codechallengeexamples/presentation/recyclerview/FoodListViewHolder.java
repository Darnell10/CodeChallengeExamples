package com.example.rusili.codechallengeexamples.presentation.recyclerview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.rusili.codechallengeexamples.R;
import com.example.rusili.codechallengeexamples.data.Food;

class FoodListViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    private TextView foodName;
    private ImageView foodImage;

    FoodListViewHolder(@NonNull View view) {
        super(view);

        foodName = view.findViewById(R.id.food_name);
        foodImage = view.findViewById(R.id.food_image);
        foodImage.setOnClickListener(this);
    }

    void bind(@Nullable Food food) {
        foodName.setText(food.getTitle());

        Context context = itemView.getContext();
        String imageUrl = context.getString(R.string.WW_Domain) + food.getImageEndpoint();
        RequestOptions options = createRequestOptions();

        Glide.with(context)
                .load(imageUrl)
                .apply(options)
                .into(foodImage);
    }

    @NonNull
    private RequestOptions createRequestOptions() {
        return new RequestOptions()
                .centerCrop()
                .placeholder(R.drawable.ic_replay_black_24dp)
                .error(R.drawable.ic_error_outline_black_24dp);
    }

    @Override
    public void onClick(View view) {
        Snackbar.make(view, R.string.great_choice, Snackbar.LENGTH_SHORT).show();
    }
}
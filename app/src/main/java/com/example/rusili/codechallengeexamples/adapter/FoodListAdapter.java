package com.example.rusili.codechallengeexamples.adapter;

import android.content.Context;
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
import com.example.rusili.codechallengeexamples.util.JSONConstants;
import com.example.rusili.codechallengeexamples.R;

import java.util.ArrayList;
import java.util.List;

public class FoodListAdapter extends RecyclerView.Adapter<FoodListAdapter.FoodListViewHolder> {
    private List<Food> foodList = new ArrayList<>();
    private int foodListRow;
    private Context context;

    static class FoodListViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView foodTitle;
        private ImageView foodImage;

        private FoodListViewHolder(View v) {
            super(v);
            foodTitle = v.findViewById(R.id.foodTitle);
            foodImage = v.findViewById(R.id.foodImage);
            foodImage.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            Snackbar snackbar = Snackbar.make(view, R.string.great_choice, Snackbar.LENGTH_LONG);
            snackbar.show();
        }
    }

    public FoodListAdapter(List<Food> foodList, int foodListRow, Context context) {
        this.foodList = foodList;
        this.foodListRow = foodListRow;
        this.context = context;
    }

    @Override
    public FoodListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View foodView = LayoutInflater.from(parent.getContext()).inflate(foodListRow, parent, false);
        return new FoodListViewHolder(foodView);
    }

    @Override
    public void onBindViewHolder(FoodListViewHolder holder, int position) {
        Food foodObject = foodList.get(position);
        holder.foodTitle.setText(foodObject.getTitle());

        RequestOptions requestOptions = new RequestOptions()
                .error(R.mipmap.fork_knife)
                .placeholder(R.mipmap.fork_knife)
                .centerCrop();

        Glide.with(context)
                .load(JSONConstants.BASE_URL + foodObject.getImage())
                .apply(requestOptions)
                .into(holder.foodImage);
    }

    @Override
    public int getItemCount() {
        return foodList.size();
    }
}

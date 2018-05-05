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
    private List<Food> foodList = new ArrayList<>(); // Even the IDE says this is not needed.
    private int foodListRow; // No clue what this is. See comment below for more info.
    private Context context; // Should save context as little as possible.

    /**
     * No idea why this class is static.
     * Or why it's so up high.
     * Nested/Inner classes are supposed to be at the bottom of the outer class.
     */
    static class FoodListViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView foodTitle;
        private ImageView foodImage;

        private FoodListViewHolder(View v) {  // Nit: Personally don't like the name v. Would rather use "view".
            super(v);
            foodTitle = v.findViewById(R.id.foodTitle); // Once again, XML id should be food_title.
            foodImage = v.findViewById(R.id.foodImage);
            foodImage.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            Snackbar snackbar = Snackbar.make(view, R.string.great_choice, Snackbar.LENGTH_LONG); // Good job using String resources.
            snackbar.show(); // Could've inlined the .show().
        }
    }

    /**
     * The constructor should be at the top.
     * Also, when passing context, it should always be first. The order goes by importance/size
     * Also, try not to pass context into non-Android classes.
     */
    public FoodListAdapter(List<Food> foodList, int foodListRow, Context context) {
        this.foodList = foodList;
        this.foodListRow = foodListRow; // Don't know why she's passing in the viewholder xml. Please don't do that. Just set it in your onCreateViewHolder.
        this.context = context;
    }

    @Override
    public FoodListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View foodView = LayoutInflater.from(parent.getContext()).inflate(foodListRow, parent, false); // No need to put your layout in a variable.
        return new FoodListViewHolder(foodView); // This could be inlined.
    }

    @Override
    public void onBindViewHolder(FoodListViewHolder holder, int position) {
        Food foodObject = foodList.get(position);  // Not a fan of naming something Object. Everything in java is an object.
        holder.foodTitle.setText(foodObject.getTitle());

        RequestOptions requestOptions = new RequestOptions()
                .error(R.mipmap.fork_knife) // Good idea to have an error image, but it definitely shouldn't be the same as the placeholder one.
                .placeholder(R.mipmap.fork_knife) // Why have the image in both mipmap AND drawables? Also, it's 512x512. That's way too large for an icon.
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

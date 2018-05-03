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
    private int foodListRow;
    private Context context; // Should save context as little as possible.

    /**
     * No idea why this class is static.
     * Or why it's so up high.
     * Nested/Inner classes are supposed to be at the bottom of the outer class.
     */
    static class FoodListViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView foodTitle;
        private ImageView foodImage;

        private FoodListViewHolder(View v) {  // Personally don't like the name v. Would rather use "view".
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
     * Also, when passing context, it should always be first. The order goes by importance?/size?
     * Also, try not to pass context into non-Android classes.
     */
    public FoodListAdapter(List<Food> foodList, int foodListRow, Context context) {
        this.foodList = foodList;
        this.foodListRow = foodListRow;
        this.context = context;
    }

    @Override
    public FoodListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View foodView = LayoutInflater.from(parent.getContext()).inflate(foodListRow, parent, false);
        return new FoodListViewHolder(foodView); // This could be inlined as well.
    }

    @Override
    public void onBindViewHolder(FoodListViewHolder holder, int position) {
        Food foodObject = foodList.get(position);  // Not a fan of naming something Object. All of java are objects.
        holder.foodTitle.setText(foodObject.getTitle());

        // These options could've been chained with the Glide call.
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

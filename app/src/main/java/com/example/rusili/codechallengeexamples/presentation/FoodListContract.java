package com.example.rusili.codechallengeexamples.presentation;

import com.example.rusili.codechallengeexamples.data.Food;

import java.util.List;

/**
 * The contract is what defines how the presenter and View interact with each other.
 * So in this instance, the presenter can ONLY call 'setRecyclerView' and 'showSnackBar' from the View
 * and the View can only call 'getFoodList' from the presenter.
 */
public interface FoodListContract {

    interface View {
        void setRecyclerView(List<Food> foodList);

        void showSnackBar(String message);
    }

    interface Presenter {
        void getFoodList();
    }
}

package com.example.bakingrecipe;

import android.content.AsyncTaskLoader;
import android.content.Context;
import android.util.Log;

import java.util.List;

public class RecipeLoader extends AsyncTaskLoader<List<Recipes>> {

    // Tag for the log messages
    private static final String lTAG = RecipeLoader.class.getName();
    private static final String TAG = "Checks";
    private String mUrl;

    public RecipeLoader(Context context, String url) {
        super(context);
        mUrl = url;
    }

    @Override
    public List<Recipes> loadInBackground() {
        Log.i(TAG, "LOAD IN BACKGROUND RUNNING");
        if (mUrl == null) {
            return null;
        } else {
            List<Recipes> recipeList = NetworkUtilities.fetchBakingData(mUrl);
            Log.i(TAG, recipeList.toString());
            return recipeList;
        }
    }

    @Override
    protected void onStartLoading() {
        forceLoad();
    }


}

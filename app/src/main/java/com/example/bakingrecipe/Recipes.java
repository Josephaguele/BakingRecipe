package com.example.bakingrecipe;

import java.util.ArrayList;

public class Recipes {

    private int mid;
    private ArrayList<Ingredients> mIngredientsArrayList;
    private ArrayList<Steps> mStepsArrayList;
    private String mName;
    private String mServings;
    private String mImage;


    public Recipes(int id, ArrayList<Ingredients> ingredientsArrayList, ArrayList<Steps> stepsArrayList, String name, String servings, String image) {
        mid = id;
        mIngredientsArrayList = ingredientsArrayList;
        mStepsArrayList = stepsArrayList;
        mName = name;
        mServings = servings;
        mImage = image;
    }

    public int getMid(){
        return mid;
    }

    public String getmName(){
        return mName;
    }

    public ArrayList<Steps> getmStepsArrayList() {
        return mStepsArrayList;
    }

    public ArrayList<Ingredients>getmIngredientsArrayList(){
        return mIngredientsArrayList;
    }

    public String getmServings(){
        return mServings;
    }

    public String getmImage(){
        return mImage;
    }
}

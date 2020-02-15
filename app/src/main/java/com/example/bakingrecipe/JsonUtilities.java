package com.example.bakingrecipe;

import android.text.TextUtils;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import static com.example.bakingrecipe.NetworkUtilities.TAG;

public class JsonUtilities {

    // Fields of the RECIPES
    private static final String RECIPE_ID = "id";
    public static final String RECIPE_NAME = "name";
    private static final String SERVINGS = "servings";
    private static final String RECIPE_IMAGE = "image";
    private static final String INGREDIENTS = "ingredients";
    private static final String STEPS = "steps";

    // Fields of INGREDIENTS OF EACH RECIPE
    private static final String INGREDIENT_QUANTITY = "quantity";
    private static final String INGREDIENT_MEASURE = "measure";
    private static final String INGREDIENT_NAME = "ingredient";


    // Fields of STEPS OF EACH RECIPE
    private static final String _ID = "id";
    private static final String SHORT_DESC = "shortDescription";
    private static final String DESC = "description";
    private static final String VIDEO_URL = "videoURL";
    private static final String THUMBNAIL_URL = "thumbnailURL";

    /// empty constructor
    public JsonUtilities() {
    }

    public static ArrayList<Recipes> extractFeatureFromJson(String bakingRecipeJSON) {

        // If the JSON string is empty or null, then return early.
        if (TextUtils.isEmpty(bakingRecipeJSON)) {
            return null;
        }

        ArrayList<Recipes> recipes = new ArrayList<>();
        try {
            // Create a JSONArray from the JSON response string
            JSONArray recipeJSON = new JSONArray(bakingRecipeJSON);
            // Try to parse the JSON response string. If there is a problem with the way the JSON
            // is formatted, a JSONException exception object will be thrown.
            // Catch the exception so the app doesn't crash, and print the error message to the logs.
            for (int i = 0; i < recipeJSON.length(); i++) {
                // Get a single recipe at position i within the list of recipes provided in the arra
                JSONObject currentRecipe = recipeJSON.optJSONObject(i);

                // Extract values for the following keys in the json provided
                // These are the first top level of the json parsing
                int recipeId = currentRecipe.optInt(RECIPE_ID);
                String recipeName = currentRecipe.optString(RECIPE_NAME);
                String servings = currentRecipe.optString(SERVINGS);
                String recipeImage = currentRecipe.optString(RECIPE_IMAGE);


                ArrayList<Ingredients> ingredients = new ArrayList<>();
                JSONArray ingredientJson = currentRecipe.optJSONArray(INGREDIENTS);

                for (int j = 0; j < ingredientJson.length(); j++) {
                    // This gets a single ingredient at position j within the list of recipes provided
                    JSONObject thisIngredient = ingredientJson.optJSONObject(j);

                    // Then extract the values for the following keys
                    String ingredientName = thisIngredient.optString(INGREDIENT_NAME);
                    String ingredientMeasure = thisIngredient.optString(INGREDIENT_MEASURE);
                    int ingredientQuantity = thisIngredient.optInt(INGREDIENT_QUANTITY);

                    Ingredients ing = new Ingredients(ingredientQuantity, ingredientMeasure, ingredientName);
                    ingredients.add(ing);
                }

                ArrayList<Steps> stepsList = new ArrayList<>();
                JSONArray stepsJson = currentRecipe.optJSONArray(STEPS);

                for (int s = 0; s < stepsJson.length(); s++) {
                    // This gets a single step at position c within the list of recipes provided
                    JSONObject thisStep = stepsJson.optJSONObject(s);

                    // Then extract the values for the following keys
                    int stepId = thisStep.optInt(_ID);
                    String stepLongDesc = thisStep.optString(DESC);
                    String stepShortDesc = thisStep.optString(SHORT_DESC);
                    String videoUrl = thisStep.optString(VIDEO_URL);
                    String thumbnailURL = thisStep.optString(THUMBNAIL_URL);

                    Steps step = new Steps(stepId, stepShortDesc, stepLongDesc, videoUrl, thumbnailURL);
                    stepsList.add(step);
                }

                Recipes recipe = new Recipes(recipeId, ingredients, stepsList, recipeName, servings, recipeImage);
                recipes.add(recipe);
                Log.i(TAG, recipes.toString());

            }
        } catch (JSONException e) {
            Log.e("QueryUtils", "Problem parsing the JSON result", e);

        }
        return recipes;

}}
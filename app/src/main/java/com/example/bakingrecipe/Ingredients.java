package com.example.bakingrecipe;

class Ingredients {
    private int quantity;
    private String measure;
    private String ingredients;


    public Ingredients( int quan, String meas, String ing){
        quantity = quan;
        measure = meas;
        ingredients = ing;
    }

    public int getQuantity(){
        return quantity;
    }

    public String getMeasure(){
        return measure;
    }

    public String getIngredients(){
        return ingredients;
    }
}

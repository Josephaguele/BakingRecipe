package com.example.bakingrecipe;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RecipeRecyclerViewAdapter extends RecyclerView.Adapter<
        RecipeRecyclerViewAdapter.ViewHolder> {

    private final List<Recipes> mBakingRecipes;

    public RecipeRecyclerViewAdapter(List<Recipes> bakingRecipes) {
        mBakingRecipes = bakingRecipes;
    }

    @NonNull
    @Override
    public RecipeRecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_recipes,
                        parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Recipes bakingRecipes = mBakingRecipes.get(position);
        holder.servings.setText(bakingRecipes.getmServings());
        holder.id.setText(bakingRecipes.getMid());
        holder.name.setText(bakingRecipes.getmName());
    }

    @Override
    public int getItemCount() {
        return mBakingRecipes.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        public final TextView servings;
        public final TextView name;
        public final TextView id;

        public ViewHolder(View view){
            super(view);
            servings =(TextView) view.findViewById(R.id.servings);
            name = (TextView)view.findViewById(R.id.name);
            id = (TextView)view.findViewById(R.id.id);
        }

        @Override
        public String toString() {
            return super.toString() + "' "+ name.getText()+ "'";
        }
    }
}

package com.example.bakingrecipe;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.Loader;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.net.Uri;
import android.os.Bundle;

import java.util.List;

import static com.example.bakingrecipe.NetworkUtilities.BASEURL;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private LinearLayoutManager layoutManager;
    private RecipeRecyclerViewAdapter mRecipeAdapter;

    RecipeListFragment mRecipeListFragment;
    private static final String TAG_LIST_FRAGMENT = "TAG_LIST_FRAGMENT";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_main);

        FragmentManager fm = getSupportFragmentManager();

        if(savedInstanceState == null){
            FragmentTransaction ft = fm.beginTransaction();
            mRecipeListFragment = new RecipeListFragment();

            ft.add(R.id.main_activity_frame, mRecipeListFragment,TAG_LIST_FRAGMENT);
            ft.commitNow();
        } else{
            mRecipeListFragment =
                    (RecipeListFragment)fm.findFragmentByTag(TAG_LIST_FRAGMENT);
        }




    }



}

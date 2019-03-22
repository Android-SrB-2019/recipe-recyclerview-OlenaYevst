package com.example.olena.recipe;


//This assignment was done by Olena
//Date: 2019-03-21

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.io.Serializable;
import java.util.LinkedList;

public class RecipeListAdapter extends RecyclerView.Adapter<RecipeListAdapter.RecipeViewHolder>  {


    class RecipeViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, Serializable{
        public final TextView nameView;
        public final TextView briefDescView;
        final RecipeListAdapter mAdapter;

        public RecipeViewHolder(View itemView, RecipeListAdapter adapter) {
            super(itemView);
            itemView.setOnClickListener(this);
            nameView = itemView.findViewById(R.id.name);
            briefDescView = itemView.findViewById(R.id.briefDesc);
            this.mAdapter = adapter;
        }

        @Override
        public void onClick(View view) {
            // Get the position of the item that was clicked.
            int mPosition = getLayoutPosition();

            // Use that to access the affected item in mWordList.
            Recipe r = mRecipeList.get(mPosition);

            // Notify the adapter, that the data has changed so it can
            // update the RecyclerView to display the data.
            mAdapter.notifyDataSetChanged();

            itemView.setOnClickListener(this);


            Intent intent = new Intent(view.getContext(),recipeIntent.class);
            intent.putExtra("RECIEPE", (Serializable) r);
            view.getContext().startActivity(intent);
        }
    }

    private final LinkedList<Recipe> mRecipeList;
    private LayoutInflater mInflater;


    public RecipeListAdapter(Context context,
                           LinkedList<Recipe> recipeList) {
        mInflater = LayoutInflater.from(context);
        this.mRecipeList = recipeList;
    }

    @NonNull
    @Override
    public RecipeListAdapter.RecipeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View mItemView = mInflater.inflate(R.layout.recipe_item,
                parent, false);
        return new RecipeViewHolder(mItemView, this);
    }

    @Override
    public void onBindViewHolder(RecipeViewHolder holder, int position) {
        Recipe mCurrent = mRecipeList.get(position);
        holder.nameView.setText(mCurrent.name);
        holder.briefDescView.setText(mCurrent.description);
    }

    @Override
    public int getItemCount() {
        return mRecipeList.size();
    }
}

package com.example.submission_4.adapter;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MoviesFavAdapter extends RecyclerView.Adapter<MoviesFavAdapter.MoviesFavViewHolder>  {
    @NonNull
    @Override
    public MoviesFavViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull MoviesFavViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class MoviesFavViewHolder extends RecyclerView.ViewHolder {
        public MoviesFavViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}

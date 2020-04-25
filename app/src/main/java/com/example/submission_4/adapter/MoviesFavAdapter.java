package com.example.submission_4.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.submission_4.model.Movie;
import com.example.submission_4.R;

import java.util.ArrayList;

public class MoviesFavAdapter extends RecyclerView.Adapter<MoviesFavAdapter.MoviesFavViewHolder>  {
    private ArrayList<Movie> movieFavArrayList;
    private Context context;
    private String title , desc, photo;

    public MoviesFavAdapter(ArrayList<Movie> list){
        this.movieFavArrayList = list;
    }

    @NonNull
    @Override
    public MoviesFavViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, parent, false);
        return new MoviesFavViewHolder(view);
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

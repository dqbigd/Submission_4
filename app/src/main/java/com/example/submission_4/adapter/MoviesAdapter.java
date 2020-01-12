package com.example.submission_4.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.submission_4.MoviesResult;
import com.example.submission_4.R;
import com.example.submission_4.activity.DetailMovieActivity;

import java.util.ArrayList;

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.MoviesViewHolder>{
    private ArrayList<MoviesResult> moviesResults = new ArrayList<>();
    private Context context ;

    public void setData(ArrayList<MoviesResult> items) {
        moviesResults.clear();
        moviesResults.addAll(items);
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public MoviesAdapter.MoviesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, parent, false);
        return new MoviesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final MoviesViewHolder holder, final int position) {
        holder.bind(moviesResults.get(position));

    }

    @Override
    public int getItemCount() {
        return moviesResults.size();
    }

    public class MoviesViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        ImageView imgPhoto;
        TextView txtTitle, txtDesc;

        public MoviesViewHolder(@NonNull View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.imgPhoto);
            txtTitle = itemView.findViewById(R.id.txtJudul);
            txtDesc = itemView.findViewById(R.id.txtDesc);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {

            Intent intentDetail = new Intent(view.getContext(), DetailMovieActivity.class);

             intentDetail.putExtra(DetailMovieActivity.EXTRA_MOVIE, moviesResults.get(getAdapterPosition()));
            view.getContext().startActivity(intentDetail);

        }

        void bind(MoviesResult moviesResult){
            txtTitle.setText(moviesResult.getTitle());
            txtDesc.setText(moviesResult.getOverview());
            Glide.with(itemView.getContext()).load("https://image.tmdb.org/t/p/w185"+moviesResult.getPosterPath()).into(imgPhoto);
        }

    }

}

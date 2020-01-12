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
import com.example.submission_4.R;
import com.example.submission_4.TvResult;
import com.example.submission_4.activity.DetailTvActivity;

import java.util.ArrayList;

public class TvAdapter extends RecyclerView.Adapter<TvAdapter.TvViewHolder> {
    private ArrayList<TvResult> tvsResults = new ArrayList<>();
    private Context context ;

    public void setData(ArrayList<TvResult> items) {
        tvsResults.clear();
        tvsResults.addAll(items);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public TvViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, parent, false);
        return new TvViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TvViewHolder holder, int position) {
        holder.bind(tvsResults.get(position));
    }

    @Override
    public int getItemCount() {
        return tvsResults.size();
    }

    public class TvViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        ImageView imgPhoto;
        TextView txtTitle, txtDesc;

        public TvViewHolder(@NonNull View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.imgPhoto);
            txtTitle = itemView.findViewById(R.id.txtJudul);
            txtDesc = itemView.findViewById(R.id.txtDesc);

            itemView.setOnClickListener(this);
        }

        public void bind(TvResult tvResult) {
            txtTitle.setText(tvResult.getTitle());
            txtDesc.setText(tvResult.getOverview());
            Glide.with(itemView.getContext()).load("https://image.tmdb.org/t/p/w185"+tvResult.getPosterPath()).into(imgPhoto);
        }

        @Override
        public void onClick(View view) {
            Intent intentDetail = new Intent(view.getContext(), DetailTvActivity.class);

            intentDetail.putExtra(DetailTvActivity.EXTRA_TV, tvsResults.get(getAdapterPosition()));
            view.getContext().startActivity(intentDetail);
        }
    }
}

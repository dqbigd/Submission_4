package com.example.submission_4.activity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.example.submission_4.MoviesResult;
import com.example.submission_4.R;

public class DetailMovieActivity extends AppCompatActivity {

    public static final String EXTRA_MOVIE = "extra_movie";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_movie);

        TextView txtJudul, txtDesc;
        ImageView imgPhoto = findViewById(R.id.imgPhoto);
        txtJudul = findViewById(R.id.txtJudul);
        txtDesc = findViewById(R.id.txtDesc);

        MoviesResult moviesResult = getIntent().getParcelableExtra(EXTRA_MOVIE);
        txtJudul.setText(moviesResult.getTitle());
        txtDesc.setText(moviesResult.getOverview());
        Glide.with(this).load("https://image.tmdb.org/t/p/w185"+moviesResult.getPosterPath()).into(imgPhoto);
    }
}

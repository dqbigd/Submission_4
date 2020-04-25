package com.example.submission_4.activity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.example.submission_4.R;
import com.example.submission_4.model.Tv;

public class DetailTvActivity extends AppCompatActivity {
    public static final String EXTRA_TV = "extra_tv";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_tv);

        TextView txtJudul, txtDesc;
        ImageView imgPhoto = findViewById(R.id.imgPhoto);
        txtJudul = findViewById(R.id.txtJudul);
        txtDesc = findViewById(R.id.txtDesc);

        Tv tvsResult = getIntent().getParcelableExtra(EXTRA_TV);
        txtJudul.setText(tvsResult.getTitle());
        txtDesc.setText(tvsResult.getOverview());
        Glide.with(this).load("https://image.tmdb.org/t/p/w185"+tvsResult.getPosterPath()).into(imgPhoto);
    }
}

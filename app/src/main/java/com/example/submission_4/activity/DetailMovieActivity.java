package com.example.submission_4.activity;

import android.database.sqlite.SQLiteConstraintException;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.favorite_menu, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                break;
            case R.id.fav_btn:
                try {
                    //markAsFavorite();
                    setFavoriteSelected(item);
                    Toast.makeText(this, R.string.add_fav_success, Toast.LENGTH_SHORT).show();
                } catch (SQLiteConstraintException e) {
                    Toast.makeText(this, e.getLocalizedMessage(), Toast.LENGTH_LONG).show();
                }
        }
        return true;
    }

    private void setFavoriteSelected(MenuItem item) {
        item.setIcon(R.drawable.ic_favorite_white_full_24dp);
        item.setEnabled(false);
    }

//    private void markAsFavorite() {
//        movieDAO.insert(movie);
//    }
}

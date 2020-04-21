package com.example.submission_4.activity;

import android.content.ContentValues;
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
import com.example.submission_4.db.DatabaseContract;
import com.example.submission_4.db.MoviesHelper;

public class DetailMovieActivity extends AppCompatActivity {

    public static final String EXTRA_MOVIE = "extra_movie";
    private TextView txtJudul, txtDesc;
    private MoviesHelper moviesHelper;
    private String title, desc, photo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_movie);

        ImageView imgPhoto = findViewById(R.id.imgPhoto);
        txtJudul = findViewById(R.id.txtJudul);
        txtDesc = findViewById(R.id.txtDesc);

        moviesHelper = MoviesHelper.getInstance(getApplicationContext());
        moviesHelper.open();

        MoviesResult moviesResult = getIntent().getParcelableExtra(EXTRA_MOVIE);

        title = moviesResult.getTitle();
        desc = moviesResult.getOverview();
        photo = "https://image.tmdb.org/t/p/w185"+moviesResult.getPosterPath();

        txtJudul.setText(title);
        txtDesc.setText(desc);
        Glide.with(this).load(photo).into(imgPhoto);
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
                    addFavorite();
                    setFavoriteSelected(item);
                    Toast.makeText(this, R.string.add_fav_success, Toast.LENGTH_SHORT).show();
                } catch (SQLiteConstraintException e) {
                    Toast.makeText(this, e.getLocalizedMessage(), Toast.LENGTH_LONG).show();
                }
        }
        return true;
    }

    private void addFavorite() {
        ContentValues cv = new ContentValues();
        cv.put(DatabaseContract.MovieFavColumns.TITLE, title);
        cv.put(DatabaseContract.MovieFavColumns.DESCRIPTION, desc);
        cv.put(DatabaseContract.MovieFavColumns.PHOTO, photo);

        long result = moviesHelper.insert(cv);
        Toast.makeText(this, String.valueOf(result), Toast.LENGTH_SHORT).show();

    }

    private void setFavoriteSelected(MenuItem item) {
        item.setIcon(R.drawable.ic_favorite_white_full_24dp);
        item.setEnabled(false);
    }

}

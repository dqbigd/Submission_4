package com.example.submission_4.fragment;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.submission_4.R;
import com.example.submission_4.adapter.MoviesFavAdapter;


/**
 * A simple {@link Fragment} subclass.
 */
public class FavoriteMoviesFragment extends Fragment {

    private RecyclerView rvMovieFav;
    private ProgressBar pbMovieFav;
    private MoviesFavAdapter moviesFavAdapter;

    public FavoriteMoviesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_favorite_movies, container, false);

        pbMovieFav = view.findViewById(R.id.pbMoviesFav);
        rvMovieFav = view.findViewById(R.id.rvMovieFav);
        rvMovieFav.setLayoutManager(new LinearLayoutManager(getActivity()));
        rvMovieFav.setHasFixedSize(true);
        moviesFavAdapter = new MoviesFavAdapter();
        rvMovieFav.setAdapter(moviesFavAdapter);

        return view;
    }

}

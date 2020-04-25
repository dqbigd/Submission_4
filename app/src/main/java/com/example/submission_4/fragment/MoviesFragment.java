package com.example.submission_4.fragment;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.submission_4.MainViewModel;
import com.example.submission_4.model.Movie;
import com.example.submission_4.R;
import com.example.submission_4.adapter.MoviesAdapter;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class MoviesFragment extends Fragment {
    private RecyclerView rvMovie;
    private ProgressBar pbMovie;
    private MoviesAdapter moviesAdapter;

    private MainViewModel mainViewModel;

    public MoviesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_movies, container, false);

        rvMovie = view.findViewById(R.id.rvMovie);
        pbMovie = view.findViewById(R.id.pbMovies);

        rvMovie.setLayoutManager(new LinearLayoutManager(getActivity(), RecyclerView.VERTICAL, view.isInLayout()));
        moviesAdapter =new MoviesAdapter();
        moviesAdapter.notifyDataSetChanged();
        rvMovie.setAdapter(moviesAdapter);

        mainViewModel = new ViewModelProvider(this, new ViewModelProvider.NewInstanceFactory()).get(MainViewModel.class);
        mainViewModel.setMovies();
        mainViewModel.getMovies().observe(this, new Observer<ArrayList<Movie>>() {
            @Override
            public void onChanged(ArrayList<Movie> movies) {
                if (movies != null) {
                    moviesAdapter.setData(movies);
                    pbMovie.setVisibility(View.GONE);
                }
            }
        });
        pbMovie.setVisibility(View.VISIBLE);
        return view;
    }


}

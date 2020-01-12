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
import com.example.submission_4.R;
import com.example.submission_4.TvResult;
import com.example.submission_4.adapter.TvAdapter;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class TVshowFragment extends Fragment {
    private RecyclerView rvTv;
    private ProgressBar pbTv;
    private TvAdapter tvAdapter;

    private MainViewModel mainViewModel;

    public TVshowFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tvshow, container, false);

        rvTv = view.findViewById(R.id.rvTv);
        pbTv = view.findViewById(R.id.pbTv);

        rvTv.setLayoutManager(new LinearLayoutManager(getActivity(), RecyclerView.VERTICAL, view.isInLayout()));
        tvAdapter =new TvAdapter();
        tvAdapter.notifyDataSetChanged();
        rvTv.setAdapter(tvAdapter);

        mainViewModel = new ViewModelProvider(this, new ViewModelProvider.NewInstanceFactory()).get(MainViewModel.class);
        mainViewModel.setTv();
        mainViewModel.getTv().observe(this, new Observer<ArrayList<TvResult>>() {
            @Override
            public void onChanged(ArrayList<TvResult> tvsResults) {
                if (tvsResults != null) {
                    tvAdapter.setData(tvsResults);
                    pbTv.setVisibility(View.GONE);
                }
            }
        });
        pbTv.setVisibility(View.VISIBLE);
        return view;
    }

}

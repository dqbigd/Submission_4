package com.example.submission_4.adapter;

import android.content.Context;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.submission_4.R;
import com.example.submission_4.fragment.FavoriteMoviesFragment;
import com.example.submission_4.fragment.FavoriteTVshowFragment;
import com.example.submission_4.fragment.MoviesFragment;
import com.example.submission_4.fragment.TVshowFragment;

public class MainPagerAdapter extends FragmentPagerAdapter {
    private final Context mContext;

    public MainPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0:
                return mContext.getResources().getString(R.string.tab_movies);
            case 1:
                return mContext.getResources().getString(R.string.tab_tv);
            case 2:
                return mContext.getResources().getString(R.string.tab_fav_movies);
            case 3:
                return mContext.getResources().getString(R.string.tab_fav_tv);
        }
        return null;
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        switch (position){
            case 0:
                fragment = new MoviesFragment();
                break;
            case 1:
                fragment = new TVshowFragment();
                break;
            case 2:
                fragment = new FavoriteMoviesFragment();
                break;
            case 3:
                fragment = new FavoriteTVshowFragment();
                break;

        }
        return fragment;
    }

    @Override
    public int getCount() {
        return 4;
    }
}

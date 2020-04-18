package com.example.submission_4;

import android.os.Parcel;
import android.os.Parcelable;

public class TvFav implements Parcelable {
    private String posterPath;
    private String title;
    private String overview;

    protected TvFav(Parcel in) {
        posterPath = in.readString();
        title = in.readString();
        overview = in.readString();
    }

    public static final Creator<TvFav> CREATOR = new Creator<TvFav>() {
        @Override
        public TvFav createFromParcel(Parcel in) {
            return new TvFav(in);
        }

        @Override
        public TvFav[] newArray(int size) {
            return new TvFav[size];
        }
    };

    public String getPosterPath() {
        return posterPath;
    }

    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(posterPath);
        parcel.writeString(title);
        parcel.writeString(overview);
    }
}

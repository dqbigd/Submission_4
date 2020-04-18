package com.example.submission_4;

import android.os.Parcel;
import android.os.Parcelable;

public class MoviesFav implements Parcelable {
    private int id;
    private String title;
    private String overview;
    private String posterPath;

    public MoviesFav(int id, String title, String overview, String posterPath) {
        this.id = id;
        this.title = title;
        this.overview = overview;
        this.posterPath = posterPath;
    }

    protected MoviesFav(Parcel in) {
        id = in.readInt();
        title = in.readString();
        overview = in.readString();
        posterPath = in.readString();
    }

    public static final Creator<MoviesFav> CREATOR = new Creator<MoviesFav>() {
        @Override
        public MoviesFav createFromParcel(Parcel in) {
            return new MoviesFav(in);
        }

        @Override
        public MoviesFav[] newArray(int size) {
            return new MoviesFav[size];
        }
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getPosterPath() {
        return posterPath;
    }

    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(id);
        parcel.writeString(title);
        parcel.writeString(overview);
        parcel.writeString(posterPath);
    }
}

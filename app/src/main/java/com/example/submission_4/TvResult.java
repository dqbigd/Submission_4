package com.example.submission_4;

import android.os.Parcel;
import android.os.Parcelable;

public class TvResult implements Parcelable {
    private String posterPath;
    private Integer id;
    private String title;
    private String overview;

    public TvResult(){

    }

    protected TvResult(Parcel in) {
        posterPath = in.readString();
        if (in.readByte() == 0) {
            id = null;
        } else {
            id = in.readInt();
        }
        title = in.readString();
        overview = in.readString();
    }

    public static final Creator<TvResult> CREATOR = new Creator<TvResult>() {
        @Override
        public TvResult createFromParcel(Parcel in) {
            return new TvResult(in);
        }

        @Override
        public TvResult[] newArray(int size) {
            return new TvResult[size];
        }
    };

    public String getPosterPath() {
        return posterPath;
    }

    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(posterPath);
        if (id == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeInt(id);
        }
        parcel.writeString(title);
        parcel.writeString(overview);
    }
}

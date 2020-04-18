package com.example.submission_4.db;

import android.provider.BaseColumns;

public class DatabaseContract {
    public static final class MovieFavColumns implements BaseColumns{
        public static final String TABLE_NAME = "moviefav";

        public static final String TITLE = "title";
        public static final String DESCRIPTION = "description";
        public static final String PHOTO = "photo";
    }

    public static final class TvFavColumns implements BaseColumns{
        public static final String TABLE_NAME = "tvfav";

        public static final String TITLE = "title";
        public static final String DESCRIPTION = "description";
        public static final String PHOTO = "photo";
    }
}

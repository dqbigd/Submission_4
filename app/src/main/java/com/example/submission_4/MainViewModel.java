package com.example.submission_4;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;

public class MainViewModel extends ViewModel {
    private static final String API_KEY = "3d99bbc2deabf611d45e30918d521114";
    private MutableLiveData<ArrayList<MoviesResult>> listMovies = new MutableLiveData<>();
    private MutableLiveData<ArrayList<TvResult>> listTv = new MutableLiveData<>();

    public void setMovies(){
        AsyncHttpClient client = new AsyncHttpClient();
        final ArrayList<MoviesResult> listItems = new ArrayList<>();
        String url = "https://api.themoviedb.org/3/discover/movie?api_key="+API_KEY+"&language=en-US";

        client.get(url, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                try {
                    String result = new String(responseBody);
                    JSONObject responseObject = new JSONObject(result);
                    JSONArray result1 = responseObject.getJSONArray("results");

                    for (int i = 0; i < result1.length(); i++) {
                        JSONObject resultMo = result1.getJSONObject(i);
                        MoviesResult moviesResult = new MoviesResult();
                        moviesResult.setTitle(resultMo.getString("title"));
                        moviesResult.setOverview(resultMo.getString("overview"));
                        moviesResult.setPosterPath(resultMo.getString("poster_path"));
                        listItems.add(moviesResult);
                    }
                    listMovies.postValue(listItems);
                } catch (Exception e) {
                    Log.d("Exception", e.getMessage());
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                Log.d("onFailure", error.getMessage());
            }
        });

    }

    public LiveData<ArrayList<MoviesResult>> getMovies() {
        return listMovies;
    }

    public void setTv(){
        AsyncHttpClient client = new AsyncHttpClient();
        final ArrayList<TvResult> listItems = new ArrayList<>();
        String url = "https://api.themoviedb.org/3/discover/tv?api_key="+API_KEY+"&language=en-US";

        client.get(url, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                try {
                    String result = new String(responseBody);
                    JSONObject responseObject = new JSONObject(result);
                    JSONArray result1 = responseObject.getJSONArray("results");

                    for (int i = 0; i < result1.length(); i++) {
                        JSONObject resultTv = result1.getJSONObject(i);
                        TvResult tvResult = new TvResult();
                        tvResult.setTitle(resultTv.getString("name"));
                        tvResult.setOverview(resultTv.getString("overview"));
                        tvResult.setPosterPath(resultTv.getString("poster_path"));
                        listItems.add(tvResult);
                    }
                    listTv.postValue(listItems);
                } catch (Exception e) {
                    Log.d("Exception", e.getMessage());
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                Log.d("onFailure", error.getMessage());
            }
        });

    }

    public LiveData<ArrayList<TvResult>> getTv() {
        return listTv;
    }
}

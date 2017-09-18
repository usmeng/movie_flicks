package com.meng.flicks.data;

import com.meng.flicks.data.response.MovieDetailResponse;
import com.meng.flicks.data.response.MovieListResponse;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by mengzhou on 7/5/17.
 */

public interface RestAPI {

    String apiKey = "93084ce1f144ab7bf7f4e11fcb43afec";
    String sampleAPI = "now_playing?api_key=" + apiKey;
    String trailerAPI = "{id}/videos?api_key=" + apiKey;
    String BASE_URL = "https://api.themoviedb.org/3/movie/";

    @GET(sampleAPI)
    Observable<MovieListResponse> fetchMovieList();

    @GET(trailerAPI)
    Observable<MovieDetailResponse> fetchMovieDetail(@Path("id") String url);
}
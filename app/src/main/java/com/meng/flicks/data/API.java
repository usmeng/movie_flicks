package com.meng.flicks.data;

/**
 * Created by mengzhou on 7/4/17.
 */

public class API {

    private String apiKey = "93084ce1f144ab7bf7f4e11fcb43afec";
    private String sampleAPI = "now_playing?api_key=" + apiKey;
    private String trailerAPI = "/videos?api_key=" + apiKey;
    private String BASE_URL = "https://api.themoviedb.org/3/movie/";
    private String IMAGE_URL = "https://image.tmdb.org/t/p/w500/";

    public String getSampleURL() {
        return BASE_URL + sampleAPI;
    }

    public String getTrailerAPI(String id) {
        return BASE_URL + id + trailerAPI;
    }

    public String imageUrl(String url) {
        return IMAGE_URL + url;
    }
}
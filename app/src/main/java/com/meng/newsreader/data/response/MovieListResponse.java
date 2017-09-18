package com.meng.newsreader.data.response;

import com.meng.newsreader.presentation.beans.MoveResponse;

import java.util.List;

/**
 * Created by mengzhou on 7/4/17.
 */

public class MovieListResponse {
    public List<MoveResponse> results;
    public int     page;
    public int     total_results;
    public Dates   dates;
    public int     total_pages;
    public String status;
    public String copyright;

    public class Dates {
        String maximum;
        String minimum;
    }

}

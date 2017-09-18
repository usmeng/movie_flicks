package com.meng.flicks.presentation.views;

import com.meng.flicks.presentation.beans.MoveResponse;

import java.util.List;

/**
 * Created by mengzhou on 7/6/17.
 */

public interface IMainView {

    void showMovieList(List<MoveResponse> moveResponses);

    void showMovie(int movieId);
}

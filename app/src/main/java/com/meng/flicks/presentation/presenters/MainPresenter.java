package com.meng.flicks.presentation.presenters;

import com.meng.flicks.data.ApiRetrofit;
import com.meng.flicks.presentation.views.IMainView;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by mengzhou on 7/7/17.
 */
public class MainPresenter {

    private IMainView iMainView;

    public MainPresenter(IMainView iMainView) {
        this.iMainView = iMainView;
    }

    public void showArticles(String keyword) {
        ApiRetrofit.getInstance().fetchMovieList(keyword)
            .subscribeOn(Schedulers.io())
            .map(response -> response.results)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(movies -> iMainView.showMovieList(movies));
    }

    public void showArticle(int id) {
        iMainView.showMovie(id);
    }
}
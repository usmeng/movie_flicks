package com.meng.flicks.presentation;

import android.Manifest;
import android.app.FragmentManager;
import android.content.res.Configuration;
import android.os.Bundle;

import com.meng.flicks.presentation.base.BaseActivity;
import com.meng.flicks.presentation.beans.MoveResponse;
import com.meng.flicks.presentation.presenters.MainPresenter;
import com.meng.flicks.presentation.views.IMainView;
import com.meng.flicks.presentation.views.fragments.MovieListFragment;
import com.meng.flicks.presentation.views.fragments.MovieTrailerFragment;
import com.meng.flicks.R;

import java.util.List;

public class MainActivity extends BaseActivity implements
        IMainView, MovieListFragment.MovieListCallback {

    public static final String TAG = MainActivity.class.getSimpleName();
    FragmentManager fragmentManager;
    MovieListFragment articleListFragment;
    MainPresenter mainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        mainPresenter = new MainPresenter(this);
        fragmentManager = getFragmentManager();

        requestPermission(Manifest.permission.INTERNET).subscribe(integer -> {
            if (savedInstanceState == null) {
                articleListFragment = new MovieListFragment();
                fragmentManager.beginTransaction()
                        .add(R.id.article_fragment, articleListFragment, MovieListFragment.TAG)
                        .commit();
            }
        });
    }

    @Override
    public void onFetchMovieList(String keyword) {
        mainPresenter.showArticles(keyword);
    }

    @Override
    public void showMovieList(List<MoveResponse> moveResponses) {
        MovieListFragment listFragment = (MovieListFragment) fragmentManager.findFragmentByTag(MovieListFragment.TAG);
        if (listFragment == null) return;
        listFragment.loadData(moveResponses);
    }

    @Override
    public void onMovieItemClick(int article) {
        MovieTrailerFragment articleDetailFragment = MovieTrailerFragment.newInstance(article);
        fragmentManager.beginTransaction()
                .add(R.id.article_fragment, articleDetailFragment, MovieTrailerFragment.TAG)
                .addToBackStack("").hide(articleListFragment).commit();
    }

    @Override
    public void showMovie(int movieId) {
        mainPresenter.showArticle(movieId);
    }
}

package com.meng.flicks.presentation.views.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.meng.flicks.data.API;
import com.meng.flicks.presentation.beans.MoveResponse;
import com.meng.flicks.R;


public class MovieTrailerFragment extends Fragment {
    public static final String TAG = MovieTrailerFragment.class.getSimpleName();
    private static final String ARTICLE_ID = "article_id";

    private TextView mTitle;
    private TextView mSummary;
    private ImageView mCover;

    public static MovieTrailerFragment newInstance(int article) {
        MovieTrailerFragment fragment = new MovieTrailerFragment();
        Bundle args = new Bundle();
        args.putInt(ARTICLE_ID, article);
        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.i(TAG, "MovieTrailerFragment onCreateView method called");
        return inflater.inflate(R.layout.fragment_movie_detail, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        Log.i(TAG, "MovieTrailerFragment onViewCreated method called");
        super.onViewCreated(view, savedInstanceState);
        mCover = view.findViewById(R.id.img_cover);
        mTitle = view.findViewById(R.id.tv_title);
        mSummary = view.findViewById(R.id.tv_summary);

        if(getArguments() != null) {
            int mArticleId = getArguments().getInt(ARTICLE_ID);
            updateArticle(mArticleId);
        }
    }


    private void updateArticle(final int articleId) {
        MovieListFragment articleListFragment = (MovieListFragment)
                getActivity().getFragmentManager().findFragmentByTag(MovieListFragment.TAG);
        final MoveResponse moveResponse = articleListFragment.getData().get(articleId);
        if(moveResponse == null) return;

        mTitle.setText(moveResponse.title);
        mSummary.setText(moveResponse.overview);
        String url = new API().imageUrl(moveResponse.backdrop_path);
        Glide.with(getActivity()).load(url).into(mCover);
    }

}
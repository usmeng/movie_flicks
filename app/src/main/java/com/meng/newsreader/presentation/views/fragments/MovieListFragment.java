package com.meng.newsreader.presentation.views.fragments;


import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.meng.newsreader.R;
import com.meng.newsreader.presentation.beans.MoveResponse;

import java.util.List;

/**
 * Created by mengzhou on 7/3/17.
 */
public class MovieListFragment extends Fragment {

    public static final String TAG = MovieListFragment.class.getSimpleName();
    private MovieListCallback movieListCallback;
    private RecyclerView mRecyclerView;
    private MovieListAdapter mMovieListAdapter;
    private List<MoveResponse> mData;
    private EditText mEditText;
    private Button mSearchButton;

    public interface MovieListCallback {
         void onFetchMovieList(String keyword);
         void onMovieItemClick(int id);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if(context instanceof MovieListCallback) {
            movieListCallback = (MovieListCallback) context;
        } else {
            throw new RuntimeException(context.toString() + " must implement MovieListCallback");
        }
    }

    @Nullable @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        Log.i(TAG, "MovieListFragment onCreateView() method called");
        return inflater.inflate(R.layout.fragment_movie_list, null);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        Log.i(TAG, "MovieListFragment onViewCreated() method called");

        mRecyclerView = view.findViewById(R.id.movie_recycleview);
        mEditText = view.findViewById(R.id.search_hint);
        mSearchButton = view.findViewById(R.id.search_button);
        /*mSearchButton.setOnClickListener(v -> {
            String keyword = mEditText.getText().toString();
            if(keyword.length() > 0)
            movieListCallback.onFetchMovieList(keyword);
        });*/
        movieListCallback.onFetchMovieList("");

        mMovieListAdapter = new MovieListAdapter(getContext());
        mMovieListAdapter.setMovieList(mData);
        mMovieListAdapter.setOnMovieItemClickListener(movieListCallback);

        mRecyclerView.setAdapter(mMovieListAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    public void loadData(List<MoveResponse> moveResponses) {
        mData = moveResponses;
        if(mMovieListAdapter == null) return;
        mMovieListAdapter.setMovieList(mData);
        mMovieListAdapter.notifyDataSetChanged();
    }

    public List<MoveResponse> getData() {
        return mData;
    }

}

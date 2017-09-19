package com.meng.flicks.presentation.views.fragments;

import android.content.Context;
import android.content.res.Configuration;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.meng.flicks.R;
import com.meng.flicks.data.API;
import com.meng.flicks.presentation.beans.MoveResponse;

import java.util.List;

/**
 * Created by mengzhou on 7/3/17.
 */
public class MovieListAdapter extends RecyclerView.Adapter<MovieListAdapter.MovieListViewHolder> {

    private static final String TAG = MovieListAdapter.class.getSimpleName();
    private Context mContext;
    private LayoutInflater mLayoutInflater;
    private List<MoveResponse> mList;
    private int mOrientation = Configuration.ORIENTATION_PORTRAIT;

    private MovieListFragment.MovieListCallback onMovieItemClickListener;

    public void setOnMovieItemClickListener(MovieListFragment.MovieListCallback onMovieItemClickListener) {
        this.onMovieItemClickListener = onMovieItemClickListener;
    }

    public MovieListAdapter(Context context) {
        mLayoutInflater = LayoutInflater.from(context);
        this.mContext = context;
    }

    public void setMovieList(List<MoveResponse> list) {
        this.mList = list;
    }

    @Override
    public MovieListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Log.i(TAG, "onCreateViewHolder method called");
        View view = mLayoutInflater.inflate(R.layout.recycle_movie_item, null);
        return new MovieListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MovieListViewHolder holder, final int position) {
        Log.i(TAG, "onBindViewHolder method called: " + position);
        if(mList == null) return;

        holder.view.setOnClickListener(v -> {
                if(onMovieItemClickListener != null)
                    onMovieItemClickListener.onMovieItemClick(position);
            });
        MoveResponse moveResponse = mList.get(position);
        holder.title.setText(moveResponse.title);
        holder.summary.setText(moveResponse.overview);
        holder.info.setText(String.valueOf(moveResponse.popularity));

        if(mOrientation == Configuration.ORIENTATION_PORTRAIT) {
            String url = new API().imageUrl(moveResponse.backdrop_path);
            Glide.with(mContext).load(url).into(holder.cover);
        } else {
            Toast.makeText(mContext, "orientation: " + mOrientation, Toast.LENGTH_LONG).show();
            String url = new API().imageUrl(moveResponse.poster_path);
            Glide.with(mContext).load(url).into(holder.cover);
        }

    }

    @Override
    public int getItemCount() {
        return mList == null ? 0 : mList.size();
    }

    public void updateUI(int orientation) {
        mOrientation = orientation;
        notifyDataSetChanged();
    }

    static class MovieListViewHolder extends RecyclerView.ViewHolder{

        public View view;
        public TextView title;
        public TextView summary;
        public ImageView cover;
        public TextView info;

        public MovieListViewHolder(View itemView) {
            super(itemView);
            view = itemView;
            title = itemView.findViewById(R.id.movie_tittle);
            summary = itemView.findViewById(R.id.movie_abstract);
            cover = itemView.findViewById(R.id.movie_cover);
            info = itemView.findViewById(R.id.movie_info);
        }
    }
}

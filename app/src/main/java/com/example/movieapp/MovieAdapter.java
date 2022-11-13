package com.example.movieapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MyView> {


    private List<Movie> data;
    private Context context;
//    MovieClickListener movieClickListener;

    public MovieAdapter() {

    }

    public void setData(Context context, List<Movie> list) {
        this.data = list;
        this.context = context;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MyView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_movie, parent, false);
        return new MyView(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyView holder, int position) {

        final  Movie movie = data.get(position);

        holder.tvTitle.setText(data.get(position).getTitle());
        holder.imgMovie.setImageResource(movie.getResourceId());

        holder.imgMovie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickMovieDetail(movie);
            }
        });

    }

    private void onClickMovieDetail(Movie movie) {
        Intent intent = new Intent(context,DetailMovieActivity.class);
//        Bundle bundle = new Bundle();
//        bundle.putSerializable("movie", movie);
        intent.putExtra("title", movie.getTitle());
        intent.putExtra("imageMovie", movie.getResourceId());
        context.startActivity(intent);

    }

    @Override
    public int getItemCount() {
       if(data != null){
           return data.size();
       }
        return 0;
    }

    public MovieAdapter(List<Movie> data, MovieClickListener listener) {
        this.data = data;
//        movieClickListener = listener;

    }

    public class MyView extends RecyclerView.ViewHolder {

        private TextView tvTitle;
        private ImageView imgMovie;

        public MyView(@NonNull View itemView) {
            super(itemView);

            tvTitle = itemView.findViewById(R.id.tvTitle);
            imgMovie = itemView.findViewById(R.id.imgMovie);



//            itemView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    movieClickListener.onMovieClick(data.get(getAdapterPosition()), imgMovie);
//                }
//            });
        }
    }
}

package com.example.movieapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

public class DetailMovieActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_movie);

        String movieTitle = getIntent().getExtras().getString("title");
        int imageResourceId = getIntent().getExtras().getInt("imageMovie");


//        Bundle bundle = getIntent().getExtras();
//        Movie movie = (Movie) bundle.get("movie");

        ImageView imgDetail = findViewById(R.id.imgDetail);
        imgDetail.setImageResource(imageResourceId);
//        movie.setResourceId(movie.getResourceId());
    }
}
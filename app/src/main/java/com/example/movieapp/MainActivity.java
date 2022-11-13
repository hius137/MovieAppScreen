package com.example.movieapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements MovieClickListener{

    private RecyclerView rvCategory;
    private MovieAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvCategory = findViewById(R.id.rvCategory);
        adapter = new MovieAdapter();

        adapter.setData(this,getList());
        rvCategory.setAdapter(adapter);
    }
    private List<Movie> getList() {

        List<Movie> listMovie = new ArrayList<>();
        listMovie.add(new Movie(R.drawable.arrival, "Arrival"));
        listMovie.add(new Movie(R.drawable.darkknight, "The Dark Knight"));
        listMovie.add(new Movie(R.drawable.expanse, "Expanse"));
        listMovie.add(new Movie(R.drawable.theman, "The Man In High Castle"));
        listMovie.add(new Movie(R.drawable.clover, "CloverField"));
        listMovie.add(new Movie(R.drawable.salvation2, "Salvation"));
        listMovie.add(new Movie(R.drawable.mockingjay, "MockingJay"));
        listMovie.add(new Movie(R.drawable.ironman, "Iron Man"));

        return listMovie;
    }

    @Override
    public void onMovieClick(Movie movie, ImageView movieImage) {
        //gửi thông tin phim sang detailMovieActivity
        Toast.makeText(this,"item click"+ movie.getTitle(),Toast.LENGTH_LONG).show();

    }
}
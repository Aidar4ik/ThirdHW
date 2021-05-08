package com.example.retrofitgetput.ui.posts;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.example.retrofitgetput.R;
import com.example.retrofitgetput.data.adapters.AdapterPosts;
import com.example.retrofitgetput.data.models.Model;
import com.example.retrofitgetput.data.remote.RetrofitBuilder;
import com.example.retrofitgetput.ui.MainActivity;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PostsActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private AdapterPosts adapterPosts = new AdapterPosts();
    private List<Model> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_posts);
        init();

        RetrofitBuilder.getInstance().getPosts().enqueue(new Callback<List<Model>>() {
            @Override
            public void onResponse(Call<List<Model>> call, Response<List<Model>> response) {
                list.addAll(response.body());
                adapterPosts.addList(list);
            }

            @Override
            public void onFailure(Call<List<Model>> call, Throwable t) {

            }
        });
    }

    private void init() {
        recyclerView = findViewById(R.id.recycler_posts);
        recyclerView.setAdapter(adapterPosts);
    }
}
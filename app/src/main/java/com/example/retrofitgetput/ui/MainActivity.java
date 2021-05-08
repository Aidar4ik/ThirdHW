package com.example.retrofitgetput.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import com.example.retrofitgetput.R;
import com.example.retrofitgetput.data.adapters.AdapterPosts;
import com.example.retrofitgetput.data.models.Model;
import com.example.retrofitgetput.data.remote.RetrofitBuilder;
import com.example.retrofitgetput.ui.posts.PostsActivity;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private EditText editId, editTitle;
    private Button btnAdd, btnUp, btnDeletee, btnPosts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        btnPosts.setOnClickListener(v -> {
            Intent intent=new Intent(MainActivity.this,PostsActivity.class);
            startActivity(intent);
        });
            btnAdd.setOnClickListener(v -> {
                RetrofitBuilder.getInstance().putPost(new Model(editTitle.getText().toString())).enqueue(new Callback<Model>() {
                    @Override
                    public void onResponse(Call<Model> call, Response<Model> response) {
                        Log.d("Tag", response.body().toString());
                    }

                    @Override
                    public void onFailure(Call<Model> call, Throwable t) {

                    }
                });
            });
            btnUp.setOnClickListener(v -> {
                int idl = Integer.parseInt(editId.getText().toString());
                RetrofitBuilder.getInstance().updatePost(idl, new Model(editTitle.getText().toString())).enqueue(new Callback<Model>() {
                    @Override
                    public void onResponse(Call<Model> call, Response<Model> response) {

                    }

                    @Override
                    public void onFailure(Call<Model> call, Throwable t) {

                    }
                });
            });
            btnDeletee.setOnClickListener(v -> {
                int idle = Integer.parseInt(editId.getText().toString());
                RetrofitBuilder.getInstance().deletePost(idle).enqueue(new Callback<Model>() {
                    @Override
                    public void onResponse(Call<Model> call, Response<Model> response) {

                    }

                    @Override
                    public void onFailure(Call<Model> call, Throwable t) {

                    }
                });
            });
        }

    private void init() {
        editId = findViewById(R.id.etId);
        editTitle = findViewById(R.id.etTitle);
        btnAdd = findViewById(R.id.button);
        btnUp = findViewById(R.id.upData);
        btnDeletee = findViewById(R.id.btnDelete);
        btnPosts = findViewById(R.id.btnPosts);
    }
}
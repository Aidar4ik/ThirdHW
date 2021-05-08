package com.example.retrofitgetput.data.remote;

import com.example.retrofitgetput.data.models.Model;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface TestApi {

    @GET("posts/")
    Call<List<Model>> getPosts();

   @POST("posts/")
    Call<Model> putPost(@Body Model model);

   @PUT("posts/{id}")
    Call<Model> updatePost(@Path("id") int id, @Body Model Model);

   @DELETE("posts/{id}")
    Call<Model> deletePost(@Path("id") int idl);
}

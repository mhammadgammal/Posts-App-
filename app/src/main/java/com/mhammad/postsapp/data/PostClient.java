package com.mhammad.postsapp.data;

import com.google.gson.Gson;
import com.mhammad.postsapp.pojo.PostModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PostClient {
    private static final String baseURL = "https://jsonplaceholder.typicode.com/";
    private PostInterface postInterface;
    private static PostClient INSTANCE;

    public PostClient() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseURL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        postInterface = retrofit.create(PostInterface.class);
    }

    public static PostClient getINSTANCE() {
        if (INSTANCE == null)
        {
            INSTANCE = new PostClient();
        }
        return INSTANCE;
    }
    public Call<List<PostModel>> getPosts(){
        return postInterface.getPosts();
    }

}

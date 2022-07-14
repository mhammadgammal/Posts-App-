package com.example.postsappv2.data;

import com.example.postsappv2.pojo.PostModel;

import java.util.List;

import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory;
import io.reactivex.rxjava3.core.Observable;
import retrofit2.Retrofit;

import retrofit2.converter.gson.GsonConverterFactory;

public class PostsClient {
    private String baseURL = "https://jsonplaceholder.typicode.com/";
    private PostInterface postInterface;
    private static  PostsClient INSTANCE;

    public PostsClient() {
        Retrofit retrofit =new Retrofit.Builder()
                .baseUrl(baseURL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .build();
        postInterface = retrofit.create(PostInterface.class);
    }

    public static PostsClient getINSTANCE() {
        if (INSTANCE == null)
        {
           INSTANCE = new PostsClient();
        }
        return INSTANCE;
    }

    public Observable<List<PostModel>> getPosts(){
        return postInterface.getPosts();
    }
}

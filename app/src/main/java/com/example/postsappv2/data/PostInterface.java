package com.example.postsappv2.data;

import com.example.postsappv2.pojo.PostModel;

import java.util.List;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.http.GET;

public interface PostInterface {
    @GET("posts")
    Observable<List<PostModel>> getPosts();
}

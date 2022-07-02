package com.mhammad.postsapp.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.mhammad.postsapp.R;
import com.mhammad.postsapp.pojo.PostModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    PostAdapter adapter;
    RecyclerView recyclerView;
    PostViewModel postViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        adapter = new PostAdapter();
        recyclerView = findViewById(R.id.recyc);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
        postViewModel = new ViewModelProvider(this).get(PostViewModel.class);
        postViewModel.getPosts();
        postViewModel.posts.observe(this, new Observer<List<PostModel>>() {
            @Override
            public void onChanged(List<PostModel> postModels) {
                adapter.setList(postModels);
            }
        });
    }
}
package com.example.postsappv2.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.postsappv2.R;
import com.example.postsappv2.databinding.ActivityMainBinding;
import com.example.postsappv2.pojo.PostModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    PostsAdapter adapter;
    ActivityMainBinding binding;
    PostsViewModel viewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setLifecycleOwner(this);
        adapter = new PostsAdapter();
        binding.recycler.setAdapter(adapter);
        binding.recycler.setLayoutManager(new LinearLayoutManager(this));
        viewModel = new ViewModelProvider(this).get(PostsViewModel.class);
        viewModel.getPosts();
        viewModel.posts.observe(this, new Observer<List<PostModel>>() {
            @Override
            public void onChanged(List<PostModel> postModels) {
                adapter.setList(postModels);
            }
        });
    }
}
package com.example.postsappv2.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.postsappv2.R;
import com.example.postsappv2.pojo.PostModel;

import java.util.ArrayList;
import java.util.List;

public class PostsAdapter extends RecyclerView.Adapter<PostsAdapter.PostsViewHolder> {
    List<PostModel> posts = new ArrayList<>();
    @NonNull
    @Override
    public PostsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new PostsViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.post_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull PostsViewHolder holder, int position) {
        holder.titleTV.setText(posts.get(position).getTitle());
        holder.userIDTV.setText(posts.get(position).getId()+"");
        holder.bodyTV.setText(posts.get(position).getBody());
    }

    @Override
    public int getItemCount() {
        return posts.size();
    }
    public void setList(List<PostModel> postList) {
        this.posts = postList;
        notifyDataSetChanged();
    }
    public class PostsViewHolder extends RecyclerView.ViewHolder{
        TextView titleTV, userIDTV, bodyTV;
        public PostsViewHolder(@NonNull View itemView) {
            super(itemView);
            titleTV = itemView.findViewById(R.id.titleTV);
            userIDTV = itemView.findViewById(R.id.userIDTV);
            bodyTV = itemView.findViewById(R.id.bodyTV);
        }
    }
}

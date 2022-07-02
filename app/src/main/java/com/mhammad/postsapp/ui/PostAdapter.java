package com.mhammad.postsapp.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mhammad.postsapp.R;
import com.mhammad.postsapp.pojo.PostModel;

import java.util.ArrayList;
import java.util.List;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.PostViewHolder> {
    private List<PostModel> postList = new ArrayList<>();
    @NonNull
    @Override
    public PostAdapter.PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new PostViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.post_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull PostAdapter.PostViewHolder holder, int position) {
        holder.titleTV.setText(postList.get(position).getTitle());
        holder.idTV.setText(postList.get(position).getId()+"");
        holder.postTV.setText(postList.get(position).getBody());
    }
    public void setList(List<PostModel> postList) {
        this.postList = postList;
        notifyDataSetChanged();
    }
    @Override
    public int getItemCount() {
        return postList.size();
    }
    public class PostViewHolder extends RecyclerView.ViewHolder{
        TextView titleTV, idTV, postTV;
        public PostViewHolder(@NonNull View itemView) {
            super(itemView);
            titleTV = itemView.findViewById(R.id.titleTV);
            idTV = itemView.findViewById(R.id.idTV);
            postTV = itemView.findViewById(R.id.postTV);
        }
    }
}

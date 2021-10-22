package com.example.myapi;

import android.content.Context;
import android.view.ContentInfo;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    ArrayList<Post> postList;
    Context context;

    public Adapter(ArrayList<Post> postList, Context context) {
        this.postList = postList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.textfile, parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Post post = postList.get(position);
        holder.country.setText(postList.get(position).getName());
        holder.country_code.setText(postList.get(position).getCountry_code());
        holder.region.setText(postList.get(position).getRegion());

    }

    @Override
    public int getItemCount() {
        return postList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView country , region , country_code;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            country = itemView.findViewById(R.id.txt1);
            region = itemView.findViewById(R.id.txt2);
            country_code = itemView.findViewById(R.id.txt3);
        }
    }
}

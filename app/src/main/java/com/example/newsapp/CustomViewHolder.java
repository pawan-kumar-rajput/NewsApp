package com.example.newsapp;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class CustomViewHolder extends RecyclerView.ViewHolder {
    TextView mheading,mcontent,mauthor,mcategory,mtime;
    CardView cardView;
    ImageView imageView;

    public CustomViewHolder(@NonNull View itemView) {
        super(itemView);
        mheading=itemView.findViewById(R.id.main_heading);
        mcontent=itemView.findViewById(R.id.content);
        mauthor=itemView.findViewById(R.id.author);
        mtime=itemView.findViewById(R.id.time);
        imageView=itemView.findViewById(R.id.imageview);
        cardView=itemView.findViewById(R.id.cardview);
    }
}


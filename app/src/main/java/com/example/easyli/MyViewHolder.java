package com.example.easyli;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

class MyViewHolder extends RecyclerView.ViewHolder {
    TextView txtisbn, txttitle, txtauthor;
    public MyViewHolder(@NonNull View itemView) {
        super(itemView);
        //views
        txtisbn = itemView.findViewById(R.id.isbn);
        txttitle = itemView.findViewById(R.id.title);
        txtauthor = itemView.findViewById(R.id.author);

    }
}










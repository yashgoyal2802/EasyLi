package com.example.easyli;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyAdapter extends RecyclerView.ViewHolder {

    public TextView txtisbn;
    public TextView txttitle;
    public TextView txtauthor;
    public TextView txtpages;
    public TextView txtissuedtill;
    public TextView txtdescription;
    public MyAdapter(@NonNull View itemView) {
        super(itemView);
        txtisbn = (TextView)itemView.findViewById(R.id.isbn);
        txttitle = (TextView)itemView.findViewById(R.id.title);
        txtauthor = (TextView)itemView.findViewById(R.id.author);
        txtpages = (TextView)itemView.findViewById(R.id.pages);
        txtissuedtill = (TextView)itemView.findViewById(R.id.issuedtill);
        txtdescription = (TextView)itemView.findViewById(R.id.description);

    }
}










package com.example.easyli;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.easyli.Model.books;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Browsing extends AppCompatActivity {
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    FirebaseRecyclerAdapter<books, MyAdapter> adapter;
    FirebaseDatabase database;
    DatabaseReference reference;
   // books b = new books();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browsing);

        database = FirebaseDatabase.getInstance();
        reference=database.getReference("books");

        recyclerView = (RecyclerView)findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        layoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        showList();
    }

    private void showList() {
        FirebaseRecyclerOptions option = new FirebaseRecyclerOptions.Builder<books>().setQuery(reference, books.class).build();

        adapter = new FirebaseRecyclerAdapter<books, MyAdapter>(option) {
            @Override
            protected void onBindViewHolder(@NonNull MyAdapter holder, int position, @NonNull books model) {
                holder.txtisbn.setText(model.getIsbn());
                holder.txttitle.setText(model.getTitle());
                holder.txtauthor.setText(model.getAuthor());
                holder.txtpages.setText(String.valueOf(model.getPages()));
                holder.txtissuedtill.setText(model.getIssuedtill());
                holder.txtdescription.setText(model.getDescription());
                //holder.txtsubtitle.setText(b.getSubtitle());
               // holder.txtpublisher.setText(b.getPublisher());
            }

            @NonNull
            @Override
            public MyAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview,parent,false);
                return new MyAdapter(v);
            }
        };
        adapter.startListening();
        adapter.notifyDataSetChanged();
        recyclerView.setAdapter(adapter);

    }
}

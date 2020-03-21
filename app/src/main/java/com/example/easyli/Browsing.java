package com.example.easyli;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Browsing extends AppCompatActivity {
    RecyclerView recyclerView;
    FirebaseDatabase database;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browsing);

//        //Actionbar
//        ActionBar actionBar = getSupportActionBar();
//
//        //set title
//        actionBar.setTitle("Books List");

        //Recycler View
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);

        //set layout as Linear Layout
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        //send Query to Firebase
        database = FirebaseDatabase.getInstance();
        reference = database.getReference("books");

        //Load Data into Recycler View onStart
        FirebaseRecyclerOptions<model> options = new FirebaseRecyclerOptions.Builder<model>().setQuery(reference, model.class).build();
        FirebaseRecyclerAdapter<model, MyViewHolder> firebaseRecyclerAdapter = new FirebaseRecyclerAdapter<model, MyViewHolder>(options) {
            @Override
            protected void onBindViewHolder(@NonNull MyViewHolder holder, int position, @NonNull model model) {
                holder.txtisbn.setText(model.getIsbn());
                holder.txttitle.setText(model.getTitle());
                holder.txtauthor.setText(model.getAuthor());
            }

            @NonNull
            @Override
            public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview, parent, false);
                return new MyViewHolder(v);
            }
        };
        //set Adapter to Recycler View
        firebaseRecyclerAdapter.startListening();
        recyclerView.setAdapter(firebaseRecyclerAdapter);
    }

}

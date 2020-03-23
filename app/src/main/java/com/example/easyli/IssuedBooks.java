package com.example.easyli;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class IssuedBooks extends AppCompatActivity {

    RecyclerView recyclerView;
    DatabaseReference ref1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        RecyclerView recyclerView;
        DatabaseReference ref1;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_issued_books);


        recyclerView=findViewById(R.id.recyclerView2);
        recyclerView.setHasFixedSize(true);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        //Actionbar
        ActionBar actionBar = getSupportActionBar();
        //set title
        actionBar.setTitle("Issued Books");

        ref1 = FirebaseDatabase.getInstance().getReference().child("books");


        recyclerView=findViewById(R.id.recyclerView2);
        recyclerView.setHasFixedSize(true);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        ref1 = FirebaseDatabase.getInstance().getReference().child("books");

        FirebaseRecyclerOptions<model> option = new FirebaseRecyclerOptions.Builder<model>().setQuery(ref1, model.class).build();
        FirebaseRecyclerAdapter<model,MyViewHolder> adapter = new FirebaseRecyclerAdapter<model, MyViewHolder>(option) {
            @Override
            protected void onBindViewHolder(@NonNull MyViewHolder holder, int position, @NonNull model model) {
                Object issu = model.getIssue();
                if(issu.toString().equals("1")){
                    holder.txtisbn.setText(model.getIsbn());
                    holder.txttitle.setText(model.getTitle());
                    holder.txtauthor.setText(model.getAuthor());
                }else{
                    Toast.makeText(IssuedBooks.this,"No books Issued",Toast.LENGTH_SHORT).show();
                }
            }

            @NonNull
            @Override
            public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View v1 = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview,parent,false);
                return new MyViewHolder(v1);
            }
        };
        adapter.startListening();
        recyclerView.setAdapter(adapter);

    }
}

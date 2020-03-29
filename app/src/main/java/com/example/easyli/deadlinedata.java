package com.example.easyli;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class deadlinedata extends AppCompatActivity {
    RecyclerView recyclerView;
    DatabaseReference ref2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deadlinedata);
        ColorDrawable cd2 = new ColorDrawable(Color.parseColor("#5F61E6"));
        //Actionbar
        ActionBar actionBar = getSupportActionBar();
        //set title
        actionBar.setTitle("Deadline");
        actionBar.setBackgroundDrawable(cd2);

        ref2 = FirebaseDatabase.getInstance().getReference().child("books");


        recyclerView=findViewById(R.id.recyclerView3);
        recyclerView.setHasFixedSize(true);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        ref2 = FirebaseDatabase.getInstance().getReference().child("books");

        FirebaseRecyclerOptions<model> option = new FirebaseRecyclerOptions.Builder<model>().setQuery(ref2, model.class).build();
        FirebaseRecyclerAdapter<model,MyViewHolder> adapter = new FirebaseRecyclerAdapter<model, MyViewHolder>(option) {
            @Override
            protected void onBindViewHolder(@NonNull MyViewHolder holder, int position, @NonNull model model) {
                Object issu = model.getIssue();
                if(issu.toString().equals("1")){
                    holder.txttitle.setText(model.getTitle());
                    holder.txtdeadline.setText(model.getIssuedtill());
                }
            }

            @NonNull
            @Override
            public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View v1 = LayoutInflater.from(parent.getContext()).inflate(R.layout.deadlinecardview,parent,false);
                return new MyViewHolder(v1);
            }
        };
        adapter.startListening();
        recyclerView.setAdapter(adapter);


    }
}

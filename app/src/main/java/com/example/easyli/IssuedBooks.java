package com.example.easyli;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class IssuedBooks extends AppCompatActivity {

    RecyclerView recyclerView;
    DatabaseReference ref1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
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

    }
}

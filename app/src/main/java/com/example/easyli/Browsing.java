package com.example.easyli;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

public class Browsing extends AppCompatActivity {

    EditText inputsearch;
    RecyclerView recyclerView;
    FirebaseDatabase database;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browsing);

        //Actionbar
        ActionBar actionBar = getSupportActionBar();
        //set title
        actionBar.setTitle("Books List");

        //search view
        inputsearch=findViewById(R.id.searchview);

        //Recycler View
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);

        //set layout as Linear Layout
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        //send Query to Firebase
        database = FirebaseDatabase.getInstance();
        reference = database.getReference("books");

        //Load Data into Recycler View onStart
        LoadData("");

        inputsearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if(editable.toString()!=null){
                    LoadData(editable.toString());
                }else{
                    LoadData("");
                }
            }
        });
    }


    public void LoadData(String data){

        Query query = reference.orderByChild("title").startAt(data).endAt(data+"\uf8ff");

        FirebaseRecyclerOptions<model> options = new FirebaseRecyclerOptions.Builder<model>().setQuery(query, model.class).build();
        FirebaseRecyclerAdapter<model, MyViewHolder> firebaseRecyclerAdapter = new FirebaseRecyclerAdapter<model, MyViewHolder>(options) {
            @Override
            protected void onBindViewHolder(@NonNull MyViewHolder holder, int position, @NonNull model model) {
                final String key = getRef(position).getKey();
                holder.view.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(getApplicationContext(),Clicked.class);
                        intent.putExtra("key",key);
                        startActivity(intent);


                    }
                });
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

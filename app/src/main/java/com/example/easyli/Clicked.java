package com.example.easyli;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.sql.DatabaseMetaData;

public class Clicked extends AppCompatActivity {

    TextView isbn_tc,title_tc,author_tc,desc_tc,pages_tc;
    DatabaseReference ref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clicked);
        isbn_tc=findViewById(R.id.isbn_tc);
        title_tc=findViewById(R.id.title_tc);
        author_tc=findViewById(R.id.author_tc);
        pages_tc=findViewById(R.id.pages_tc);
        desc_tc=findViewById(R.id.description_tc);
        ref = FirebaseDatabase.getInstance().getReference().child("books");

        String key = getIntent().getStringExtra("key");

        ref.child(key).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Object obj = dataSnapshot.child("pages").getValue();
                String isbn = dataSnapshot.child("isbn").getValue().toString();
                String title = dataSnapshot.child("title").getValue().toString();
                String author = dataSnapshot.child("author").getValue().toString();
                String desc = dataSnapshot.child("description").getValue().toString();

                isbn_tc.setText(isbn);
                title_tc.setText(title);
                author_tc.setText(author);
                pages_tc.setText(""+obj);
                desc_tc.setText(desc);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}

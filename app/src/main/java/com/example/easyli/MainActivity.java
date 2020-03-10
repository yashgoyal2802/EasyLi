package com.example.easyli;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void issueddatabase(View view) {
        Intent i1 = new Intent(this,IssuedBooks.class);
        startActivity(i1);
    }
    public void deadlinedata(View v) {
        Intent i1 = new Intent(this,IssuedBooks.class);
        startActivity(i1);
    }
    public void browsing(View v) {
        Intent i1 = new Intent(this,Browsing.class);
        startActivity(i1);
    }
}

package com.example.easyli;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    Button b1;
    FirebaseAuth.AuthStateListener authStateListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1 = (Button)findViewById(R.id.button4);
        setupFirebaseListner();
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

    public void logout(View view) {
        FirebaseAuth.getInstance().signOut();
    }
    public void setupFirebaseListner(){

        authStateListener=new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if(user!=null){
                    Toast.makeText(getApplicationContext(),"Signed in",Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getApplicationContext(),"Signed out",Toast.LENGTH_SHORT).show();
                    Intent i1 = new Intent(MainActivity.this,Login.class);
                    i1.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK |Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(i1);
                }
            }
        };
    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseAuth.getInstance().addAuthStateListener(authStateListener);
    }

    @Override
    protected void onStop() {
        super.onStop();
        if(authStateListener!=null){
            FirebaseAuth.getInstance().removeAuthStateListener(authStateListener);

        }
    }
}

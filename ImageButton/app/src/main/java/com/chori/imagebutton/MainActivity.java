package com.chori.imagebutton;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // Star Method
    public void StarMessage (View view){
        Toast.makeText(this, "This is a star.", Toast.LENGTH_SHORT).show();
    }
    // Finger Method
    public void FingerMessage (View view){
        Toast.makeText(this, "This is a finger", Toast.LENGTH_SHORT).show();
    }
}
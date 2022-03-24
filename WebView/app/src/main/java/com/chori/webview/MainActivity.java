package com.chori.webview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText et_web;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_web = (EditText) findViewById(R.id.et_web);
    }
    // Go Button Method
    public void navigate (View view){
        Intent i = new Intent(this, ActivityWeb.class);
        i.putExtra("webSite", et_web.getText().toString());
        startActivity(i);
    }
}
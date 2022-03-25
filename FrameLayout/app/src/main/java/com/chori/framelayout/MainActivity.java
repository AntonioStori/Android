package com.chori.framelayout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private ImageView iv1;
    private Button btn1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iv1 = (ImageView) findViewById(R.id.imageView);
        btn1 = (Button) findViewById(R.id.button);
    }
    public void Hide (View view){
        btn1.setVisibility(View.INVISIBLE);
        iv1.setVisibility(View.VISIBLE);
    }
}
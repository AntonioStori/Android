package com.chori.myapp2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText et1;
    private EditText et2;
    private EditText et3;
    private TextView tv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1 = (EditText) findViewById(R.id.txt_math);
        et2 = (EditText) findViewById(R.id.txt_physics);
        et3 = (EditText) findViewById(R.id.txt_chemestry);
        tv1 = (TextView) findViewById(R.id.tv_status);
    }

    public void status(View view){
        String Math_string = et1.getText().toString();
        String Physics_string = et2.getText().toString();
        String Chemestry_string = et3.getText().toString();

        int Math_int = Integer.parseInt(Math_string);
        int Physics_int = Integer.parseInt(Physics_string);
        int Chemestry_int = Integer.parseInt(Chemestry_string);

        int average = ( Math_int + Physics_int + Chemestry_int) / 3;

        if (average >= 6){
            tv1.setText("Status PASS with " + average);
        } else if (average <= 5){
            tv1.setText("Status FAIL with " + average);
        }
    }
}
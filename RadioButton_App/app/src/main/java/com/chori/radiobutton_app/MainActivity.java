package com.chori.radiobutton_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText et1, et2;
    private TextView tv1;
    private RadioButton rb1, rb2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1 = (EditText) findViewById(R.id.txt_value1);
        et2 = (EditText) findViewById(R.id.txt_value2);
        tv1 = (TextView) findViewById(R.id.result);
        rb1 = (RadioButton) findViewById(R.id.rb_add);
        rb2 = (RadioButton) findViewById(R.id.rb_subtract);
    }
    // Calculate Method Button
    public void calculate(View view){
        String value1_String = et1.getText().toString();
        String value2_String = et2.getText().toString();
        int value1_int = Integer.parseInt(value1_String);
        int value2_int = Integer.parseInt(value2_String);

        if (rb1.isChecked() == true ){
            int add = value1_int + value2_int;
            String result = String.valueOf(add);
            tv1.setText(result);
        } else if (rb2.isChecked() == true){
            int subtract = value1_int - value2_int;
            String result = String.valueOf(subtract);
            tv1.setText(result);
        }

    }
}
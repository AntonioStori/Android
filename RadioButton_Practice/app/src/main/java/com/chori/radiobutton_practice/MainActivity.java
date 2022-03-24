package com.chori.radiobutton_practice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText et1, et2;
    private TextView tv1;
    private RadioButton rb_add, rb_subtract, rb_multiply, rb_divide;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1 = (EditText) findViewById(R.id.Value1);
        et2 = (EditText) findViewById(R.id.Value2);
        tv1 = (TextView) findViewById(R.id.tv_result);
        rb_add = (RadioButton) findViewById(R.id.rb_add);
        rb_subtract = (RadioButton) findViewById(R.id.rb_subtract);
        rb_multiply = (RadioButton) findViewById(R.id.rb_multiply);
        rb_divide = (RadioButton) findViewById(R.id.rb_divide);
    }
    public void Calculate(View view){
        String value1_String = et1.getText().toString();
        String value2_String = et2.getText().toString();
        int value1_int = Integer.parseInt(value1_String);
        int value2_int = Integer.parseInt(value2_String);
        if ( rb_add.isChecked() == true){
            int add = value1_int + value2_int;
            String result = String.valueOf(add);
            tv1.setText(result);
        } else if ( rb_subtract.isChecked() == true){
            int subtract = value1_int - value2_int;
            String result = String.valueOf(subtract);
            tv1.setText(result);
        } else if( rb_multiply.isChecked() == true){
            int multiply = value1_int * value2_int;
            String result = String.valueOf(multiply);
            tv1.setText(result);
        } else if( rb_divide.isChecked() == true){
            if (value2_int != 0 ){
                int divide = value1_int / value2_int;
                String result = String.valueOf(divide);
                tv1.setText(result);
            } else {
                Toast.makeText(this, "You can't divide by 0",  Toast.LENGTH_LONG);

            }
        }
    }
}
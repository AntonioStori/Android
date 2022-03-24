package com.chori.checkbox_practice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText et_value1, et_value2;
    private TextView tv_result;
    private CheckBox cb_add, cb_subtract;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_value1 = (EditText) findViewById(R.id.et_value1);
        et_value2 = (EditText) findViewById(R.id.et_value2);
        tv_result = (TextView) findViewById(R.id.tv_result);
        cb_add = (CheckBox) findViewById(R.id.cb_add);
        cb_subtract = (CheckBox) findViewById(R.id.cb_subtract);


    }
    public void Calculate(View view){
        String value1_String = et_value1.getText().toString();
        String value2_String = et_value2.getText().toString();
        int value1_int = Integer.parseInt(value1_String);
        int value2_int = Integer.parseInt(value2_String);
        String result = "";

        if ( cb_add.isChecked() == true ){
            int add = value1_int + value2_int;
            result = "The add is: " + add + " / ";
        }
        if ( cb_subtract.isChecked() == true ){
            int subtract = value1_int - value2_int;
            result = result + "The subtract is: " + subtract;
        }
        tv_result.setText(result);

    }
}
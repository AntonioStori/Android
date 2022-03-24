package com.chori.spinner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Spinner spinner1;
    private EditText et_value1, et_value2;
    private TextView tv_result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_value1 = (EditText) findViewById(R.id.et_value1);
        et_value2 = (EditText) findViewById(R.id.et_value2);
        tv_result = (TextView) findViewById(R.id.rv_result);
        spinner1 = (Spinner) findViewById(R.id.spinner);

        String [] options = {"Add", "Subtract", "Multiply", "Divide"};

        ArrayAdapter <String> adapter = new ArrayAdapter<String>(this, R.layout.spinner_item_spinner1, options);
        spinner1.setAdapter(adapter);
    }

    //Button Method
    public void Calculate(View view){
        String value1_string = et_value1.getText().toString();
        String value2_string = et_value2.getText().toString();
        int value1_int = Integer.parseInt(value1_string);
        int value2_int = Integer.parseInt(value2_string);

        String selection = spinner1.getSelectedItem().toString();

        if ( selection.equals("Add") ){
            int add = value1_int + value2_int;
            String result = String.valueOf(add);
            tv_result.setText(result);
        } else if ( selection.equals("Subtract") ){
            int subtract = value1_int - value2_int;
            String result = String.valueOf(subtract);
            tv_result.setText(result);
        } else if ( selection.equals("Multiply") ){
            int multiply = value1_int * value2_int;
            String result = String.valueOf(multiply);
            tv_result.setText(result);
        } else if ( selection.equals("Divide") ){
            if (value2_int != 0){
                int divide = value1_int / value2_int;
                String result = String.valueOf(divide);
                tv_result.setText(result);
            }else{
                Toast.makeText(this, "You can not divide by 0", Toast.LENGTH_LONG).show();
            }
        }
    }
}
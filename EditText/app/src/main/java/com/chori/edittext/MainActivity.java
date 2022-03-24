package com.chori.edittext;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText et_name, et_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_name = (EditText) findViewById(R.id.et_name);
        et_password = (EditText) findViewById(R.id.et_password);
    }

    //Button Method
    public void Login (View view){
        String name = et_name.getText().toString();
        String password = et_password.getText().toString();

        if ( name.length() == 0 ){
            Toast.makeText(this, "The name is required", Toast.LENGTH_LONG).show();
        }
        if ( password.length() == 0 ){
            Toast.makeText(this, "The password is required", Toast.LENGTH_LONG).show();
        }
        if ( name.length() != 0 && password.length() != 0){
            Toast.makeText(this, "Login in process", Toast.LENGTH_LONG).show();
        }
    }
}
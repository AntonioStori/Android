package com.chori.sharedpreferencesagenda;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText et_name, et_data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_name = (EditText) findViewById(R.id.et_name);
        et_data= (EditText) findViewById(R.id.et_data);
    }

    //Save Button Method
    public void Save (View view){
        String name = et_name.getText().toString();
        String data = et_data.getText().toString();

        SharedPreferences preferences = getSharedPreferences("agenda", Context.MODE_PRIVATE);
        SharedPreferences.Editor obj_editor = preferences.edit();
        obj_editor.putString(name, data);
        obj_editor.commit();

        Toast.makeText(this, "The contact has been saved.", Toast.LENGTH_SHORT).show();
    }

    //Search Button Method
    public void Search (View view){
        String name = et_name.getText().toString();
        SharedPreferences preferences = getSharedPreferences("agenda", Context.MODE_PRIVATE);
        String data = preferences.getString(name, "");
        if (data.length() == 0){
            Toast.makeText(this, "There is not data", Toast.LENGTH_SHORT).show();
        } else{
            et_data.setText(data);

        }
    }
}
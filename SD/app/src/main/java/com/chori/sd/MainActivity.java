package com.chori.sd;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.Buffer;

public class MainActivity extends AppCompatActivity {

    private EditText et_name, et_data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_name = (EditText) findViewById(R.id.et_file);
        et_data = (EditText) findViewById(R.id.et_data);
    }

    //Save Button Method
    public void Save (View view){
        String name = et_name.getText().toString();
        String content = et_data.getText().toString();

        try {
            File sdCard = Environment.getExternalStorageDirectory();
            Toast.makeText(this, sdCard.getPath(), Toast.LENGTH_SHORT).show();
            File fileRute = new File(sdCard.getPath(), name);
            OutputStreamWriter createFile = new OutputStreamWriter(openFileOutput(name, Activity.MODE_PRIVATE));

            createFile.write(content);
            createFile.flush();
            createFile.close();

            Toast.makeText(this, "Saved correctly", Toast.LENGTH_SHORT).show();
            et_name.setText("");
            et_data.setText("");

        }catch (IOException e){
            Toast.makeText(this, "It could not save", Toast.LENGTH_SHORT).show();
        }
    }

    //Consult Button Method
    public void Consult (View view){
        String name = et_name.getText().toString();
        
        try {
            File sdCard = Environment.getExternalStorageDirectory();
            File fileRoute = new File(sdCard.getPath(), name);
            InputStreamReader openFile = new InputStreamReader(openFileInput(name));

            BufferedReader readFile = new BufferedReader(openFile);
            String line = readFile.readLine();
            String data = "";

            while ( line != null) {
                data = data + line + "\n";
                line = readFile.readLine();
            }
            readFile.close();
            openFile.close();
            et_data.setText(data);
        } catch (IOException e) {
            Toast.makeText(this, "Error reading file", Toast.LENGTH_SHORT).show();
        }
    }
}
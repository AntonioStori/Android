package com.chori.bitacora;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {
    private EditText et_data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_data = (EditText) findViewById(R.id.txt_bitacora);
        String files [] = fileList();

        if (fileExists(files, "bitacora.txt")){
            try {
                InputStreamReader file = new InputStreamReader(openFileInput("bitacora.txt"));
                BufferedReader br = new BufferedReader(file);
                String line = br.readLine();
                String bitacoraCompleta = "";

                while (line != null){
                    bitacoraCompleta = bitacoraCompleta + line + "\n";
                    line = br.readLine();
                }
                br.close();
                file.close();
                et_data.setText(bitacoraCompleta);
            } catch (IOException e) {

            }

        }
    }

    private boolean fileExists(String files [], String fileName){
        for(int i = 0; i < files.length; i++)
            if (fileName.equals(files[i]))
                return true;
            return false;
    }

    //Save Button Method
    public void Save(View view){
        try {
            OutputStreamWriter file = new OutputStreamWriter(openFileOutput("bitacora.txt", Activity.MODE_PRIVATE));
            file.write(et_data.getText().toString());
            file.flush(); 
            file.close();
        }catch (IOException e){

        }
        Toast.makeText(this, "Bitacora guardada correctamente", Toast.LENGTH_SHORT).show();
        finish();

    }
}
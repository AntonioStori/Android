package com.chori.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView tv_info;
    private ListView lv_names;

    private String names [] = {"Samuel", "Valentina", "Santiago", "Alejandro", "Valeria", "Benjamin", "Gerardo", "Carlos", "David", "Sofia"};
    private String ages [] = {"18", "25", "32", "17", "24", "20", "27", "15", "19", "23"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv_info = (TextView) findViewById(R.id.tv_info);
        lv_names = (ListView) findViewById(R.id.lv_names);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.listview_listview1, names);
        lv_names.setAdapter(adapter);

        lv_names.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                tv_info.setText("The " + lv_names.getItemAtPosition(i) +"'s ages is " + ages[i] + " years old.");
            }
        });
    }
}
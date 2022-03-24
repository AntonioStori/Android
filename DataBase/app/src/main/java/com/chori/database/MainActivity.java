package com.chori.database;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText et_code, et_description, et_price;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et_code = (EditText) findViewById(R.id.et_code);
        et_description = (EditText) findViewById(R.id.et_description);
        et_price = (EditText) findViewById(R.id.et_price);
    }

    // Register Button Method
    public void Register(View view){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "administration", null, 1);
        SQLiteDatabase DataBase = admin.getWritableDatabase();

        String code = et_code.getText().toString();
        String description = et_description.getText().toString();
        String price = et_price.getText().toString();

        if (!code.isEmpty() && !description.isEmpty() && !price.isEmpty()){
            ContentValues register = new ContentValues();
            register.put("code", code);
            register.put("description", description);
            register.put("price", price);

            DataBase.insert("articles", null, register);
            DataBase.close();
            et_code.setText("");
            et_description.setText("");
            et_price.setText("");

            Toast.makeText(this, "Register Successful", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "You must fill all the fields", Toast.LENGTH_SHORT).show();
        }
    }
    //Consult Button Method
    public void Search(View view){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "administration", null, 1);
        SQLiteDatabase DataBase = admin.getWritableDatabase();

        String code = et_code.getText().toString();

        if (!code.isEmpty()){
            Cursor row = DataBase.rawQuery
                    ("select description, price from articles where code =" + code, null);
            if (row.moveToFirst()) {
                et_description.setText(row.getString(0));
                et_price.setText(row.getString(1));
                DataBase.close();
            } else {
                Toast.makeText(this, "The article does not exist.", Toast.LENGTH_SHORT).show();
                DataBase.close();
            }
        }else{
            Toast.makeText(this, "You must provide the code.", Toast.LENGTH_SHORT).show();
        }
    }
    // Delete Button Method
    public void Delete(View view){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper
                (this, "administration", null, 1);
        SQLiteDatabase DataBase = admin.getWritableDatabase();
        String code = et_code.getText().toString();

        if (!code.isEmpty()){
            int quantity = DataBase.delete("articles", "code=" + code, null);
            DataBase.close();

            et_code.setText("");
            et_description.setText("");
            et_price.setText("");
            if ( quantity == 1){
                Toast.makeText(this, "Article deleted succesful", Toast.LENGTH_SHORT).show();

            } else {
                Toast.makeText(this, "The article does not exist.", Toast.LENGTH_SHORT).show();
                DataBase.close();
            }
        } else {
            Toast.makeText(this, "You must provide the code.", Toast.LENGTH_SHORT).show();
        }
    }
    //Modify Button Method
    public void Modify (View view) {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper
                (this, "administration", null, 1);
        SQLiteDatabase DataBase = admin.getWritableDatabase();

        String code = et_code.getText().toString();
        String description = et_description.getText().toString();
        String price = et_price.getText().toString();

        if (!code.isEmpty() && !description.isEmpty() && !price.isEmpty()){
            ContentValues register = new ContentValues();
            register.put("code", code);
            register.put("description", description);
            register.put("price", price);

            int quantity = DataBase.update("articles", register, "code=" + code, null);
            DataBase.close();

            if (quantity == 1){
                Toast.makeText(this, "Article modified successful", Toast.LENGTH_SHORT).show();

            } else {
                Toast.makeText(this, "The article does not exist.", Toast.LENGTH_SHORT).show();
            }

        } else {
            Toast.makeText(this, "You must fill all the fields", Toast.LENGTH_SHORT).show();
        }
    }

}
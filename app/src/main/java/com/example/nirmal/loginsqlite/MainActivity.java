package com.example.nirmal.loginsqlite;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText name,rollno,pass;
    Button button;
    String nameString;
    String rollString;
    String passString;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void register(View view){
        name = findViewById(R.id.editText);
        rollno = findViewById(R.id.editText2);
        pass = findViewById(R.id.editText3);
        if (name.getText().toString().trim().length() < 3){
            Toast.makeText(getApplicationContext(),"Min 3 Characters Name", Toast.LENGTH_SHORT).show();
        }
        else if (rollno.getText().toString().trim().length()!=6){
            Toast.makeText(getApplicationContext(),"6 Characters RollNo",Toast.LENGTH_LONG).show();
        }
        else if (pass.getText().toString().trim().length() < 6){
            Toast.makeText(getApplicationContext(),"Password 6 Letters Min",Toast.LENGTH_LONG).show();
        }
        else {
            nameString = name.getText().toString();
            rollString = rollno.getText().toString();
            passString = pass.getText().toString();
//            dbHandler.putData(nameString,rollString,passString);
            name.setText("");
            rollno.setText("");
            pass.setText("");
            Toast.makeText(getApplicationContext(),"Data Inserted",Toast.LENGTH_LONG).show();
        }
    }

    public void navigate(View view){
        Intent intent = new Intent(this,loginActivity.class);
        startActivity(intent);
    }
}

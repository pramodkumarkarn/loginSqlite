package com.example.nirmal.loginsqlite;

import android.content.ContentValues;
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
    databaseHelper databaseHelper;
    SQLiteDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = (EditText)findViewById(R.id.editText);
        rollno = (EditText)findViewById(R.id.editText2);
        pass = (EditText)findViewById(R.id.editText3);
        button = (Button)findViewById(R.id.button);
        databaseHelper = new databaseHelper(getApplicationContext());
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (name.getText().toString().trim().length() == 0){
                    Toast.makeText(getApplicationContext(), "Enter Your Name",Toast.LENGTH_SHORT).show();
                }
                else if (rollno.getText().toString().trim().length() == 0){
                    Toast.makeText(getApplicationContext(), "Enter Your Roll No.",Toast.LENGTH_SHORT).show();
                }
                else if (pass.getText().toString().trim().length() == 0){
                    Toast.makeText(getApplicationContext(), "Enter Your Password",Toast.LENGTH_SHORT).show();
                }
                else {
                    database = databaseHelper.getWritableDatabase();
                    String fname = name.getText().toString();
                    String roll = rollno.getText().toString();
                    String password = pass.getText().toString();
                }
            }
        });
    }

    public void navigate(View view){
        Intent intent = new Intent(this,loginActivity.class);
        startActivity(intent);
    }
}

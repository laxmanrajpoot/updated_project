package com.example.collageautomation2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class faculty_login extends AppCompatActivity {
Button sign_in;
EditText username,password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faculty_login);
         username = (EditText) findViewById(R.id.email);
         password = (EditText) findViewById(R.id.password);
         sign_in=(Button)findViewById(R.id.sign_in);
         sign_in.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Intent i=new Intent(faculty_login.this,faculty_dashboard.class);
                 startActivity(i);

             }
         });


        assert getSupportActionBar() != null;   //null check
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }






}

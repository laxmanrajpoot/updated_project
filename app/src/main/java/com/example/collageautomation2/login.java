package com.example.collageautomation2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class login extends AppCompatActivity {
Button sign_in;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        addListenerOnButton();
        assert getSupportActionBar() != null;   //null check
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }

    public void addListenerOnButton() {
        sign_in = (Button) findViewById(R.id.sign_in);
        final EditText username = (EditText) findViewById(R.id.email);
        final EditText password = (EditText) findViewById(R.id.password);
        sign_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if (username.getText().toString().equals("laxmanyaduvanshi2@gmail.com") && password.getText().toString().equals("1234")) {

                    Intent intent = new Intent(login.this, admin_dashboard.class);
                    startActivity(intent);
                } else if (username.getText().toString().equals("laxmanyaduvanshi2@gmail.com") && password.getText().toString().equals(null)) {
                    Toast.makeText(getApplicationContext(), "Enter password", Toast.LENGTH_SHORT).show();

                } else if (username.getText().toString().equals(null) && password.getText().toString().equals(null)) {
                    Toast.makeText(getApplicationContext(), "Enter id and password", Toast.LENGTH_SHORT).show();
                } else if (username.getText().toString().equals(null) && password.getText().toString().equals(null)) {
                    Toast.makeText(getApplicationContext(), "Enter email", Toast.LENGTH_SHORT).show();

                } else {

                    Toast.makeText(getApplicationContext(), "Invalid id and password", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }}
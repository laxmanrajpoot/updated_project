package com.example.collageautomation2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;


public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Spinner spinner=findViewById(R.id.user);
        ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(this,R.array.users,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) this);



    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        final Intent intent;
        switch (position) {
            case 0:
                intent = new Intent(this, login.class);
                startActivity(intent);
                break;
            case 1:
                intent = new Intent(MainActivity.this, faculty_login.class);
                startActivity(intent);
                break;
            case 2:
                intent = new Intent(MainActivity.this, student_login.class);
                startActivity(intent);
                break;


        }
    }

    private void startActivity(MainActivity mainActivity, Class<login> loginClass) {
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}

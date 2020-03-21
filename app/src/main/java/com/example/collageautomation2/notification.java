package com.example.collageautomation2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class notification extends AppCompatActivity {
TextView text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
        assert getSupportActionBar() != null;
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        text=(TextView) findViewById(R.id.text);
        Intent intent = getIntent();
        String str = intent.getStringExtra("message");
        text.setText(str);

    }
    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }
}

package com.example.collageautomation2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class send_notification extends AppCompatActivity {
FloatingActionButton share;
EditText write;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_notification);
        assert getSupportActionBar() != null;   //null check
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        share= (FloatingActionButton) findViewById(R.id.share);
        write=(EditText)findViewById(R.id.write);
        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = write.getText().toString();

                Intent intent = new Intent(getApplicationContext(), notification.class);
                intent.putExtra("message", str);

                startActivity(intent);
            }
        });
    }
    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }
}

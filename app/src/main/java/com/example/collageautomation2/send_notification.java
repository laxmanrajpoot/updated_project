package com.example.collageautomation2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class send_notification extends AppCompatActivity {
    FloatingActionButton share;
    EditText write;
    demo d;

    DatabaseReference rootRef;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_notification);
        assert getSupportActionBar() != null;   //null check
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        share= (FloatingActionButton) findViewById(R.id.share);
        write=(EditText)findViewById(R.id.write);
        d=new demo();
        rootRef = FirebaseDatabase.getInstance().getReference("demo");

        share.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                String notification =write.getText().toString().trim();
                d.setNotification(notification);
                rootRef.push().setValue(d);
                write.setText(null);
                Toast.makeText(send_notification.this, "send sucessfully", Toast.LENGTH_SHORT).show();


            }
        });
    }
    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }
}

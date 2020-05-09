package com.example.collageautomation2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class sendfeedback extends AppCompatActivity {
    EditText name,feedback;
    FloatingActionButton send;
    DatabaseReference rootRef;
    feedbacks f;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sendfeedback);
        assert getSupportActionBar() != null;   //null check
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        name=(EditText)findViewById(R.id.name1);
        feedback=(EditText)findViewById(R.id.feedback1);
        send=(FloatingActionButton)findViewById(R.id.send);
        f=new feedbacks();
        rootRef=FirebaseDatabase.getInstance().getReference().child("feedbacks");
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String n=name.getText().toString().trim();
                String feed = feedback.getText().toString().trim();
                f.setName(n);
                f.setFeedback(feed);
                rootRef.push().setValue(f);
                name.setText(null);
                feedback.setText(null);
                Toast.makeText(sendfeedback.this, "send sucessfully", Toast.LENGTH_SHORT).show();

            }
        });
    }


    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }
}

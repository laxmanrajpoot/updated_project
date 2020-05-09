package com.example.collageautomation2;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
public class notification extends AppCompatActivity {
    DatabaseReference ref;
    ArrayList<String>arr=new ArrayList<>();
    private ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
        assert getSupportActionBar() != null;
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        list = (ListView) findViewById(R.id.list);

        final ArrayAdapter<String> arrayadapter = new ArrayAdapter<String>(notification.this, android.R.layout.simple_list_item_1, arr);
        list.setAdapter(arrayadapter);
        ref = FirebaseDatabase.getInstance().getReference("demo");
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                arr.clear();
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    arr.add(snapshot.getValue().toString());
                }
                arrayadapter.notifyDataSetChanged();
            }


            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
    @Override
    public boolean onSupportNavigateUp () {
        finish();
        return true;
    }
}

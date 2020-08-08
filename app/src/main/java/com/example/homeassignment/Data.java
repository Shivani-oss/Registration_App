package com.example.homeassignment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Data extends AppCompatActivity {

    FirebaseDatabase database,database1;
    DatabaseReference reference,reference1;
    Button btn,btn1;
    TextView tv1,tv2,tv3,tv4,tv5,tv6;
    String id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);

        database = FirebaseDatabase.getInstance();
        reference = database.getReference("Student").child("Profile");
        reference1 = database.getReference("Student").child("Semester");

        Intent intent = getIntent();
        id = intent.getStringExtra("ID");

        tv1 = findViewById(R.id.tv1);
        tv2 = findViewById(R.id.tv2);
        tv3 = findViewById(R.id.tv3);
        tv4 = findViewById(R.id.tv4);
        tv5 = findViewById(R.id.tv5);
        tv6 = findViewById(R.id.tv6);
        btn = findViewById(R.id.btn);
        btn1 = findViewById(R.id.btn1);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reference.child(id).addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        DataSet2 dataSet = dataSnapshot.getValue(DataSet2.class);
                        tv1.setText("ID : " +dataSet.getId());
                        tv2.setText("Name : " +dataSet.getUsername());
                        tv3.setText("Date of Birth : "+ dataSet.getDob());
                        tv4.setText("Email-Id : "+dataSet.getMail());
                        tv5.setText("City : "+dataSet.getCity());
                        tv6.setText("Phone no : " +dataSet.getPhone_no());
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });


            }
        });
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reference1.child(id).addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        DataSet3 dataSet = dataSnapshot.getValue(DataSet3.class);
                        tv1.setText("ID : "+id);
                        tv2.setText("Branch : " +dataSet.getBranch());
                        tv3.setText("Semester : "+dataSet.getSem());
                        tv4.setText("Payment Status : "+ dataSet.getStatus());
                        tv5.setText("");
                        tv6.setText("");

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });


            }
        });




    }
}

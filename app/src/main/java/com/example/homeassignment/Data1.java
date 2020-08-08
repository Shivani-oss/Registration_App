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

public class Data1 extends AppCompatActivity {

    FirebaseDatabase database;
    DatabaseReference reference;
    Button btn;
    TextView tv1,tv2,tv3,tv4,tv5,tv6,tv7;
    String id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data1);

        database = FirebaseDatabase.getInstance();
        reference = database.getReference("Student").child("Fee");
        Intent intent = getIntent();
        id = intent.getStringExtra("ID");

        tv1 = findViewById(R.id.tv1);
        tv2 = findViewById(R.id.tv2);
        tv3 = findViewById(R.id.tv3);
        tv4 = findViewById(R.id.tv4);
        tv5 = findViewById(R.id.tv5);
        tv6 = findViewById(R.id.tv6);
        tv7 = findViewById(R.id.tv7);
        btn = findViewById(R.id.btn);



        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reference.child(id).addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        DataSet4 dataSet = dataSnapshot.getValue(DataSet4.class);
                        tv1.setText("Date : "+ dataSet.getDate());
                        tv2.setText("Account No : "+dataSet. getAccountno());
                        tv3.setText("Account Name : "+ dataSet.getAccountname());
                        tv4.setText("Amount : " + dataSet.getAmount());
                        tv5.setText("IFSC Code : "+ dataSet.getIfsc());
                        tv6.setText("Mode of Payment : "+dataSet.getMethod());
                        tv7.setText("Bankname : "+dataSet.getBankname());
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });


            }
        });
    }
}

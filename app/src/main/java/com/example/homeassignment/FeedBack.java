package com.example.homeassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class FeedBack extends AppCompatActivity {

    EditText et1,et2,et3;
    Button btn;
    private FirebaseDatabase mauth;
    private DatabaseReference mref;
    Member3 member3;
    String d;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed_back);

        et1 = findViewById(R.id.et1);
        et2 = findViewById(R.id.et2);
        et3 = findViewById(R.id.et3);
        btn = findViewById(R.id.btn);



        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                mauth = FirebaseDatabase.getInstance();
                mref = mauth.getReference("Student");

                String year = et1.getText().toString().trim();
                String name = et2.getText().toString().trim();
                String feedback = et3.getText().toString().trim();

                d = year;

                if (year.trim().equalsIgnoreCase("")) {
                    et1.setError("This field can not be blank");
                }
                else if(name.trim().equalsIgnoreCase("")){
                    et2.setError("This field can not be blank");
                }
                else if(feedback.trim().equalsIgnoreCase("")){
                    et3.setError("This field can not be blank");
                }
                else{
                    member3 = new Member3(year, name, feedback);
                    mref.child("FeedBack").child(d).setValue(member3);
                    Toast.makeText(FeedBack.this,"Sucessfully Submited",Toast.LENGTH_LONG).show();
                }

            }
        });


    }
}

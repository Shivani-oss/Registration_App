package com.example.homeassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class FProfile extends AppCompatActivity {

    Button btn;
    String b,name;
    EditText et1,et2,et3,et4,et5,et6;
    private FirebaseDatabase mauth;
    private DatabaseReference mref;
    private static final String DATE_PATTERN = "^[0-3]?[0-9]/[0-3]?[0-9]/(?:[0-9]{2})?[0-9]{2}$";
    Member4 member4;
    String mobile_no = "[0-9]{10}";
    static Profile INSTANCE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_f_profile);

        btn = findViewById(R.id.btn);
        et1 = findViewById(R.id.et1);
        et2 = findViewById(R.id.et2);
        et3 = findViewById(R.id.et3);
        et4 = findViewById(R.id.et4);
        et5 = findViewById(R.id.et5);
        et6 = findViewById(R.id.et6);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mauth = FirebaseDatabase.getInstance();
                mref = mauth.getReference("Faculty");

                String username = et1.getText().toString().trim();
                String dob = et2.getText().toString().trim();
                String designation = et3.getText().toString().trim();
                String branch = et4.getText().toString().trim();
                String phone = et5.getText().toString().trim();
                String state = et6.getText().toString().trim();
                b = branch;
                name = username;

                if (username.trim().equalsIgnoreCase("")) {
                    et1.setError("This field can not be blank");
                }
                else if(dob.trim().equalsIgnoreCase("")){
                    et2.setError("This field can not be blank");
                }
                else if (!dob.trim().matches(DATE_PATTERN)) {
                    et2.setError("Invalid Format");
                }
                else if(designation.trim().equalsIgnoreCase("")){
                    et3.setError("This field can not be blank");
                }
                else if(branch.trim().equalsIgnoreCase("")){
                    et4.setError("This field can not be blank");
                }
                else if(state.trim().equalsIgnoreCase("")){
                    et6.setError("This field can not be blank");
                }
                else if(phone.trim().equalsIgnoreCase("")){
                    et5.setError("This field can not be blank");
                }
                else if (!phone.trim().matches(mobile_no)) {
                    et6.setError("Invalid Phone.No ");
                }
                else{
                    member4 = new Member4(username,dob,designation,branch,phone,state);
                    mref.child("Profile").child(b).child(name).setValue(member4);
                    Toast.makeText(FProfile.this, "Submitted Sucessfully", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
    public static Profile getActivityInstance()
    {
        return INSTANCE;
    }

    public String getData()
    {
        return this.b;
    }

}

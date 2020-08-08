package com.example.homeassignment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Profile extends AppCompatActivity {

    TextInputLayout et1,et2,et3,et4,et5,et6;
    Button btn;
    String id,roll;
    private FirebaseDatabase mauth;
    private DatabaseReference mref;
    Member member;
    private static final String DATE_PATTERN = "^[0-3]?[0-9]/[0-3]?[0-9]/(?:[0-9]{2})?[0-9]{2}$";
    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    String mobile_no = "[0-9]{10}";
    static Profile INSTANCE;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        INSTANCE=this;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        et1 = findViewById(R.id.text_input_enrolmentid);
        et2 = findViewById(R.id.text_input_username);
        et3 = findViewById(R.id.text_input_date_of_birth);
        et4 = findViewById(R.id.text_input_mail);
        et5 = findViewById(R.id.text_input_city);
        et6 = findViewById(R.id.text_input_phoneno);
        btn = findViewById(R.id.btn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mauth = FirebaseDatabase.getInstance();
                mref = mauth.getReference("Student");

                //Get all the values
                id = et1.getEditText().getText().toString();
                roll = id;
                String name = et2.getEditText().getText().toString();
                String dob = et3.getEditText().getText().toString();
                String mail = et4.getEditText().getText().toString();
                String city = et5.getEditText().getText().toString();
                String phone = et6.getEditText().getText().toString();



                if (id.trim().equalsIgnoreCase("")) {
                    et1.setError("ID Required");
                } else if (id.trim().length() != 10) {
                    et1.setError("Invalid ID");
                } else if (name.trim().equalsIgnoreCase("")) {
                    et2.setError("Name Required");
                } else if (dob.trim().equalsIgnoreCase("")) {
                    et3.setError("DOB Required");
                } else if (!dob.trim().matches(DATE_PATTERN)) {
                    et3.setError("Invalid Format");
                } else if (mail.trim().equalsIgnoreCase("")) {
                    et4.setError("Email Required");
                }  else if (!mail.trim().matches(emailPattern)) {
                    et4.setError("Invalid E-mail");
                } else if (city.trim().equalsIgnoreCase("")) {
                    et5.setError("City and State Required");
                } else if (phone.trim().equalsIgnoreCase("")) {
                    et6.setError("Phone No Required");
                } else if (!phone.trim().matches(mobile_no)) {
                    et6.setError("Invalid Phone.No ");
                } else {
                    member = new Member(id, name,dob, mail, city, phone);
                    mref.child("Profile").child(roll).setValue(member);
                    Toast.makeText(Profile.this, "Submitted Sucessfully", Toast.LENGTH_SHORT).show();
                    et1.getEditText().setText("");
                    et2.getEditText().setText("");
                    et3.getEditText().setText("");
                    et4.getEditText().setText("");
                    et5.getEditText().setText("");
                    et6.getEditText().setText("");
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
        return this.roll;
    }

}

//    private void getValues(){
//
//        member.setUsername(et1.getEditText().getText().toString().trim());
//        member.setDob(et2.getEditText().getText().toString().trim());
//        member.setCity(et3.getEditText().getText().toString().trim());
//        member.setAddress(et4.getEditText().getText().toString().trim());
//        member.setId(et5.getEditText().getText().toString().trim());
//        member.setPhone_no(et6.getEditText().getText().toString().trim());
//        mref.push().setValue(member);
//
//
//  }
//
//
//    public void btnInsert(View view){
//        mref.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                getValues();
//                mref.child("User01").setValue(member);
//                Toast.makeText(Profile.this, "Submitted Sucessfully", Toast.LENGTH_SHORT).show();
//
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError databaseError) {
//
//            }
//        });
//
//
//
//    }










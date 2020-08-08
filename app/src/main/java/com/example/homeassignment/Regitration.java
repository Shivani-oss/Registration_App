package com.example.homeassignment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Regitration extends AppCompatActivity {

    EditText etEmail, etPass, etName, etConPass;
    Button btnlogin,btn1;
    FirebaseAuth mauthfirebase;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    RadioButton rd1,rd2;
    String option;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regitration);

        etEmail = findViewById(R.id.etEmail);
        etPass = findViewById(R.id.etPass);
        etName = findViewById(R.id.etName);
        mauthfirebase = FirebaseAuth.getInstance();
        etConPass = findViewById(R.id.etConPass);
        btnlogin = findViewById(R.id.btnReg);
        rd1 = findViewById(R.id.radio1);
        rd2 = findViewById(R.id.radio2);
        btn1 = findViewById(R.id.btn1);

        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("Registration");

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Regitration.this, MainActivity.class));
            }
        });

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String email, pass, name, conpass;


                option ="null";
                email = etEmail.getText().toString();
                pass = etPass.getText().toString();
                name = etName.getText().toString();
                conpass = etConPass.getText().toString();



                if (rd1.isChecked()){
                    option ="Teacher";
                }
                if (rd2.isChecked()){
                    option ="Student";
                }
                if (name.equals("")) {
                    Toast.makeText(Regitration.this, "Name Required", Toast.LENGTH_SHORT).show();
                } else if (pass.equals("")) {
                    Toast.makeText(Regitration.this, "Password Required", Toast.LENGTH_SHORT).show();
                } else if (email.equals("")) {
                    Toast.makeText(Regitration.this, "Email Required", Toast.LENGTH_SHORT).show();
                } else if (conpass.equals("")) {
                    Toast.makeText(Regitration.this, "Password Required", Toast.LENGTH_SHORT).show();
                }

                mauthfirebase.createUserWithEmailAndPassword(email, pass)
                        .addOnCompleteListener(Regitration.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    DatabaseHelper information = new DatabaseHelper(
                                            name,
                                            email,
                                            option
                                    );
                                    FirebaseDatabase.getInstance().getReference("Registration")
                                            .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                            .setValue(information).addOnCompleteListener(new OnCompleteListener<Void>() {
                                        @Override
                                        public void onComplete(@NonNull Task<Void> task) {
                                            Toast.makeText(Regitration.this, "Register Sucessfully", Toast.LENGTH_SHORT).show();
                                            Intent i = new Intent(Regitration.this, MainActivity.class);
                                            startActivity(i);
                                            finish();
                                        }
                                    });
                                } else {

                                }

                            }
                        });
            }
        });


    }

}


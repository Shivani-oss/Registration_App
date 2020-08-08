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
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {


    EditText etEmail,etPass;
    Button btnlogin;
    TextView tvReg;
    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    private FirebaseAuth.AuthStateListener mauthListner;
    FirebaseAuth mauthfirebase;
    RadioButton rd1,rd2;
    String option;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etEmail = findViewById(R.id.etEmail);
        etPass = findViewById(R.id.etPass);
        mauthfirebase = FirebaseAuth.getInstance();
        btnlogin = findViewById(R.id.btnlogin);
        tvReg = findViewById(R.id.tvReg);
        rd1 = findViewById(R.id.radio1);
        rd2 = findViewById(R.id.radio2);

        mauthListner = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser mFirebaseUser = mauthfirebase.getCurrentUser();
                if(mFirebaseUser != null) {

                }
            }
        };
        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email,pass;
                int c;
                email = etEmail.getText().toString();
                pass = etPass.getText().toString();

                if (!(rd1.isChecked() ||rd2.isChecked())){
                    Toast.makeText(MainActivity.this,"Occupation Required",Toast.LENGTH_SHORT).show();
                }
                if(email.equals("")){
                    Toast.makeText(MainActivity.this,"Email Required",Toast.LENGTH_SHORT).show();
                }
                else if(!email.matches(emailPattern)) {
                    Toast.makeText(MainActivity.this,"Invalid Email Format",Toast.LENGTH_SHORT).show();
                }
                else if (pass.equals("")){
                    Toast.makeText(MainActivity.this,"Password Required",Toast.LENGTH_SHORT).show();
                }
                else if(!(email.isEmpty() && pass.isEmpty()) && rd2.isChecked()){
                    mauthfirebase.signInWithEmailAndPassword(email,pass).addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(!task.isSuccessful()){
                                Toast.makeText(MainActivity.this,"Login Error",Toast.LENGTH_SHORT).show();
                            }
                            else {
                                Intent i = new Intent(MainActivity.this,MenuBar.class);
                                startActivity(i);
                                finish();

                            }
                        }
                    });
                }
                else if(!(email.isEmpty() && pass.isEmpty()) && rd1.isChecked()){
                    mauthfirebase.signInWithEmailAndPassword(email,pass).addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(!task.isSuccessful()){
                                Toast.makeText(MainActivity.this,"Login Error",Toast.LENGTH_SHORT).show();
                            }
                            else {
                                Intent i = new Intent(MainActivity.this,MenuBar1.class);
                                startActivity(i);
                                finish();

                            }
                        }
                    });
                }
                else{
                    Toast.makeText(MainActivity.this,"Error Occured!",Toast.LENGTH_SHORT).show();
                }
            }
        });

        tvReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,Regitration.class);
                startActivity(i);
                finish();
            }
        });

    }
    protected void onStart() {
        super.onStart();
        mauthfirebase.addAuthStateListener(mauthListner);
    }
}


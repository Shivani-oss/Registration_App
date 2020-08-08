package com.example.homeassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Semester extends AppCompatActivity {

    RadioButton rd,rd1,rd2,rd3;
    Spinner spin;
    Button btn,btn1,btn2;
    String option, option1;
    Integer sem,index;
    private FirebaseDatabase mauth;
    private DatabaseReference mref;
    Member1 member1;
    String roll;
    static Semester INSTANCE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_semester);

        INSTANCE=this;
        rd = findViewById(R.id.radioButton);
        rd1 = findViewById(R.id.radioButton1);
        rd2 = findViewById(R.id.radioButton2);
        rd3 = findViewById(R.id.radioButton3);
        spin = findViewById(R.id.spin);
        String[] array = getResources().getStringArray(R.array.semester);
        btn = findViewById(R.id.btn);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);


        final Integer[] intArray = new Integer[array.length];
        for(int i = 0; i < array.length; i++) {
            intArray[i] = Integer.parseInt(array[i]);
        }
        ArrayAdapter<Integer> adapter = new ArrayAdapter<Integer>(Semester.this, android.R.layout.simple_spinner_dropdown_item, intArray);
        spin.setAdapter(adapter);
        spin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                index = spin.getSelectedItemPosition();
                sem = intArray[index];
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(rd.isChecked() && !rd1.isChecked()){
                    startActivity(new Intent(Semester.this, CSE.class));
                }

                else if(rd1.isChecked() && rd.isChecked()){
                    Toast.makeText(Semester.this, "Both Branch Selected", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(Semester.this, "CSE not Selected", Toast.LENGTH_SHORT).show();
                }

            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(rd1.isChecked() && !rd.isChecked()){
                    startActivity(new Intent(Semester.this, ECE.class));
                }
                else if(rd1.isChecked() && rd.isChecked()){
                    Toast.makeText(Semester.this, "Both Branch Selected", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(Semester.this, "ECE not Selected", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                roll = Profile.getActivityInstance().getData();
                mauth = FirebaseDatabase.getInstance();
                mref = mauth.getReference("Student");

                if(rd.isChecked())
                {
                    option="CSE";
                }
                if(rd1.isChecked())
                {
                    option="ECE";
                }
                if(rd2.isChecked())
                {
                    option1="Paid";
                }
                if(rd3.isChecked())
                {
                    option1="Unpaid";
                }
                if( option == null  ){
                    Toast.makeText(Semester.this, "Branch is not Selected", Toast.LENGTH_SHORT).show();

                }
                else if(rd2.isChecked() && rd3.isChecked()){
                    Toast.makeText(Semester.this, "Invalid Payment Status", Toast.LENGTH_SHORT).show();
                }
                else if(option1 == null ){
                    Toast.makeText(Semester.this, "Payment status not Selected", Toast.LENGTH_SHORT).show();
                }
                else if(roll == null ){
                    Toast.makeText(Semester.this,"Fill Profile Section",Toast.LENGTH_LONG).show();
                }
                else{
                    member1 = new Member1(option, option1,sem);
                    mref.child("Semester").child(roll).setValue(member1);
                    Toast.makeText(Semester.this, "Submitted Sucessfully", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }

    public static Semester getActivityInstance()
    {
        return INSTANCE;
    }

    public Integer getData()
    {
        return this.sem;
    }


}

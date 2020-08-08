package com.example.homeassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.homeassignment.ui.semester.SemesterFragment;

public class CSE extends AppCompatActivity {

    RadioButton rd1,rd2,rd3,rd4,rd5,rd6;
    Button btn;
    Integer sem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c_s_e);

        rd1 = findViewById(R.id.radioButton4);
        rd2 = findViewById(R.id.radioButton5);
        rd3 = findViewById(R.id.radioButton6);
        rd4 = findViewById(R.id.radioButton7);
        rd5 = findViewById(R.id.radioButton8);
        rd6 = findViewById(R.id.radioButton9);
        btn = findViewById(R.id.btn);

        sem = Semester.getActivityInstance().getData();

        if(sem == 1){
            rd1.setText("Mathematics-I ");
            rd2.setText("Elements of Electrical\n" +
                    "Engineering ");
            rd3.setText("Applied Sciences");
            rd4.setText("Computer Programming D");
            rd5.setText("Electronics Device and Circuits");
            rd6.setText("Environmental Studies H");
        }
        if(sem == 2){
            rd1.setText("Data Structure");
            rd2.setText("Application Programming");
            rd3.setText("Mathematics-II");
            rd4.setText("Digital Electronics");
            rd5.setText("Communication Skills");
            rd6.setText("Mechanics & Graphics ");
        }
        if(sem == 3){
            rd1.setText("Mathematics-III");
            rd2.setText("Introduction to Object\n" +
                    "Oriented Programming");
            rd3.setText("Computer System\n" +
                    "Organization");
            rd4.setText("Data Structures with\n" +
                    "Applications");
            rd5.setText("IT Workshop-I ");
            rd6.setText("Microprocessors &\n" +
                    "Interfacing ");
        }
        if(sem == 4){
            rd1.setText("Software Engineering");
            rd2.setText("Design and Analysis of\n" +
                    "Algorithms");
            rd3.setText("Operating Systems ");
            rd4.setText("Design Principles of\n" +
                    "Programming Languages ");
            rd5.setText("Discrete Maths and Graph\n" +
                    "Theory ");
            rd6.setText("IT Workshop-II");
        }
        if(sem == 5){
            rd1.setText("Database Management\n" +
                    "Systems ");
            rd2.setText("Open Course - I");
            rd3.setText("Computer Networks");
            rd4.setText("Theory of Computation");
            rd5.setText("Elective-1");
            rd6.setVisibility(View.INVISIBLE);
        }
        if(sem == 6){
            rd1.setText("Compilers");
            rd2.setText("Cryptography and Network\n" +
                    "Security");
            rd3.setText("Open course-I");
            rd4.setText("Elective-II");
            rd5.setText("Elective –III");
            rd6.setVisibility(View.INVISIBLE);
        }


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    if(!(rd1.isChecked() || rd2.isChecked() || rd3.isChecked() || rd4.isChecked() ||  rd5.isChecked() ||  rd6.isChecked() )){
                        Toast.makeText(CSE.this, "Courses not Selected", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        Toast.makeText(CSE.this, "Succesfully Selected", Toast.LENGTH_SHORT).show();
                    }
            }
        });





    }
}

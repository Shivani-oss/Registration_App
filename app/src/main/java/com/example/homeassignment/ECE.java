package com.example.homeassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.homeassignment.ui.semester.SemesterFragment;

public class ECE extends AppCompatActivity {

    RadioButton rd1,rd2,rd3,rd4,rd5,rd6,rd7,rd8,rd9,rd10;
    Button btn;
    Integer sem;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_e_c_e);

        rd1 = findViewById(R.id.radioButton4);
        rd2 = findViewById(R.id.radioButton5);
        rd3 = findViewById(R.id.radioButton6);
        rd4 = findViewById(R.id.radioButton7);
        rd5 = findViewById(R.id.radioButton8);
        rd6 = findViewById(R.id.radioButton9);

        btn = findViewById(R.id.btn);

        sem = Semester.getActivityInstance().getData();

        if(sem == 1){
            rd1.setText("\n" +
                    "Mathematics-I\n");
            rd2.setText("\n" +
                    "Elements of Electrical Engineering\n");
            rd3.setText("\n" +
                    "Mechanics & Graphics\n");
            rd4.setText("\n" +
                    "Computer Programming\n");
            rd5.setText("\n" +
                    "Electronic Devices and Circuits\n");
            rd6.setText("\n" +
                    "Communication Skills\n");
        }
        if(sem == 2){
            rd1.setText("  Mathematics-II");
            rd2.setText(" Applied Sciences");
            rd3.setText(" Digital Electronics");
            rd4.setText("  Environmental Studies");
            rd5.setText("  Application Programming");
            rd6.setText("  Data Structures");

        }
        if(sem == 3){
            rd1.setText(" Numerical Methods & Probability Theory");
            rd2.setText("  Signals and Systems");
            rd3.setText("   Microprocessors & Interfacing");
            rd4.setText("   Analog ICs");
            rd5.setText("  Network Theory");
            rd6.setText("   IT Workshop- I\n");
        }

        if(sem == 4){
            rd1.setText("   Digital Signal Processing");
            rd2.setText("  Hardware description languages");
            rd3.setText("  Control Systems");
            rd4.setText("  Electromagnetics");
            rd5.setText("  Computer Architecture & Organisation");
            rd6.setText("  IT Workshop- II");
        }
        if(sem == 5){
            rd1.setText(" Analog and Digital Communication Systems");
            rd2.setText("  Waveguides & Antennas");
            rd3.setText(" Embedded Systems");
            rd4.setText(" Electronic  Instrumentation");
            rd5.setText("  Open Course - I");
            rd6.setVisibility(View.INVISIBLE);
        }


        if(sem == 6){
            rd1.setText(" Wireless Communication");
            rd2.setText(" CMOS Design");
            rd3.setText(" Open Course - II");
            rd4.setText(" Elective -  I");
            rd5.setText(" Elective – II\n");
            rd6.setVisibility(View.INVISIBLE);
        }



        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!(rd1.isChecked() || rd2.isChecked() || rd3.isChecked() || rd4.isChecked() ||  rd5.isChecked() ||  rd6.isChecked())){
                    Toast.makeText(ECE.this, "Courses not Selected", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(ECE.this, "Succesfully Selected", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}

package com.example.homeassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Fee extends AppCompatActivity {

    Button btn;
    EditText et1,et2,et3,et4,et5,et6;
    Spinner spin;
    String method;
    private FirebaseDatabase mauth;
    private DatabaseReference mref;
    Member2 member2;
    String roll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fee);
        btn = findViewById(R.id.button);
        et1 = findViewById(R.id.edt1);
        et2 = findViewById(R.id.edt2);
        et3 = findViewById(R.id.edt3);
        et4 = findViewById(R.id.edt4);
        et5 = findViewById(R.id.edt5);
        et6 = findViewById(R.id.edt6);
        spin = findViewById(R.id.spin);



        final String[] array = getResources().getStringArray(R.array.payment);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(Fee.this, android.R.layout.simple_spinner_dropdown_item, array);
        spin.setAdapter(adapter);
        spin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                int index = spin.getSelectedItemPosition();
                method = array[index];
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                roll = Profile.getActivityInstance().getData();

                mauth = FirebaseDatabase.getInstance();
                mref = mauth.getReference("Student");

                String amount = et1.getText().toString().trim();
                String accountno = et2.getText().toString().trim();
                String accountname = et3.getText().toString().trim();
                String date = et4.getText().toString().trim();
                String bankname = et5.getText().toString().trim();
                String ifsc = et6.getText().toString().trim();

                if (amount.trim().equalsIgnoreCase("")) {
                    et1.setError("This field can not be blank");
                }
                else if(accountno.trim().equalsIgnoreCase("")){
                    et2.setError("This field can not be blank");
                }
                else if(accountname.trim().equalsIgnoreCase("")){
                    et3.setError("This field can not be blank");
                }
                else if(date.trim().equalsIgnoreCase("")){
                    et4.setError("This field can not be blank");
                }
                else if(bankname.trim().equalsIgnoreCase("")){
                    et5.setError("This field can not be blank");
                }
                else if(ifsc.trim().equalsIgnoreCase("")){
                    et6.setError("This field can not be blank");
                }
                else if(roll == null){
                    Toast.makeText(Fee.this,"Fill Profile Section",Toast.LENGTH_LONG).show();
                }
                else{
                    member2 = new Member2( amount, accountno,accountname,date,bankname,ifsc,method);
                    mref.child("Fee").child(roll).setValue(member2);
                    Toast.makeText(Fee.this, "Submitted Sucessfully", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }

}

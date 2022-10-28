package com.dasnee.medmanager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddMedActivity extends AppCompatActivity {

    Context context;
    EditText medNameET;
    EditText medDoseET;

    Button saveButton;
    Button nextButton;

    Med med;

    String medName;
    String medDose;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_med);

        context = getApplicationContext();

        MedViewModel medViewModel = new ViewModelProvider(this).get(MedViewModel.class);

        medNameET = findViewById(R.id.medNameET);
        medDoseET = findViewById(R.id.medDoseET);

        nextButton = findViewById(R.id.nextButton);

        saveButton = findViewById(R.id.saveButton);
        saveButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (medNameET.getText() == null) {
                    // Name EditText content is null
                    //TODO
                } else {
                    if (TextUtils.isEmpty(medNameET.getText().toString())) {
                        //Empty Med Name is not allowed
                        String msg = "Please enter the name";
                        int duration = Toast.LENGTH_SHORT;
                        Toast toast = Toast.makeText(context, msg, duration);
                        toast.show();

                    } else {
                        medName = medNameET.getText().toString();
                        med = new Med(medName);

                        if (medDoseET.getText() == null) {
                            //TODO
                        } else {
                            medDose = medDoseET.getText().toString();
                            med.setMedDose(medDose);
                        }

                        medViewModel.addMed(med);

                        Intent intent = new Intent(AddMedActivity.this, MainActivity.class);
                        startActivity(intent);
                    }
                }
            }
        });




    }

    protected void onResume() {
        super.onResume();
    }
}
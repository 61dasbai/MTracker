package com.dasnee.medmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddMedActivity extends AppCompatActivity {

    EditText medNameET;
    EditText medDoseET;

    Button saveButton;

    String medName;
    String medDose;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_med);

        medNameET = findViewById(R.id.medNameET);
        medDoseET = findViewById(R.id.medDoseET);

        saveButton.findViewById(R.id.saveButtom);
        saveButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (medNameET.getText() == null) {
                    // Name EditText content is null
                    //TODO
                } else {
                    if (TextUtils.isEmpty(medNameET.getText().toString())) {
                        //Empty Med Name is not allowed
                        //TODO
                    } else {
                        medName = medNameET.getText().toString();
                    }
                }

                if (medDoseET.getText() == null) {
                    //TODO
                } else {
                    medDose = medDoseET.getText().toString();
                }
            }
        });


    }
}
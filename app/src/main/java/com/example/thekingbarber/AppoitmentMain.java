package com.example.thekingbarber;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.preference.EditTextPreference;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

import java.util.Calendar;

public class AppoitmentMain extends AppCompatActivity {
    Button bfecha,bhora;
    public static EditText efecha;
    public static EditText ehora;
    private int dia,mes,ano,hora,minutos;
    private Button buttonNext;
    private Button buttonBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appoitment_main);
        bfecha=findViewById(R.id.buttonDay);
        bhora=findViewById(R.id.buttonHour);
        efecha=findViewById(R.id.editTextDay);
        ehora=findViewById(R.id.editTextHour);

        bfecha.setOnClickListener(v -> {
            DialogFragment newFragment = new ClassData.DatePickerFragment();
            newFragment.show(getSupportFragmentManager(), "datePicker");
        });

        bhora.setOnClickListener(v -> {
            DialogFragment newFragment = new ClassHour.TimePickerFragment();
            newFragment.show(getSupportFragmentManager(), "timePicker");
        });

        buttonNext=findViewById(R.id.buttonNext);
        buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ButtonNext1();
            }
        });

        buttonBack=findViewById(R.id.buttonBack);
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ButtonBack1();
            }
        });

    }

    public void ButtonNext1(){
        Intent buttonnext = new Intent(this,AppoitmentMain2.class );
        startActivity(buttonnext);
    }

    public void ButtonBack1(){
        Intent buttonback = new Intent(this,MainActivity.class );
        startActivity(buttonback);
    }


}
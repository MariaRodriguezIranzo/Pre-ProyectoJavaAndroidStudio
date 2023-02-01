package com.example.thekingbarber;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class AppoitmentMain2 extends AppCompatActivity {
    private Button buttonSend;
    private Button buttonExit;
    private TextView editTexName;
    private Spinner genderA;
    private CheckBox checkBoxWash;
    private CheckBox checkBoxCutAndHairstyle;
    private CheckBox checkBoxHairstyle;
    private CheckBox checkBoxDye;
    private CheckBox checkBoxPermanent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appoitment_main2);

        buttonSend=findViewById(R.id.buttonSend);
       buttonSend.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
             buttonSend1();
           }
       });

        editTexName=findViewById(R.id.editTexName);
        genderA=findViewById(R.id.spinnerGender);
        checkBoxWash=findViewById(R.id.checkBoxWash);
        checkBoxCutAndHairstyle=findViewById(R.id.checkBoxCutAndHairstyle);
        checkBoxHairstyle=findViewById(R.id.checkBoxHairstyle);
        checkBoxDye=findViewById(R.id.checkBoxDye);
        checkBoxPermanent=findViewById(R.id.checkBoxPermanent);
        //spiner
        String[] genderValue = {"Women", "Men", "Kids"};
        genderA.setAdapter(new ArrayAdapter<String>(this, com.google.android.material.R.layout.support_simple_spinner_dropdown_item, genderValue));
        //hora y fecha actual
        final Calendar c= Calendar.getInstance();

        //botones
        buttonExit=findViewById(R.id.buttonExit);
        buttonExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonExit1();
            }
        });

    }
    public void buttonSend1(){
        Context context = getApplicationContext();
        CharSequence text = "Your appointment has been accepted !";
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
        Toast.makeText(context, text, duration).show();

        String date =AppoitmentMain.efecha.getText().toString();
        String hour =AppoitmentMain.ehora.getText().toString();
        String name= editTexName.getText().toString();
        String genderAdd= genderA.getSelectedItem().toString();
        int cBoxWashValue = checkBoxWash.isChecked() ? 1 : 0;
        int cBoxHaircutValue = checkBoxCutAndHairstyle.isChecked() ? 1 : 0;
        int cBoxHairStyleValue = checkBoxHairstyle.isChecked() ? 1 : 0;
        int cBoxDyeValue = checkBoxDye.isChecked() ? 1 : 0;
        int cBoxPermanentValue = checkBoxPermanent.isChecked() ? 1 : 0;

        if (genderA.equals("Kids")) cBoxPermanentValue = 0;

        Function_CalltoPHP_FILE(date, hour, name, genderAdd, cBoxWashValue, cBoxHaircutValue, cBoxHairStyleValue, cBoxDyeValue, cBoxPermanentValue);


    }

    public void buttonExit1(){
        Intent buttonExit = new Intent(this,MainActivity.class );
        startActivity(buttonExit);
    }

    private void Function_CalltoPHP_FILE( String date, String hour, String name, String genderAdd, int cBoxWashValue,int cBoxHaircutValue,int cBoxHairStyleValue, int cBoxDyeValue, int cBoxPermanentValue) {
        String query = "";
        query += "?Control=" + "CreateAppointmentAndroid";
        query += "&D01=" + date;
        query += "&D02=" + hour;
        query += "&D03=" + name;
        query += "&D04=" + genderAdd;
        query += "&D05=" + cBoxWashValue;
        query += "&D06=" + cBoxHaircutValue;
        query += "&D07=" + cBoxHairStyleValue;
        query += "&D08=" + cBoxDyeValue;
        query += "&D09=" + cBoxPermanentValue;
        String link = "http://192.168.56.1:80/M13/P1/controllerDB.php"+query;
        new CRUD().execute(link);

    }
}
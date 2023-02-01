package com.example.thekingbarber;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    button=findViewById(R.id.buttonAppotment);
    button.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            buttonAppointment();
        }
    });
    }
    public void buttonAppointment(){
        Intent buttonappointment = new Intent(this,AppoitmentMain.class );
        startActivity(buttonappointment);
    }
    public void maps(View view) {
        Intent mapsIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://goo.gl/maps/nNeqYY24hF5vRsWM8"));
        startActivity(mapsIntent);

    }

}
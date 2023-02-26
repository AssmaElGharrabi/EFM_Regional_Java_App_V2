package com.example.efm_regional_java_v2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText edittext1, edittext2;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edittext1 = findViewById(R.id.edittext1);
        edittext2 = findViewById(R.id.edittext2);
        button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this , "Votre BMI est : "+ calculeBMI() +" , Votre état est : " + etat(),Toast.LENGTH_LONG).show();
            }
        });
    }

    public double calculeBMI(){
        double Weight = Double.parseDouble(edittext1.getText().toString());
        double Height = Double.parseDouble(edittext2.getText().toString());

        double BMI = (Weight/(703*Height*Height));
        return  BMI ;
    }

    public String etat(){
        String etat = "";
        if(calculeBMI()<18.5){etat = "Underweight";}
        else if(calculeBMI()>=18.5 && calculeBMI()<25){etat = "Normal";}
        else if(calculeBMI()<40 && calculeBMI()>=25){etat = "Overweight";}
        else if(calculeBMI()>=40 ){etat = "Obese";}

        return etat;
    }
}
package com.example.unitconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity3 extends AppCompatActivity {
    EditText e1;
    Button b1;
    Spinner s1,s2;
    Double result,amount;
    TextView t1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        e1=findViewById(R.id.e2);
        b1=findViewById(R.id.button5);
        s1=findViewById(R.id.spinner5);
        s2=findViewById(R.id.spinner6);
        t1=findViewById(R.id.textView3);
        String[]Units1={"Grams","Kilograms"};
        ArrayAdapter<String> ad=new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line,Units1);
        s1.setAdapter(ad);
        String[]Units2={"Kilograms","Grams"};
        ArrayAdapter<String> ad1=new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line,Units2);
        s2.setAdapter(ad1);
        b1.setOnClickListener(view -> {

            if(TextUtils.isEmpty(e1.getText().toString()))
            {
                Toast toast=Toast.makeText(getApplicationContext(),"Please enter the quantity",Toast.LENGTH_SHORT);
                toast.show();
            }
            else if(s1.getSelectedItem().toString().equals("Kilograms")&&s2.getSelectedItem().toString().equals("Grams"))
            {
                amount=Double.parseDouble(e1.getText().toString());
                result=amount*1000;
                t1.setText(Double.toString(result));
            }
            else if(s1.getSelectedItem().toString().equals("Grams")&&s2.getSelectedItem().toString().equals("Kilograms"))
            {
                amount=Double.parseDouble(e1.getText().toString());
                result=amount/1000;
                t1.setText(Double.toString(result));
            }
            else if(s1.getSelectedItem().toString().equals("Kilograms")&&s2.getSelectedItem().toString().equals("Kilograms"))
            {
                Toast toast=Toast.makeText(getApplicationContext(),"Source and destination currencies must be different",Toast.LENGTH_SHORT);
                toast.show();
            }
            else if(s1.getSelectedItem().toString().equals("Grams")&&s2.getSelectedItem().toString().equals("Grams"))
            {
                Toast toast=Toast.makeText(getApplicationContext(),"Source and destination currencies must be different",Toast.LENGTH_SHORT);
                toast.show();
            }
        });

    }
}
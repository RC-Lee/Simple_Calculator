package com.example.map524_a1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    TextView output_field;
    Button btn_num1, btn_num2, btn_num3, btn_num4, btn_num5, btn_num6, btn_num7, btn_num8, btn_num9, btn_num0;
    Button btn_plus, btn_minus, btn_multiply, btn_divide, btn_calculate, btn_clear;
    Button btn_mod, btn_pow, btn_max, btn_min;
    Button btn_mode;

    Calculator c1 = new Calculator();
    Boolean calculated = false;
    String outputText = "";

    LinearLayout scientific;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("Assignment 1", "on create");

        output_field = findViewById(R.id.output_field);
        scientific = (LinearLayout)findViewById(R.id.scientific);

        btn_num1 = findViewById(R.id.btn_num1);
        btn_num1.setOnClickListener(this);
        btn_num2 = findViewById(R.id.btn_num2);
        btn_num2.setOnClickListener(this);
        btn_num3 = findViewById(R.id.btn_num3);
        btn_num3.setOnClickListener(this);
        btn_num4 = findViewById(R.id.btn_num4);
        btn_num4.setOnClickListener(this);
        btn_num5 = findViewById(R.id.btn_num5);
        btn_num5.setOnClickListener(this);
        btn_num6 = findViewById(R.id.btn_num6);
        btn_num6.setOnClickListener(this);
        btn_num7 = findViewById(R.id.btn_num7);
        btn_num7.setOnClickListener(this);
        btn_num8 = findViewById(R.id.btn_num8);
        btn_num8.setOnClickListener(this);
        btn_num9 = findViewById(R.id.btn_num9);
        btn_num9.setOnClickListener(this);
        btn_num0 = findViewById(R.id.btn_num0);
        btn_num0.setOnClickListener(this);
        btn_plus = findViewById(R.id.btn_plus);
        btn_plus.setOnClickListener(this);
        btn_minus = findViewById(R.id.btn_minus);
        btn_minus.setOnClickListener(this);
        btn_multiply = findViewById(R.id.btn_multiply);
        btn_multiply.setOnClickListener(this);
        btn_divide = findViewById(R.id.btn_divide);
        btn_divide.setOnClickListener(this);
        btn_calculate = findViewById(R.id.btn_calculate);
        btn_calculate.setOnClickListener(this);
        btn_clear = findViewById(R.id.btn_clear);
        btn_clear.setOnClickListener(this);
        btn_mode = findViewById(R.id.btn_mode);
        btn_mode.setOnClickListener(this);
        btn_mode.setText(R.string.btn_mode_text2);
        btn_mod = findViewById(R.id.btn_mod);
        btn_mod.setOnClickListener(this);
        btn_pow= findViewById(R.id.btn_pow);
        btn_pow.setOnClickListener(this);
        btn_max= findViewById(R.id.btn_max);
        btn_max.setOnClickListener(this);
        btn_min = findViewById(R.id.btn_min);
        btn_min.setOnClickListener(this);
    }

    @Override
    public void onStart() {
        super.onStart();
        scientific.setVisibility(View.GONE);
        Log.d("Assignment 1", "on start");
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();

        // Clear the field
        if(calculated && id != R.id.btn_calculate && id != R.id.btn_mode){
            c1.inputs.clear();
            outputText = "";
            calculated = false;
        }
        if(id == R.id.btn_clear){
            c1.inputs.clear();
            outputText = "";
        }

        // Digits
        if(id == R.id.btn_num0){
            c1.push("0");
            outputText += "0 ";
        }
        if(id == R.id.btn_num1){
            c1.push("1");
            outputText += "1 ";
        }
        if(id == R.id.btn_num2){
            c1.push("2");
            outputText += "2 ";
        }
        if(id == R.id.btn_num3){
            c1.push("3");
            outputText += "3 ";
        }
        if(id == R.id.btn_num4){
            c1.push("4");
            outputText += "4 ";
        }
        if(id == R.id.btn_num5){
            c1.push("5");
            outputText += "5 ";
        }
        if(id == R.id.btn_num6){
            c1.push("6");
            outputText += "6 ";
        }
        if(id == R.id.btn_num7){
            c1.push("7");
            outputText += "7 ";
        }
        if(id == R.id.btn_num8){
            c1.push("8");
            outputText += "8 ";
        }
        if(id == R.id.btn_num9){
            c1.push("9");
            outputText += "9 ";
        }

        // Operators
        if(id == R.id.btn_plus){
            c1.push("+");
            outputText += "+ ";
        }
        if(id == R.id.btn_minus){
            c1.push("-");
            outputText += "- ";
        }
        if(id == R.id.btn_multiply){
            c1.push("*");
            outputText += "* ";
        }
        if(id == R.id.btn_divide){
            c1.push("/");
            outputText += "/ ";
        }
        if(id == R.id.btn_mod){
            c1.push("%");
            outputText += "% ";
        }
        if(id == R.id.btn_pow){
            c1.push("POW");
            outputText += "POW ";
        }
        if(id == R.id.btn_max){
            c1.push("MAX");
            outputText += "MAX ";
        }
        if(id == R.id.btn_min){
            c1.push("MIN");
            outputText += "MIN ";
        }
        if(id == R.id.btn_calculate && !calculated){
            outputText += "= ";
            int result = c1.calculate();
            if(result == -999999){
               outputText += "Not an Operator";
            }
            else if (result == -999998){
                outputText += "Cannot Divide by Zero";
            }
            else{
                outputText += result;
            }
            calculated = true;
        }

        // Mode
        if(id == R.id.btn_mode){
            if(btn_mode.getText().toString().equals("Standard")){
                btn_mode.setText(R.string.btn_mode_text2);
                scientific.setVisibility(View.GONE);
                Toast.makeText(this, "Switched to Standard", Toast.LENGTH_SHORT).show();
            }
            else{
                btn_mode.setText(R.string.btn_mode_text1);
                scientific.setVisibility(View.VISIBLE);
                Toast.makeText(this, "Switched to Scientific", Toast.LENGTH_SHORT).show();
            }
        }

        output_field.setText(outputText);
    }
}
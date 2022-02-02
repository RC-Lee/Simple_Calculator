package com.example.map524_a1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    TextView output_field;
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
        scientific = findViewById(R.id.scientific);
        scientific.setVisibility(View.GONE);

        findViewById(R.id.btn_num1).setOnClickListener(this);
        findViewById(R.id.btn_num2).setOnClickListener(this);
        findViewById(R.id.btn_num3).setOnClickListener(this);
        findViewById(R.id.btn_num4).setOnClickListener(this);
        findViewById(R.id.btn_num5).setOnClickListener(this);
        findViewById(R.id.btn_num6).setOnClickListener(this);
        findViewById(R.id.btn_num7).setOnClickListener(this);
        findViewById(R.id.btn_num8).setOnClickListener(this);
        findViewById(R.id.btn_num9).setOnClickListener(this);
        findViewById(R.id.btn_num0).setOnClickListener(this);
        findViewById(R.id.btn_plus).setOnClickListener(this);
        findViewById(R.id.btn_minus).setOnClickListener(this);
        findViewById(R.id.btn_multiply).setOnClickListener(this);
        findViewById(R.id.btn_divide).setOnClickListener(this);
        findViewById(R.id.btn_calculate).setOnClickListener(this);
        findViewById(R.id.btn_clear).setOnClickListener(this);
        findViewById(R.id.btn_mod).setOnClickListener(this);
        findViewById(R.id.btn_pow).setOnClickListener(this);
        findViewById(R.id.btn_max).setOnClickListener(this);
        findViewById(R.id.btn_min).setOnClickListener(this);

        btn_mode = findViewById(R.id.btn_mode);
        btn_mode.setOnClickListener(this);
        btn_mode.setText(R.string.btn_mode_text2);
    }

    @Override
    public void onClick(View view) {
        String text = ((Button)view).getText().toString();

        switch (text){
            case "c":
                c1.inputs.clear();
                outputText = "";
                calculated = false;
                break;
            case "=":
                if(!calculated){
                    outputText += text + " ";
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
                break;
            case "standard":
                btn_mode.setText(R.string.btn_mode_text2);
                scientific.setVisibility(View.GONE);
                break;
            case "advance - scientific":
                btn_mode.setText(R.string.btn_mode_text1);
                scientific.setVisibility(View.VISIBLE);
                break;
            default:
                if(calculated){
                    c1.inputs.clear();
                    outputText = "";
                    calculated = false;
                }
                c1.push(text);
                outputText += text + " ";
        }

        output_field.setText(outputText);
    }
}
package com.example.cal_x;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.text.BreakIterator;

public class CalculatorActivity extends AppCompatActivity implements View.OnClickListener{

    private enum OPERATOR{
        ADD, SUBTRACT, MULTIPLY, DIVIDE, EQUAL
    }

    private TextView textViewShowCalculations, textViewResults;

    //Instance variables
    private String currentString, stringNumberAtLeft, stringNumberAtRight;
    private OPERATOR currentOperator;
    private int calculationsResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        textViewShowCalculations = findViewById(R.id.textViewShowCalculations);
        textViewResults = findViewById(R.id.textViewResults);

        findViewById(R.id.imageButton7).setOnClickListener(CalculatorActivity.this);
        findViewById(R.id.imageButton8).setOnClickListener(CalculatorActivity.this);
        findViewById(R.id.imageButton9).setOnClickListener(CalculatorActivity.this);
        findViewById(R.id.imageButton4).setOnClickListener(CalculatorActivity.this);
        findViewById(R.id.imageButton5).setOnClickListener(CalculatorActivity.this);
        findViewById(R.id.imageButton6).setOnClickListener(CalculatorActivity.this);
        findViewById(R.id.imageButton1).setOnClickListener(CalculatorActivity.this);
        findViewById(R.id.imageButton2).setOnClickListener(CalculatorActivity.this);
        findViewById(R.id.imageButton3).setOnClickListener(CalculatorActivity.this);
        findViewById(R.id.imageButton0).setOnClickListener(CalculatorActivity.this);
        findViewById(R.id.imageButtonClear).setOnClickListener(CalculatorActivity.this);
        findViewById(R.id.imageButtonDecimal).setOnClickListener(CalculatorActivity.this);
        findViewById(R.id.imageButtonEqual).setOnClickListener(CalculatorActivity.this);
        findViewById(R.id.imageButtonAddition).setOnClickListener(CalculatorActivity.this);
        findViewById(R.id.imageButtonSubtraction).setOnClickListener(CalculatorActivity.this);
        findViewById(R.id.imageButtonMultiplication).setOnClickListener(CalculatorActivity.this);
        findViewById(R.id.imageButtonDivision).setOnClickListener(CalculatorActivity.this);

    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.imageButton7:
                break;
            case R.id.imageButton8:
                break;
            case  R.id.imageButton9:
                break;
            case R.id.imageButton4:
                break;
            case R.id.imageButton5:
                break;
            case R.id.imageButton6:
                break;
            case  R.id.imageButton1:
                break;
            case R.id.imageButton2:
                break;
            case R.id.imageButton3:
                break;
            case R.id.imageButton0:
                break;
            case R.id.imageButtonClear:
                break;
            case R.id.imageButtonDecimal:
                break;
            case R.id.imageButtonEqual:
                break;
            case R.id.imageButtonAddition:
                break;
            case R.id.imageButtonSubtraction:
                break;
            case R.id.imageButtonMultiplication:
                break;
            case R.id.imageButtonDivision:
                break;

        }

    }
}

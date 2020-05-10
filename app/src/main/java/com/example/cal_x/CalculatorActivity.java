package com.example.cal_x;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import java.text.BreakIterator;

public class CalculatorActivity extends AppCompatActivity implements View.OnClickListener{

    private Toolbar customToolbar;

    private enum OPERATOR{
        ADD, SUBTRACT, MULTIPLY, DIVIDE, EQUAL
    }


    private TextView textViewShowCalculations, textViewResults;

    //Instance variables
    private String currentNumber, stringNumberAtLeft, stringNumberAtRight;
    private OPERATOR currentOperator;
    private double calculationsResult;
    private String calculationsString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        customToolbar = findViewById(R.id.customToolbar);
        setSupportActionBar(customToolbar);

        currentNumber = "";
        calculationsResult = 0.0;
        calculationsString = "";

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
        findViewById(R.id.imageButtonEqual).setOnClickListener(CalculatorActivity.this);
        findViewById(R.id.imageButtonAddition).setOnClickListener(CalculatorActivity.this);
        findViewById(R.id.imageButtonSubtraction).setOnClickListener(CalculatorActivity.this);
        findViewById(R.id.imageButtonMultiplication).setOnClickListener(CalculatorActivity.this);
        findViewById(R.id.imageButtonDivision).setOnClickListener(CalculatorActivity.this);


    }
    //custom menu in app bar
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case R.id.action_info:
                Intent intent = new Intent(CalculatorActivity.this, About.class);
                startActivity(intent);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.imageButton7:
                numberIsTapped(7);
                break;
            case R.id.imageButton8:
                numberIsTapped(8);
                break;
            case  R.id.imageButton9:
                numberIsTapped(9);
                break;
            case R.id.imageButton4:
                numberIsTapped(4);
                break;
            case R.id.imageButton5:
                numberIsTapped(5);
                break;
            case R.id.imageButton6:
                numberIsTapped(6);
                break;
            case  R.id.imageButton1:
                numberIsTapped(1);
                break;
            case R.id.imageButton2:
                numberIsTapped(2);
                break;
            case R.id.imageButton3:
                numberIsTapped(3);
                break;
            case R.id.imageButton0:
                numberIsTapped(0);
                break;
            case R.id.imageButtonClear:
                clearTapped();
                break;
            case R.id.imageButtonEqual:
                operatorIsTapped(OPERATOR.EQUAL);
                break;
            case R.id.imageButtonAddition:
                operatorIsTapped(OPERATOR.ADD);
                calculationsString+= " + ";
                break;
            case R.id.imageButtonSubtraction:
                operatorIsTapped(OPERATOR.SUBTRACT);
                calculationsString += " - ";
                break;
            case R.id.imageButtonMultiplication:
                operatorIsTapped(OPERATOR.MULTIPLY);
                calculationsString += " x ";
                break;
            case R.id.imageButtonDivision:
                operatorIsTapped(OPERATOR.DIVIDE);
                calculationsString += " / ";
                break;

        }
        textViewShowCalculations.setText(calculationsString);

    }
    private  void numberIsTapped(int tappedNumber){
        currentNumber = currentNumber + String.valueOf(tappedNumber);
        textViewResults.setText(currentNumber);
        calculationsString = currentNumber;
        textViewShowCalculations.setText(calculationsString);
    }

    private void operatorIsTapped(OPERATOR tappedOperator){
        if (currentOperator != null ) {
            if (currentNumber != "") {
                stringNumberAtRight = currentNumber;
                currentNumber = "";

                switch (currentOperator) {
                    case ADD:
                        calculationsResult = Double.parseDouble(stringNumberAtLeft) +
                                Double.parseDouble(stringNumberAtRight);
                        break;

                    case SUBTRACT:
                        calculationsResult = Double.parseDouble(stringNumberAtLeft) -
                                Double.parseDouble(stringNumberAtRight);
                        break;

                    case MULTIPLY:
                        calculationsResult = Double.parseDouble(stringNumberAtLeft) *
                                Double.parseDouble(stringNumberAtRight);
                        break;

                    case DIVIDE:
                        calculationsResult = Double.parseDouble(stringNumberAtLeft) / Double.parseDouble(stringNumberAtRight);
                        break;

                    case EQUAL:
                        break;


                }
                stringNumberAtLeft = String.valueOf(calculationsResult);
                textViewResults.setText(stringNumberAtLeft);
                calculationsString = stringNumberAtLeft;
            }
        }
        else {
            stringNumberAtLeft= currentNumber;
            currentNumber = "";
        }
        currentOperator = tappedOperator;
    }
    private void clearTapped(){
        stringNumberAtLeft = "";
        stringNumberAtRight = "";
        calculationsResult = 0.0;
        currentNumber ="";
        currentOperator = null;
        calculationsString = "0";
        textViewResults.setText("0");
    }
}

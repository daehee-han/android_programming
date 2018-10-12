package com.example.daehee.myfirstapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void clickOfAddBtn(View v) {
        EditText num1 = (EditText) findViewById(R.id.num1);
        EditText num2 = (EditText) findViewById(R.id.num2);
        TextView calcResult = (TextView) findViewById(R.id.calcResult);
        int n1 = Integer.parseInt(num1.getText().toString());
        int n2 = Integer.parseInt(num2.getText().toString());
        calcResult.setText(Integer.toString(n1 + n2));
    }

    public void clickOfMinusBtn(View v) {
        EditText num1 = (EditText) findViewById(R.id.num1);
        EditText num2 = (EditText) findViewById(R.id.num2);
        TextView calcResult = (TextView) findViewById(R.id.calcResult);
        int n1 = Integer.parseInt(num1.getText().toString());
        int n2 = Integer.parseInt(num2.getText().toString());
        calcResult.setText(Integer.toString(n1 - n2));
    }

    public void clickOfMultiplyBtn(View v) {
        EditText num1 = (EditText) findViewById(R.id.num1);
        EditText num2 = (EditText) findViewById(R.id.num2);
        TextView calcResult = (TextView) findViewById(R.id.calcResult);
        int n1 = Integer.parseInt(num1.getText().toString());
        int n2 = Integer.parseInt(num2.getText().toString());
        calcResult.setText(Integer.toString(n1 * n2));
    }

    public void clickOfDivideBtn(View v) {
        EditText num1 = (EditText) findViewById(R.id.num1);
        EditText num2 = (EditText) findViewById(R.id.num2);
        TextView calcResult = (TextView) findViewById(R.id.calcResult);
        int n1 = Integer.parseInt(num1.getText().toString());
        int n2 = Integer.parseInt(num2.getText().toString());
        calcResult.setText(Integer.toString(n1 / n2));
    }
}

package com.vvvital.calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    String operation = "";
    String resultString = "";
    double result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void onClick(View view) {
        Button button = (Button) view;
        operation = operation.concat(button.getText().toString());
        view();
    }

    public void onClickEquals(View view) {
        operation = operation.replaceAll(",", ".");
        String[] operand = operation.split("[*\\-/+]");
        String operator = operation.replaceAll("[0-9=.]", "");
        double number1 = Double.parseDouble(operand[0]);
        double number2 = Double.parseDouble(operand[1]);
        switch (operator) {
            case "*": {
                result = number1 * number2;
                break;
            }
            case "-": {
                result = number1 - number2;
                break;
            }
            case "+": {
                result = number1 + number2;
                break;
            }
            case "/":
                result = number1 / number2;
                break;
        }
        if (result == (int) result) {
            resultString = "=" + (int) result;
        } else {
            resultString = "=" + result;
        }
        view();
        operation = resultString.replace("=", "").trim();
        resultString = "";


    }

    public void onClickBack(View view) {
        if (operation.length() > 0) {
            operation = operation.substring(0, operation.length() - 1);
        }
        view();
    }

    public void onClickReset(View view) {
        operation = "";
        resultString = "";
        result = 0;
        view();
    }

    public void view() {
        TextView textView = findViewById(R.id.console);
        textView.setText(operation + resultString);
    }

}
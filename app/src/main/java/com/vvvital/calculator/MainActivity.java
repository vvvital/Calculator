package com.vvvital.calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    String operation = "";
    String resultString = "";
    int result;

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
        String[] operand = operation.split("[*\\-/+]");
        System.out.println(operand[0]);
        System.out.println(operand[1]);
        String operator = operation.replaceAll("[0-9=]", "");
        System.out.println(operator);
        int number1 = Integer.parseInt(operand[0]);
        int number2 = Integer.parseInt(operand[1]);
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
        resultString = "=" + result;
        view();
        operation=resultString.replace("=","").trim();
        resultString="";


    }

    public void onClickBack(View view) {
        if (operation.length() > 0) {
            operation = operation.substring(0, operation.length() - 1);
        }
        view();
    }
    public void onClickReset(View view){
        operation="";
        resultString="";
        result=0;
        view();
    }

    public void view() {
        TextView textView = findViewById(R.id.console);
        textView.setText(operation + resultString);
    }

}
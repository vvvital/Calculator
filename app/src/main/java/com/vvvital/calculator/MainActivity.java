package com.vvvital.calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    String operation="";

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


    public void onClickBack(View view){
        if (operation.length()>0) {
            operation = operation.substring(0, operation.length() - 1);
        }
        view();
    }

    public void view() {
        TextView textView = findViewById(R.id.console);
        textView.setText(operation);
    }

}
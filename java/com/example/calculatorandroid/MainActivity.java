package com.example.calculatorandroid;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText numberOneEditText, numberTwoEditText;
    TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // XML layout dosyasındaki elemanları bağlama
        numberOneEditText = findViewById(R.id.numberOneEditText);
        numberTwoEditText = findViewById(R.id.numberTwoEditText);
        resultTextView = findViewById(R.id.resultTextView);

        Button additionButton = findViewById(R.id.additionButton);
        Button subtractionButton = findViewById(R.id.subtractionButton);
        Button multiplicationButton = findViewById(R.id.multiplicationButton);
        Button divisionButton = findViewById(R.id.divisionButton);

        // Toplama işlemi
        additionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateResult('+');
            }
        });

        // Çıkarma işlemi
        subtractionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateResult('-');
            }
        });

        // Çarpma işlemi
        multiplicationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateResult('*');
            }
        });

        // Bölme işlemi
        divisionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateResult('/');
            }
        });
    }

    private void calculateResult(char operator) {
        // Kullanıcının girdiği sayıları al
        double num1 = Double.parseDouble(numberOneEditText.getText().toString());
        double num2 = Double.parseDouble(numberTwoEditText.getText().toString());

        // İşlem sonucunu hesapla
        double result = 0;

        switch (operator) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                if (num2 != 0) {
                    result = num1 / num2;
                } else {
                    resultTextView.setText("Error: Cannot divide by zero");
                    return;
                }
                break;
        }

        // Sonucu ekrana yazdır
        resultTextView.setText("Result: " + result);
    }
}

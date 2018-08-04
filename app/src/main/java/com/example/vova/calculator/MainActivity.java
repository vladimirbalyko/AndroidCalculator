package com.example.vova.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    Double result = 0.0;
    String displayValue = "";
    CalculatorAction action = CalculatorAction.NONE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText editResult = (EditText)findViewById(R.id.editResult);

        final Button btnRevert = findViewById(R.id.btnPlusMinus);
        btnRevert.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                MathAction action = new MathAction();
                editResult.setText(action.revert(Double.parseDouble(editResult.getText().toString())).toString());
            }
        });

        final Button btnPlus = findViewById(R.id.btnPlus);
        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                OnActionButtonClick(view, CalculatorAction.PLUS);
            }
        });

        final Button btnMinus = findViewById(R.id.btnMinus);
        btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                OnActionButtonClick(view, CalculatorAction.MINUS);
            }
        });

        final Button btnDivide = findViewById(R.id.btnDivide);
        btnDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                OnActionButtonClick(view, CalculatorAction.DIVIDE);
            }
        });

        final Button btnMultiplication = findViewById(R.id.btnMultiplication);
        btnMultiplication.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                OnActionButtonClick(view, CalculatorAction.MULTIPLICATION);
            }
        });

        final Button btnEqual = findViewById(R.id.btnEqual);
        btnEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                OnActionButtonClick(view, CalculatorAction.EQUAL);
            }
        });

        final Button btnPoint = findViewById(R.id.btnPoint);
        btnPoint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!displayValue.contains(".")) {
                    displayValue += ".";
                }
                editResult.setText(displayValue);
            }
        });

        final Button btnBack = findViewById(R.id.btnBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(displayValue != null && !displayValue.isEmpty()) {
                    displayValue = displayValue.substring(0, displayValue.length() - 1);
                }
                if (displayValue.isEmpty()) {
                    displayValue = "0";
                }
                editResult.setText(displayValue);
            }
        });

        final Button btnClear = findViewById(R.id.btnClear);
        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                displayValue = "";
                editResult.setText("0");
                result = 0.0;
                action = CalculatorAction.NONE;
            }
        });

        final Button btnSqrt = findViewById(R.id.btnSqrt);
        btnSqrt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MathAction mathAction = new MathAction();
                final EditText editResult = (EditText)findViewById(R.id.editResult);
                String current = editResult.getText().toString();
                result = mathAction.sqrt(Double.parseDouble(current));
                editResult.setText(result.toString());
            }
        });
    }

    public void OnNumberButtonClick(View view) {
        final EditText editResult = (EditText)findViewById(R.id.editResult);
        String btnText = ((Button) view).getText().toString();

        if (this.displayValue.equals("0")) {
            this.displayValue = "";
        }

        this.displayValue += btnText;
        editResult.setText(displayValue);
    }

    public void OnActionButtonClick(View view, CalculatorAction action) {
        final EditText editResult = (EditText)findViewById(R.id.editResult);
        String current = editResult.getText().toString();
        MathAction mathAction = new MathAction();

        switch (this.action){
            case NONE:
            case EQUAL:
                this.result = Double.parseDouble(current);
                this.displayValue = "";
                editResult.setText("0");
                break;
            case PLUS:
                this.result = mathAction.plus(
                        this.result,
                        Double.parseDouble(this.displayValue.isEmpty() ? "0" : this.displayValue));
                this.displayValue = "";
                editResult.setText(this.result.toString());
                break;
            case MINUS:
                this.result = mathAction.minus(
                        this.result,
                        Double.parseDouble(this.displayValue.isEmpty() ? "0" : this.displayValue));
                this.displayValue = "";
                editResult.setText(this.result.toString());
                break;
            case DIVIDE:
                this.result = mathAction.divide(
                        this.result,
                        Double.parseDouble(this.displayValue.isEmpty() ? "0" : this.displayValue));
                this.displayValue = "";
                editResult.setText(this.result.toString());
                break;
            case MULTIPLICATION:
                this.result = mathAction.multiplication(
                        this.result,
                        Double.parseDouble(this.displayValue.isEmpty() ? "0" : this.displayValue));
                this.displayValue = "";
                editResult.setText(this.result.toString());
                break;
        }
        this.action = action;

    }
}

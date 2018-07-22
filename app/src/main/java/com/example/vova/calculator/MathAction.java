package com.example.vova.calculator;

public class MathAction {
    public Double plus(double a, double b) {
        return a + b;
    }

    public Double minus(double a, double b) {
        return a - b;
    }

    public Double divide(double a, double b) {
        return a / b;
    }

    public Double multiplication(double a, double b) {
        return a * b;
    }

    public Double revert(double a) {
        return -a;
    }

    public Double clear() {
        return 0.0;
    }

    public String backSpace(double a) {
        String text = Double.toString(a);
        if (text.length() > 0) {
            return text.substring(0, text.length() - 1);
        }
        return text;
    }
}

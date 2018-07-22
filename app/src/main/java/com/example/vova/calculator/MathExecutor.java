package com.example.vova.calculator;

import java.math.BigDecimal;

public class MathExecutor implements IMathExecutor {
    private BigDecimal result;
    private String displayValue;

    public MathExecutor() {
        this.result = new BigDecimal("0.0");
        this.displayValue = "";
    }
}
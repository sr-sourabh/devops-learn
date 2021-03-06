package com.iiitb.devopscalc.core;

import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
public class RequestDto implements Serializable {
    private int number;
    private int base;
    private int operation;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getOperation() {
        return operation;
    }

    public void setOperation(int operation) {
        this.operation = operation;
    }

    public int getBase() {
        return base;
    }

    public void setBase(int base) {
        this.base = base;
    }
}

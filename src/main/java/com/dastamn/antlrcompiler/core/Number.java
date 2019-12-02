package com.dastamn.antlrcompiler.core;

import com.dastamn.antlrcompiler.util.Logger;

public class Number {

    private float value;
    private String type;

    public Number(float value, String type) {
        this.value = value;
        this.type = type;
    }

    public float getValue() {
        return value;
    }

    public String getType() {
        return type;
    }

    public Number plus(Number number) {
        if (number.type.equals("floatcompil")) {
            this.type = "floatcompil";
        }
        this.value += number.value;
        return this;
    }

    public Number minus(Number number) {
        if (number.type.equals("floatcompil")) {
            this.type = "floatcompil";
        }
        this.value -= number.value;
        return this;
    }

    public Number times(Number number) {
        if (number.type.equals("floatcompil")) {
            this.type = "floatcompil";
        }
        this.value *= number.value;
        return this;
    }

    public Number div(Number number) {
        if (number.type.equals("floatcompil")) {
            this.type = "floatcompil";
        }
        if (number.value == 0) {
            Logger.error("Can't divide by zero.");
        }
        this.value /= number.value;
        return this;
    }

    public Number neg() {
        this.value = -this.value;
        return this;
    }

    @Override
    public String toString() {
        return "{value: " + value + ", type: " + type + "}";
    }
}

package com.dastamn.antlrcompiler.core;

import com.dastamn.antlrcompiler.util.Logger;

public class Number {

    private float value;

    public Number(float value) {
        this.value = value;
    }

    int asInt() {
        return (int) value;
    }

    void setValue(float value) {
        this.value = value;
    }

    public float getValue() {
        return value;
    }

    Number castToInt() {
        this.value = (int) value;
        return this;
    }

    public Number plus(Number number) {
        this.value += number.value;
        return this;
    }

    public Number minus(Number number) {
        this.value -= number.value;
        return this;
    }

    public Number times(Number number) {
        this.value *= number.value;
        return this;
    }

    public Number div(Number number) {
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
        return String.valueOf(value);
    }
}

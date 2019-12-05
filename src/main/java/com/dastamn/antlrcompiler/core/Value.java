package com.dastamn.antlrcompiler.core;

import com.dastamn.antlrcompiler.util.Logger;

public class Value {

    private Object value;

    Value() {
        this.value = null;
    }

    public Value(Object value) {
        this.value = value;
    }

    void setValue(Object value) {
        this.value = value;
    }

    private Integer asInt() {
        if (value instanceof String) {
            Logger.error("Can't cast a string to a number type.");
        }
        return ((Float) value).intValue();
    }

    private Float asFloat() {
        if (value instanceof String) {
            Logger.error("Can't cast a string to a number type.");
        }
        return value instanceof Integer ? ((Integer) value).floatValue() : (Float) value;
    }

    Value castToInt() {
        this.value = asInt();
        return this;
    }

    public String asString() {
        return String.valueOf(value);
    }

    public boolean isString() {
        return value instanceof String;
    }

    public Value times(Value value) {
        this.value = asFloat() * value.asFloat();
        return this;
    }

    public Value div(Value value) {
        this.value = asFloat() / value.asFloat();
        return this;
    }

    public Value plus(Value value) {
        this.value = asFloat() + value.asFloat();
        return this;
    }

    public Value minus(Value value) {
        this.value = asFloat() - value.asFloat();
        return this;
    }

    public Value neg() {
        value = -asFloat();
        return this;
    }

    public boolean gt(Value value) {
        return asFloat() > value.asFloat();
    }

    public boolean gte(Value value) {
        return asFloat() >= value.asFloat();
    }

    public boolean lt(Value value) {
        return asFloat() < value.asFloat();
    }

    public boolean lte(Value value) {
        return asFloat() <= value.asFloat();
    }

    public boolean eq(Value value) {
        return asFloat().equals(value.asFloat());
    }

    public boolean notEq(Value value) {
        return !asFloat().equals(value.asFloat());
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}

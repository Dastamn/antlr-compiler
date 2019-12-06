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

    Type getType() {
        return value instanceof String ? Type.STRING_SJ : value instanceof Float ? Type.FLOAT_SJ : Type.INT_SJ;
    }

    public boolean isString() {
        return value instanceof String;
    }

    public Value times(Value value) {
        if (isString() || value.isString()) Logger.noStringInArithm();
        return new Value(asFloat() * value.asFloat());
    }

    public Value div(Value value) {
        if (isString() || value.isString()) Logger.noStringInArithm();
        Float floatValue = value.asFloat();
        if (floatValue == 0) {
            Logger.error("Can't divide by zero.");
        }
        return new Value(asFloat() / value.asFloat());
    }

    public Value plus(Value value) {
        if (isString() || value.isString()) Logger.noStringInArithm();
        return new Value(asFloat() + value.asFloat());
    }

    public Value minus(Value value) {
        if (isString() || value.isString()) Logger.noStringInArithm();
        return new Value(asFloat() - value.asFloat());
    }

    public Value neg() {
        if (isString()) Logger.noStringInArithm();
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
        return value == null ? "null" : String.valueOf(value);
    }
}

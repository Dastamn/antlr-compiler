package com.dastamn.antlrcompiler.entities;
import com.dastamn.antlrcompiler.Logger;

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

    public Object getRaw() {
        return value;
    }

    private Integer asInt() {
        return value instanceof Integer ? (Integer) value : ((Float) value).intValue();
    }

    private Float asFloat() {
        return value instanceof Integer ? ((Integer) value).floatValue() : (Float) value;
    }

    private boolean isFloat() {
        return value instanceof Float;
    }

    public boolean isString() {
        return value instanceof String;
    }

    Value castToInt() {
        this.value = asInt();
        return this;
    }

    Type getType() {
        return value instanceof String ? Type.STRING_SJ : value instanceof Float ? Type.FLOAT_SJ : Type.INT_SJ;
    }

    public Value times(Value value) {
        if (isString() || value.isString()) Logger.noStringInArithm();
        return new Value((isFloat() ? asFloat() : asInt()) * (value.isFloat() ? value.asFloat() : value.asInt()));
    }

    public Value div(Value value) {
        if (isString() || value.isString()) Logger.noStringInArithm();
        Float floatValue = value.asFloat();
        if (floatValue == 0) {
            Logger.error("Math error: can't divide by zero");
        }
        return new Value((isFloat() ? asFloat() : asInt()) / (value.isFloat() ? value.asFloat() : value.asInt()));
    }

    public Value plus(Value value) {
        return new Value(isString() || value.isString() ? toString() + value.toString() :
                (isFloat() ? asFloat() : asInt()) + (value.isFloat() ? value.asFloat() : value.asInt()));
    }

    public Value minus(Value value) {
        if (isString() || value.isString()) Logger.noStringInArithm();
        return new Value((isFloat() ? asFloat() : asInt()) - (value.isFloat() ? value.asFloat() : value.asInt()));
    }

    public Value neg() {
        if (isString()) Logger.noStringInArithm();
        value = -(isFloat() ? asFloat() : asInt());
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

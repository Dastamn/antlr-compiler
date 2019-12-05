package com.dastamn.antlrcompiler.core;

import com.dastamn.antlrcompiler.util.Logger;

public class STElement {

    private Value value;
    private String type;

    public Value getValue() {
        return value;
    }

    public String getType() {
        return type;
    }

    public <T> void setValue(T value) {
        if (this.value == null) this.value = new Value();
        if (value instanceof Float) {
            this.value.setValue(type.equals("int_SJ") ? ((Float) value).intValue() : value);
        } else {
            this.value.setValue(value);
        }
    }

    public void setValue(Value value) {
        if (type.equals("string_SJ") && !value.isString()) {
            Logger.error("Can't assign a number type to a string.");
        } else if (!type.equals("string_SJ") && value.isString()) {
            Logger.error("Can't assign a string type to a number.");
        } else {
            this.value = type.equals("int_SJ") ? value.castToInt() : value;
        }
    }

    public STElement setType(String type) {
        this.type = type;
        return this;
    }

    @Override
    public String toString() {
        return "{type: " + type + ", value: " + value + "}";
    }
}

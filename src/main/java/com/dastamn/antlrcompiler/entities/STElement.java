package com.dastamn.antlrcompiler.entities;

import com.dastamn.antlrcompiler.Logger;

public class STElement {

    private final String name;
    private final Type type;
    private Value value;

    public STElement(String name, String type) {
        this.name = name;
        switch (type) {
            case "int_SJ":
                this.type = Type.INT_SJ;
                break;
            case "float_SJ":
                this.type = Type.FLOAT_SJ;
                break;
            default:
                this.type = Type.STRING_SJ;
                break;
        }
    }

    public String getName() {
        return name;
    }

    public Value getValue() {
        return value;
    }

    public Type getType() {
        return type;
    }

    public <T> void setValue(T value) {
        if (this.value == null) this.value = new Value();
        if (value instanceof Float) {
            this.value.setValue(type == Type.INT_SJ ? ((Float) value).intValue() : value);
        } else {
            this.value.setValue(value);
        }
    }

    public void setValue(Value value) {
        if ((type == Type.STRING_SJ && !value.isString()) || (type != Type.STRING_SJ && value.isString())) {
            Logger.typeMismatch(value.getType().getTypeName(), type.getTypeName(), name);
        } else {
            this.value = type == Type.INT_SJ ? value.castToInt() : value;
        }
    }

    @Override
    public String toString() {
        return name;
    }
}
package com.dastamn.antlrcompiler.entities;

import com.dastamn.antlrcompiler.Logger;

public class STElement {

    private String name;
    private Value value;
    private Type type;

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
            Logger.typeMismatch(value.getType().name(), type.getTypeName(), name);
        } else {
            this.value = type == Type.INT_SJ ? value.castToInt() : value;
        }
    }

    public STElement setName(String name) {
        this.name = name;return this;
    }

    public STElement setType(String type) {
        switch (type) {
            case "int_SJ":
                this.type = Type.INT_SJ;
                break;
            case "float_SJ":
                this.type = Type.FLOAT_SJ;
                break;
            case "string_SJ":
                this.type = Type.STRING_SJ;
                break;
        }
        return this;
    }

    @Override
    public String toString() {
        return "{type: " + type + ", value: " + value + "}";
    }
}

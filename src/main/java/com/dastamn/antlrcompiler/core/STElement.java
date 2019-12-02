package com.dastamn.antlrcompiler.core;

public class STElement {

    private String name;
    private Float value;
    private String type;

    public String getName() {
        return name;
    }

    public Float getValue() {
        return value;
    }

    public String getType() {
        return type;
    }

    public STElement setName(String name) {
        this.name = name;
        return this;
    }

    public STElement setValue(float value) {
        this.value = value;
        return this;
    }

    public STElement setType(String type) {
        this.type = type;
        return this;
    }

    public boolean isFloatCompil() {
        return type.equals("floatcompil");
    }

    @Override
    public String toString() {
        return "{name: " + name + ", type: " + type + ", value: " + value + "}";
    }
}

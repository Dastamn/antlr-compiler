package com.dastamn.antlrcompiler.core;

public class STElement {

    private String name;
    private Number number;
    private String type;

    public String getName() {
        return name;
    }

    public Number getNumber() {
        return number;
    }

    public String getType() {
        return type;
    }

    public Float getValue() {
        return number != null ? type.equals("floatcompil") ? number.asFloat() : number.asInt() : null;
    }

    public STElement setName(String name) {
        this.name = name;
        return this;
    }

    public void setNumber(Number number) {
        this.number = type.equals("intcompil") ? number.castToInt() : number;
    }

    public STElement setType(String type) {
        this.type = type;
        return this;
    }

    @Override
    public String toString() {
        return "{name: " + name + ", type: " + type + ", value: " + number + "}";
    }
}

package com.dastamn.antlrcompiler.core;

public class STElement {

    private Number number;
    private String type;

    public Number getNumber() {
        return number;
    }

    public String getType() {
        return type;
    }

    public Float getValue() {
        return number != null ? type.equals("floatcompil") ? number.getValue() : number.asInt() : null;
    }

    public void setNumber(Number number) {
        this.number = type.equals("intcompil") ? number.castToInt() : number;
    }

    public void setNumberValue(float value) {
        value = type.equals("intcompil") ? (int) value : value;
        if(number == null) {
            number = new Number(value);
        } else {
            number.setValue(value);
        }
    }

    public STElement setType(String type) {
        this.type = type;
        return this;
    }

    @Override
    public String toString() {
        return "{type: " + type + ", value: " + number + "}";
    }
}

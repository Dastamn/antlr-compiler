package com.dastamn.antlrcompiler.entities;

public enum Type {

    INT_SJ("int_SJ", "%d"),
    FLOAT_SJ("float_SJ", "%f"),
    STRING_SJ("string_SJ", "%s");

    private final String typeName;
    private final String format;

    Type(String typeName, String format) {
        this.typeName = typeName;
        this.format = format;
    }

    public String getTypeName() {
        return typeName;
    }

    public String getFormat() {
        return format;
    }

    @Override
    public String toString() {
        return typeName;
    }
}

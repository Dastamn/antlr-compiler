package com.dastamn.antlrcompiler.entities;

public class Quad {

    private String operator;
    private String leftOperand;
    private String rightOperand;
    private String container;

    public String getOperator() {
        return operator;
    }

    public Quad setOperator(String operator) {
        this.operator = operator;
        return this;
    }

    public Quad setLeftOperand(String leftOperand) {
        this.leftOperand = leftOperand;
        return this;
    }

    public Quad setRightOperand(String rightOperand) {
        this.rightOperand = rightOperand;
        return this;
    }

    public String getContainer() {
        return container;
    }

    public Quad setContainer(String container) {
        this.container = container;
        return this;
    }

    public Quad setTempIndex(int index) {
        container = "temp" + index;
        return this;
    }

    @Override
    public String toString() {
        return "(" + operator + ", " +
                (leftOperand == null ? "" : leftOperand) + ", " +
                (rightOperand == null ? "" : rightOperand) + ", " +
                (container == null ? "" : container) + ")";
    }
}

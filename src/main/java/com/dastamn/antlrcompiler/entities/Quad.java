package com.dastamn.antlrcompiler.entities;

import java.util.ArrayList;
import java.util.List;

public class Quad {

    private String operator;
    private String leftOperand;
    private String rightOperand;
    private String container;
    private boolean isEffective;

    public Quad(boolean isEffective) {
        this.isEffective = isEffective;
    }

    public boolean isEffective() {
        return isEffective;
    }

    public String getOperator() {
        return operator;
    }

    public Quad setOperator(String operator) {
        this.operator = operator;
        return this;
    }

    public String getLeftOperand() {
        return leftOperand;
    }

    public Quad setLeftOperand(String leftOperand) {
        this.leftOperand = leftOperand;
        return this;
    }

    public String getRightOperand() {
        return rightOperand;
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

    public void swapOperands() {
        String temp = leftOperand;
        leftOperand = rightOperand;
        rightOperand = temp;
    }

    public boolean isAffect() {
        return operator.equals(":=");
    }

    public boolean isEval() {
        return operator.matches("[<>&|!=]") || operator.equals("!=");
    }

    public boolean isJump() {
        return operator.matches("\\w+");
    }

    public boolean isConditionalJump() {
        return operator.startsWith("B") && !operator.equals("BR");
    }

    public boolean isUnconditionalJump() {
        return operator.equals("BR");
    }

    @Override
    public String toString() {
        return "(" + operator + ", " +
                (leftOperand == null ? "" : leftOperand) + ", " +
                (rightOperand == null ? "" : rightOperand) + ", " +
                (container == null ? "" : container) + ") ";
    }
}

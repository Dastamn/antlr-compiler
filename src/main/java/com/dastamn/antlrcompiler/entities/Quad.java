package com.dastamn.antlrcompiler.entities;

import java.util.ArrayList;
import java.util.List;

public class Quad {

    private String operator;
    private String leftOperand;
    private String rightOperand;
    private String container;
    private List<String[]> instructions;

    public Quad() {
        this.instructions = new ArrayList<>();
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

    public boolean isAffect() {
        return operator.equals(":=");
    }

    public boolean isEval() {
        return operator.matches("[<=>!&|]");
    }

    public boolean isJump() {
        return operator.matches("\\w+");
    }

    public boolean hasCode() {
        return !instructions.isEmpty();
    }

    public boolean hasManyInstructions() {
        return instructions.size() > 1;
    }

    public int getInstCount() {
        return instructions.size();
    }

    public String[] getFirstInst() {
        return instructions.get(0);
    }

    public String[] instAt(int index) {
        return index >= instructions.size() ? new String[]{null, null} : instructions.get(index);
    }

    public String getInAcc(String acc) {
        if (acc == null) {
            instructions.add(new String[]{leftOperand, "LOAD " + leftOperand});
            return leftOperand;
        }
        if (acc.equals(rightOperand) && !operator.matches("[-/]")) {
            String temp = leftOperand;
            leftOperand = rightOperand;
            rightOperand = temp;
            return acc;
        }
        if (!acc.equals(leftOperand) || operator.matches("[-/]")) {
            if (!acc.equals(leftOperand)) {
                instructions.add(new String[]{acc, "STORE " + acc});
                instructions.add(new String[]{leftOperand, "LOAD " + leftOperand});
            }
            return leftOperand;
        }
        return acc;
    }

    public String toObjectCode(String acc) {
        String res = acc;
        if (operator.equals(":=")) {
            instructions.add(new String[]{res, "MOV " + container + " " + leftOperand});
        } else {
            res = container;
            switch (operator) {
                case "*":
                    instructions.add(new String[]{res, "MULT" + " " + rightOperand});
                    break;
                case "/":
                    instructions.add(new String[]{res, "DIV" + " " + rightOperand});
                    break;
                case "+":
                    instructions.add(new String[]{res, "ADD" + " " + rightOperand});
                    break;
                case "-":
                    instructions.add(new String[]{res, rightOperand == null ? "CHS" : "SUB" + " " + rightOperand});
                    break;
                default:
                    break;
            }

        }
        return res;
    }

    @Override
    public String toString() {
        return "(" + operator + ", " +
                (leftOperand == null ? "" : leftOperand) + ", " +
                (rightOperand == null ? "" : rightOperand) + ", " +
                (container == null ? "" : container) + ")";
    }
}

package com.dastamn.antlrcompiler.entities;

import org.antlr.v4.runtime.tree.ParseTree;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class QuadGen {

    private final Quads quads;
    private final Stack<Quad> jumpStack;
    private Stack<Integer> jumpCount;
    private int tempIndex;
    private String acc;

    public QuadGen() {
        this.quads = new Quads();
        this.jumpStack = new Stack<>();
        this.jumpCount = new Stack<>();
        this.tempIndex = -1;
    }

    public void makeQuad(ParseTree left, ParseTree right, String operator) {
        String leftString = parseTreeToString(left);
        String rightString = parseTreeToString(right);
        if (leftString != null && rightString != null &&
                leftString.startsWith("temp") && rightString.startsWith("temp")) {
            String temp = leftString;
            leftString = rightString;
            rightString = temp;
        }
        quads.add(new Quad()
                .setLeftOperand(leftString != null ? leftString : "temp" + tempIndex)
                .setRightOperand(rightString)
                .setOperator(operator)
                .setContainer("temp" + (leftString != null ? ++tempIndex : tempIndex)));
    }

    public void affect(String id, String value) {
        if (value == null) {
            quads.get(quads.size() - 1).setContainer(id);
            tempIndex = -1;
        } else {
            quads.add(new Quad()
                    .setContainer(id)
                    .setLeftOperand(value)
                    .setOperator(":="));
        }
    }

    public void affect(String id, Value value) {
        quads.add(new Quad()
                .setContainer(id)
                .setLeftOperand(value.toString())
                .setOperator(":="));
    }

    public void jump() {
        Quad quad = new Quad().setOperator("BR");
        quads.add(quad);
        jumpStack.push(quad);
        incrementJumpCount();
    }

    public void eval() {
        String lastOperation = quads.get(quads.size() - 1).getOperator();
        String type;
        switch (lastOperation) {
            case "<":
                type = "BGE";
                break;
            case "<=":
                type = "BG";
                break;
            case ">":
                type = "BLE";
                break;
            case ">=":
                type = "BL";
                break;
            case "=":
                type = "BNE";
                break;
            case "!=":
                type = "BE";
                break;
            case "!":
                type = "BZ";
                break;
            default:
                type = "BNZ";
                break;
        }
        Quad quad = new Quad().setOperator(type).setRightOperand("temp" + tempIndex);
        quads.add(quad);
        jumpStack.push(quad);
        jumpCount.push(1);
    }

    public void updateJump() {
        Quad quad = jumpStack.peek();
        quad.setLeftOperand(String.valueOf(quad.getLeftOperand() != null ?
                Integer.parseInt(quad.getLeftOperand()) + 1 :
                quads.size() + 1));
    }

    public void purgeJumps() {
        int count = jumpCount.pop();
        while (count > 0) {
            jumpStack.pop();
            count--;
        }
    }

    private void incrementJumpCount() {
        int count = jumpCount.pop();
        jumpCount.push(++count);
    }

    private String parseTreeToString(ParseTree parseTree) {
        if (parseTree == null) return null;
        String output;
        if (parseTree.getChildCount() > 1) {
            output = "temp" + (tempIndex > -1 ? tempIndex-- : tempIndex);
        } else {
            output = parseTree.getText();
        }
        return output;
    }

    public void generateCode() {
        quads.forEach(quad -> {
            if (!quad.isEval() && !quad.isJump()) {
                if (!quad.isAffect()) {
                    this.acc = quad.getInAcc(this.acc);
                }
                this.acc = quad.toObjectCode(this.acc);
            }
        });
    }

    public void print() {
        System.out.println(this + "\n");
        generateCode();
        quads.print();
    }

    @Override
    public String toString() {
        AtomicInteger index = new AtomicInteger(0);
        return "Quads: {" + "\n" +
                quads.stream().reduce("", (acc, curr) ->
                                acc + "\t" + index.incrementAndGet() + "- " + curr + "\n",
                        (acc, curr) -> acc + curr) +
                "}";
    }
}
package com.dastamn.antlrcompiler.entities;

import org.antlr.v4.runtime.tree.ParseTree;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class QuadGen {

    private List<Quad> quads;
    private Stack<Quad> quadStack;
    private String lastOperation;
    private int tempIndex;
    private int resIndex;

    public QuadGen() {
        this.quadStack = new Stack<>();
        this.quads = new ArrayList<>();
        this.tempIndex = -1;
        this.resIndex = -1;
    }

    public void makeQuad(ParseTree left, ParseTree right, String operation) {
        if (operation.equals("!")) {
            lastOperation = operation;
            quads.add(new Quad()
                    .setContainer("res0")
                    .setLeftOperand("res0")
                    .setOperator(operation)
            );
            return;
        }
        boolean isEvalRes = false;
        String container = "temp";
        Quad res = new Quad();
        if (operation.matches("[<=>&|]")) {
            if (operation.matches("[&|]")) {
                isEvalRes = true;
                container = "res";
                resIndex = -1;
            }
            int i = 1;
            for (Quad elem : quadStack) {
                if (elem.getContainer().startsWith("res")) {
                    elem.setContainer(container + i--);
                }
            }
            drainQuads(null);
            res.setContainer("res" + ++resIndex);
            lastOperation = operation;
        } else {
            res.setContainer(tempIndex == -1 ? "res" : "temp" + tempIndex--);
        }
        quadStack.push(res
                .setLeftOperand(isEvalRes ? "res0" : parseTreeToString(left))
                .setRightOperand(isEvalRes ? "res1" : parseTreeToString(right))
                .setOperator(operation)
        );
    }

    public void affect(String id, Value value) {
        quads.add(new Quad().setContainer(id).setLeftOperand(value.toString()).setOperator(":="));
    }

    public void jump() {
        if (lastOperation != null) {
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
            quads.add(new Quad().setOperator(type).setRightOperand("res0"));
        }

    }

    public void updateLastJump() {
        for (int i = quads.size() - 1; i >= 0; i--) {
            if (quads.get(i).getOperator().matches("\\w+")) {
                quads.get(i).setLeftOperand(String.valueOf(quads.size() + 1));
                break;
            }
        }
    }

    public void drainQuads(String id) {
        while (!quadStack.isEmpty()) {
            Quad quad = quadStack.pop();
            quads.add(quadStack.isEmpty() && id != null ? quad.setContainer(id) : quad);
        }
        tempIndex = -1;
    }

    private String parseTreeToString(ParseTree parseTree) {
        if (parseTree == null) return "-1";
        String output;
        if (parseTree.getChildCount() > 1) {
            output = "temp" + (++tempIndex);
        } else {
            output = parseTree.getText();
        }
        return output;
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

package com.dastamn.antlrcompiler.entities;

import org.antlr.v4.runtime.tree.ParseTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.concurrent.atomic.AtomicInteger;

public class QuadGen {

    private List<Quad> quads;
    private Stack<Quad> quadStack;
    private int index;

    public QuadGen() {
        this.quadStack = new Stack<>();
        this.quads = new ArrayList<>();
        this.index = -1;
    }

    public void makeQuad(ParseTree left, ParseTree right, String operation) {
        if (operation.matches("[<=>]")) {
            int i = 0;
            for (Quad quad : quadStack) {
                if (quad.getContainer().equals("res")) {
                    quad.setContainer("temp" + i++);
                }
            }
            drainQuads(null);
        }
        quadStack.push(new Quad()
                .setContainer(index == -1 ? "res" : "temp" + index--)
                .setLeftOperand(parseTreeToString(left))
                .setRightOperand(parseTreeToString(right))
                .setOperator(operation)
        );
    }

    public void affect(String id, Value value) {
        quads.add(new Quad().setContainer(id).setLeftOperand(value.toString()).setOperator(":="));
    }

    public void jump(String type) {
        quads.add(new Quad().setOperator(type).setRightOperand("res"));
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
        index = -1;
    }

    private String parseTreeToString(ParseTree parseTree) {
        if (parseTree == null) return "1";
        String output;
        if (parseTree.getChildCount() > 1) {
            output = "temp" + (++index);
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

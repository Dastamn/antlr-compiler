package com.dastamn.antlrcompiler.entities;

import org.antlr.v4.runtime.tree.ParseTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class QuadGen {

    private List<Quad> quads;
    private Stack<Quad> quadStack;
    private Stack<Integer> indexStack;

    public QuadGen() {
        this.quadStack = new Stack<>();
        this.quads = new ArrayList<>();
        this.indexStack = new Stack<>();
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
                .setContainer(indexStack.isEmpty() ? "res" : "temp" + indexStack.pop())
                .setLeftOperand(parseTreeToString(left))
                .setRightOperand(parseTreeToString(right))
                .setOperator(operation)
        );
    }

    public void drainQuads(String id) {
        while (!quadStack.isEmpty()) {
            Quad quad = quadStack.pop();
            quads.add(quadStack.isEmpty() && id != null ? quad.setContainer(id) : quad);
        }
    }

    private String parseTreeToString(ParseTree parseTree) {
        if (parseTree == null) return "1";
        String output;
        if (parseTree.getChildCount() > 1) {
            int index = indexStack.isEmpty() ? -1 : indexStack.peek();
            output = "temp" + (++index);
            indexStack.push(index);
        } else {
            output = parseTree.getText();
        }
        return output;
    }

    @Override
    public String toString() {
        return "quads: " + quads + "\n" +
                "quad stack: " + quadStack + "\n" +
                "index stack: " + indexStack;
    }
}

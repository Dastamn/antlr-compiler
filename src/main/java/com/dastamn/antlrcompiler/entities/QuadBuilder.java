package com.dastamn.antlrcompiler.entities;

import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;

public class QuadBuilder {

    private ParseTree leftSide;
    private ParseTree rightSide;
    private TerminalNode operator;
    private Integer tempIndex;

    public QuadBuilder setLeftSide(ParseTree leftSide) {
        this.leftSide = leftSide;
        return this;
    }

    public QuadBuilder setRightSide(ParseTree rightSide) {
        this.rightSide = rightSide;
        return this;
    }

    public QuadBuilder setOperator(TerminalNode operator) {
        this.operator = operator;
        return this;
    }

    public QuadBuilder setTempIndex(Integer tempIndex) {
        this.tempIndex = tempIndex;
        return this;
    }

    public void build() {

    }
}

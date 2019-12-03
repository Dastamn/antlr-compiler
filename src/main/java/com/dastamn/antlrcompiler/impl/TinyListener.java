package com.dastamn.antlrcompiler.impl;

import com.dastamn.antlrcompiler.core.Number;
import com.dastamn.antlrcompiler.core.STElement;
import com.dastamn.antlrcompiler.gen.gBaseListener;
import com.dastamn.antlrcompiler.gen.gParser;
import com.dastamn.antlrcompiler.util.Logger;

import java.util.Arrays;
import java.util.Map;
import java.util.Stack;

public class TinyListener extends gBaseListener {

    private final Map<String, STElement> symbolTable;
    private final Stack<Number> values = new Stack<>();

    public TinyListener(Map<String, STElement> symbolTable) {
        this.symbolTable = symbolTable;
    }

    @Override
    public void exitVarDec(gParser.VarDecContext ctx) {
        String type = ctx.VAR_TYPE().getText();
        String[] ids = ctx.idList().getText().split(",");
        Arrays.stream(ids).forEach(id -> {
            if(!symbolTable.containsKey(id)) {
                symbolTable.put(id, new STElement().setName(id).setType(type));
            } else {
                Logger.error("Identifier \"" + id + "\" already declared.");
            }
        });
    }

    @Override
    public void exitAffectation(gParser.AffectationContext ctx) {
        String id = ctx.ID().getText();
        STElement stElement = symbolTable.get(id);
        if (stElement != null) {
            stElement.setNumber(values.pop());
        } else {
            Logger.error("Identifier \"" + id + "\" not declared.");
        }
    }

    @Override
    public void exitPlus(gParser.PlusContext ctx) {
        values.push(values.pop().plus(values.pop()));
    }

    @Override
    public void exitMinus(gParser.MinusContext ctx) {
        Number right = values.pop();
        values.push(values.pop().minus(right));
    }

    @Override
    public void exitTimes(gParser.TimesContext ctx) {
        values.push(values.pop().times(values.pop()));
    }

    @Override
    public void exitDiv(gParser.DivContext ctx) {
        Number right = values.pop();
        values.push(values.pop().div(right));
    }

    @Override
    public void exitUnaryMinus(gParser.UnaryMinusContext ctx) {
        values.push(values.pop().neg());
    }

    @Override
    public void exitNumber(gParser.NumberContext ctx) {
        values.push(new Number(Float.parseFloat(ctx.getText())));
    }

    @Override
    public void exitId(gParser.IdContext ctx) {
        String id = ctx.getText();
        STElement stElement = symbolTable.get(id);
        if (stElement != null) {
            if (stElement.getNumber() != null) {
                values.push(stElement.getNumber());
            } else {
                Logger.error("Identifier \"" + id + "\" not initialised.");
            }
        } else {
            Logger.error("Identifier \"" + id + "\" not declared.");
        }
    }

    @Override
    public void exitAxiom(gParser.AxiomContext ctx) {
        System.out.println("stack: " + values);
    }
}

package com.dastamn.antlrcompiler.impl;

import com.dastamn.antlrcompiler.core.Number;
import com.dastamn.antlrcompiler.core.STElement;
import com.dastamn.antlrcompiler.gen.gBaseVisitor;
import com.dastamn.antlrcompiler.gen.gParser;
import com.dastamn.antlrcompiler.util.Logger;

import java.util.Arrays;
import java.util.Map;

public class TinyVisitor extends gBaseVisitor {

    private final Map<String, STElement> symbolTable;

    public TinyVisitor(Map<String, STElement> symbolTable) {
        this.symbolTable = symbolTable;
    }

    @Override
    public Object visitVarDec(gParser.VarDecContext ctx) {
        String type = ctx.VAR_TYPE().getText();
        String[] ids = (String[]) this.visit(ctx.idList());
        Arrays.stream(ids).forEach(id -> {
            if (!symbolTable.containsKey(id)) {
                symbolTable.put(id, new STElement().setName(id).setType(type));
            } else {
                Logger.error("Identifier \"" + id + "\" already declared.");
            }
        });
        return null;
    }

    @Override
    public String[] visitIdList(gParser.IdListContext ctx) {
        return ctx.getText().split(",");
    }

    @Override
    public Object visitTimes(gParser.TimesContext ctx) {
        return ((Number) this.visit(ctx.expression(0))).times((Number) this.visit(ctx.expression(1)));
    }

    @Override
    public Object visitDiv(gParser.DivContext ctx) {
        return ((Number) this.visit(ctx.expression(0))).div((Number) this.visit(ctx.expression(1)));
    }

    @Override
    public Object visitPlus(gParser.PlusContext ctx) {
        return ((Number) this.visit(ctx.expression(0))).plus((Number) this.visit(ctx.expression(1)));
    }

    @Override
    public Object visitMinus(gParser.MinusContext ctx) {
        return ((Number) this.visit(ctx.expression(0))).minus((Number) this.visit(ctx.expression(1)));
    }

    @Override
    public Number visitNumber(gParser.NumberContext ctx) {
        return new Number(Float.parseFloat(ctx.getText()));
    }

    @Override
    public Number visitId(gParser.IdContext ctx) {
        String id = ctx.getText();
        STElement stElement = symbolTable.get(id);
        if (stElement != null) {
            if (stElement.getNumber() != null) {
                return stElement.getNumber();
            }
            Logger.error("Identifier \"" + id + "\" not initialised.");
        } else {
            Logger.error("Identifier \"" + id + "\" not declared.");
        }
        return null;
    }

    @Override
    public Boolean visitEvaluation(gParser.EvaluationContext ctx) {
        Number left = (Number) this.visit(ctx.expression(0));
        Number right = (Number) this.visit(ctx.expression(1));
        return ctx.GT() != null ? left.getValue() > right.getValue() : left.getValue() < right.getValue();
    }

    @Override
    public STElement visitAffectation(gParser.AffectationContext ctx) {
        Number res = (Number) this.visit(ctx.expression());
        String id = ctx.ID().getText();
        STElement stElement = symbolTable.get(id);
        if (stElement != null) {
            stElement.setNumber(res);
        } else {
            Logger.error("Identifier \"" + id + "\" not declared.");
        }
        return stElement;
    }

    @Override
    public Boolean visitIfStatement(gParser.IfStatementContext ctx) {
        return (Boolean) this.visit(ctx.evaluation());
    }

    @Override
    public Object visitCondition(gParser.ConditionContext ctx) {
        if ((Boolean) this.visit(ctx.ifStatement())) {
            this.visit(ctx.thenBlock());
        } else if (ctx.elseBlock() != null) {
            this.visit(ctx.elseBlock());
        }
        return null;
    }

    @Override
    public Object visitPrint(gParser.PrintContext ctx) {
        if (ctx.STR() != null) {
            System.out.println(ctx.STR().getText().replaceAll("(?<!\\\\)\"", "")
                    .replaceAll("\\\\\"", "\""));
        } else {
            String[] ids = (String[]) this.visit(ctx.idList());
            Arrays.stream(ids).forEach(id -> {
                STElement stElement = symbolTable.get(id);
                if (stElement != null) {
                    System.out.println(stElement.getValue());
                } else {
                    Logger.error("Identifier \"" + id + "\" not declared.");
                }
            });
        }
        return super.visitPrint(ctx);
    }
}

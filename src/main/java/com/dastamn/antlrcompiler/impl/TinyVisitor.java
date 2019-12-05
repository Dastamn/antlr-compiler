package com.dastamn.antlrcompiler.impl;

import com.dastamn.antlrcompiler.core.STElement;
import com.dastamn.antlrcompiler.core.Value;
import com.dastamn.antlrcompiler.gen.gBaseVisitor;
import com.dastamn.antlrcompiler.gen.gParser;
import com.dastamn.antlrcompiler.util.Logger;

import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;

public class TinyVisitor extends gBaseVisitor {

    private final Map<String, STElement> symbolTable;
    private final Scanner scanner;
    private boolean ioImport;
    private boolean langImport;

    public TinyVisitor(Map<String, STElement> symbolTable) {
        this.symbolTable = symbolTable;
        this.scanner = new Scanner(System.in);
        this.ioImport = this.langImport = false;
    }

    @Override
    public Object visitImportLib(gParser.ImportLibContext ctx) {
        if (ctx.LIBRARY() != null) {
            if (ctx.LIBRARY().getText().equals("Small_Java.lang")) {
                langImport = true;
            } else if (ctx.LIBRARY().getText().equals("Small_Java.io")) {
                ioImport = true;
            } else {
                Logger.warn("Unknown library: " + ctx.LIBRARY().getText());
            }
        }
        return null;
    }

    @Override
    public Object visitDeclaration(gParser.DeclarationContext ctx) {
        String type = ctx.VAR_TYPE().getText();
        Arrays.stream((String[]) this.visit(ctx.idList()))
                .forEach(id -> {
                    if (id.length() > 10) {
                        Logger.error("Identifier name must not exceed 10 characters.");
                    }
                    symbolTable.put(id, new STElement().setType(type));
                });
        return null;
    }

    @Override
    public String[] visitIdList(gParser.IdListContext ctx) {
        return ctx.getText().split(",");
    }

    @Override
    public Object visitAffectation(gParser.AffectationContext ctx) {
        String id = ctx.ID().getText();
        STElement stElement = symbolTable.get(ctx.ID().getText());
        if (stElement != null) {
            stElement.setValue((Value) this.visit(ctx.expression()));
        } else {
            Logger.error("Identifier \"" + id + "\" not declared.");
        }
        return null;
    }

    @Override
    public Object visitExpParen(gParser.ExpParenContext ctx) {
        return this.visit(ctx.expression());
    }

    @Override
    public Object visitTimes(gParser.TimesContext ctx) {
        if (!langImport) {
            Logger.error("Library \"Small_Java.lang\" not imported.");
        }
        return ((Value) this.visit(ctx.expression(0))).times((Value) this.visit(ctx.expression(1)));
    }

    @Override
    public Object visitDiv(gParser.DivContext ctx) {
        if (!langImport) {
            Logger.error("Library \"Small_Java.lang\" not imported.");
        }
        return ((Value) this.visit(ctx.expression(0))).div((Value) this.visit(ctx.expression(1)));
    }

    @Override
    public Object visitPlus(gParser.PlusContext ctx) {
        if (!langImport) {
            Logger.error("Library \"Small_Java.lang\" not imported.");
        }
        return ((Value) this.visit(ctx.expression(0))).plus((Value) this.visit(ctx.expression(1)));
    }

    @Override
    public Value visitMinus(gParser.MinusContext ctx) {
        if (!langImport) {
            Logger.error("Library \"Small_Java.lang\" not imported.");
        }
        return ((Value) this.visit(ctx.expression(0))).minus((Value) this.visit(ctx.expression(1)));
    }

    @Override
    public Value visitUnaryMinus(gParser.UnaryMinusContext ctx) {
        if (!langImport) {
            Logger.error("Library \"Small_Java.lang\" not imported.");
        }
        return ((Value) this.visit(ctx.expression())).neg();
    }

    @Override
    public Value visitNumber(gParser.NumberContext ctx) {
        return new Value(Float.parseFloat(ctx.getText()));
    }

    @Override
    public Value visitStr(gParser.StrContext ctx) {
        if (!langImport) {
            Logger.error("Library \"Small_Java.lang\" not imported.");
        }
        String str = ctx.getText();
        return new Value(str.substring(1, str.length() - 1).replace("\"\"", "\""));
    }

    @Override
    public Value visitId(gParser.IdContext ctx) {
        String id = ctx.getText();
        STElement stElement = symbolTable.get(id);
        if (stElement != null) {
            if (stElement.getValue() != null) {
                return stElement.getValue();
            }
            Logger.error("Identifier \"" + id + "\" not initialised.");
        } else {
            Logger.error("Identifier \"" + id + "\" not declared.");
        }
        return null;
    }

    @Override
    public Object visitEvalParen(gParser.EvalParenContext ctx) {
        return this.visit(ctx.evaluation());
    }

    @Override
    public Boolean visitComp(gParser.CompContext ctx) {
        Value left = (Value) this.visit(ctx.expression(0));
        Value right = (Value) this.visit(ctx.expression(1));
        if (left.isString() || right.isString()) {
            Logger.error("Can't evaluate a string expression.");
        }
        switch (ctx.getChild(1).getText()) {
            case ">":
                return left.gt(right);
            case ">=":
                return left.gte(right);
            case "<":
                return left.lt(right);
            case "<=":
                return left.lte(right);
            case "=":
                return left.eq(right);
            case "!=":
                return left.notEq(right);
            default:
                return false;
        }
    }

    @Override
    public Boolean visitNot(gParser.NotContext ctx) {
        return !((Boolean) this.visit(ctx.evaluation()));
    }

    @Override
    public Boolean visitAnd(gParser.AndContext ctx) {
        return (Boolean) this.visit(ctx.evaluation(0)) && (Boolean) this.visit(ctx.evaluation(1));
    }

    @Override
    public Object visitOr(gParser.OrContext ctx) {
        return (Boolean) this.visit(ctx.evaluation(0)) || (Boolean) this.visit(ctx.evaluation(1));
    }

    @Override
    public Object visitCondition(gParser.ConditionContext ctx) {
        if ((Boolean) this.visit(ctx.ifStatement())) {
            this.visit(ctx.thenBlock());
        } else {
            this.visit(ctx.elseBlock());
        }
        return null;
    }

    @Override
    public Boolean visitIfStatement(gParser.IfStatementContext ctx) {
        return (Boolean) this.visit(ctx.evaluation());
    }

    @Override
    public Object visitInput(gParser.InputContext ctx) {
        if (!ioImport) {
            Logger.error("Library \"Small_Java.io\" not imported.");
        }
        return super.visitInput(ctx);
    }

    @Override
    public Object visitOutput(gParser.OutputContext ctx) {
        if (!ioImport) {
            Logger.error("Library \"Small_Java.io\" not imported.");
        }
        return super.visitOutput(ctx);
    }

    //    @Override
//    public Object visitVarDec(gParser.VarDecContext ctx) {
//        String type = ctx.VAR_TYPE().getText();
//        String[] ids = (String[]) this.visit(ctx.idList());
//        Arrays.stream(ids).forEach(id -> {
//            if (!symbolTable.containsKey(id)) {
//                symbolTable.put(id, new STElement().setType(type));
//            } else {
//                Logger.error("Identifier \"" + id + "\" already declared.");
//            }
//        });
//        return null;
//    }
//
//    @Override
//    public String[] visitIdList(gParser.IdListContext ctx) {
//        return ctx.getText().split(",");
//    }
//
//    @Override
//    public Object visitTimes(gParser.TimesContext ctx) {
//        return ((Number) this.visit(ctx.expression(0))).times((Number) this.visit(ctx.expression(1)));
//    }
//
//    @Override
//    public Object visitDiv(gParser.DivContext ctx) {
//        return ((Number) this.visit(ctx.expression(0))).div((Number) this.visit(ctx.expression(1)));
//    }
//
//    @Override
//    public Object visitPlus(gParser.PlusContext ctx) {
//        return ((Number) this.visit(ctx.expression(0))).plus((Number) this.visit(ctx.expression(1)));
//    }
//
//    @Override
//    public Object visitMinus(gParser.MinusContext ctx) {
//        return ((Number) this.visit(ctx.expression(0))).minus((Number) this.visit(ctx.expression(1)));
//    }
//
//    @Override
//    public Number visitNumber(gParser.NumberContext ctx) {
//        return new Number(Float.parseFloat(ctx.getText()));
//    }
//
//    @Override
//    public Number visitId(gParser.IdContext ctx) {
//        String id = ctx.getText();
//        STElement stElement = symbolTable.get(id);
//        if (stElement != null) {
//            if (stElement.getNumber() != null) {
//                return stElement.getNumber();
//            }
//            Logger.error("Identifier \"" + id + "\" not initialised.");
//        } else {
//            Logger.error("Identifier \"" + id + "\" not declared.");
//        }
//        return null;
//    }
//
//    @Override
//    public Boolean visitEvaluation(gParser.EvaluationContext ctx) {
//        Number left = (Number) this.visit(ctx.expression(0));
//        Number right = (Number) this.visit(ctx.expression(1));
//        return ctx.GT() != null ? left.getValue() > right.getValue() : left.getValue() < right.getValue();
//    }
//
//    @Override
//    public STElement visitAffectation(gParser.AffectationContext ctx) {
//        Number res = (Number) this.visit(ctx.expression());
//        String id = ctx.ID().getText();
//        STElement stElement = symbolTable.get(id);
//        if (stElement != null) {
//            stElement.setNumber(res);
//        } else {
//            Logger.error("Identifier \"" + id + "\" not declared.");
//        }
//        return stElement;
//    }
//
//    @Override
//    public Boolean visitIfStatement(gParser.IfStatementContext ctx) {
//        return (Boolean) this.visit(ctx.evaluation());
//    }
//
//    @Override
//    public Object visitCondition(gParser.ConditionContext ctx) {
//        if ((Boolean) this.visit(ctx.ifStatement())) {
//            this.visit(ctx.thenBlock());
//        } else if (ctx.elseBlock() != null) {
//            this.visit(ctx.elseBlock());
//        }
//        return null;
//    }
//
//    @Override
//    public Object visitPrint(gParser.PrintContext ctx) {
//        if (ctx.STR() != null) {
//            System.out.println(ctx.STR().getText().replaceAll("(?<!\\\\)\"", "")
//                    .replaceAll("\\\\\"", "\""));
//        } else {
//            String[] ids = (String[]) this.visit(ctx.idList());
//            Arrays.stream(ids).forEach(id -> {
//                STElement stElement = symbolTable.get(id);
//                if (stElement != null) {
//                    System.out.println(stElement.getValue());
//                } else {
//                    Logger.error("Identifier \"" + id + "\" not declared.");
//                }
//            });
//        }
//        return null;
//    }
//
//    @Override
//    public Object visitScan(gParser.ScanContext ctx) {
//        String[] ids = (String[]) this.visit(ctx.idList());
//        Arrays.stream(ids).forEach(id -> {
//            STElement stElement = symbolTable.get(id);
//            if (stElement == null) {
//                Logger.error("Identifier \"" + id + "\" not declared.");
//            } else {
//                String input = scanner.nextLine();
//                float value = 0;
//                try {
//                    value = Float.parseFloat(input);
//                } catch (NumberFormatException e) {
//                    Logger.error("Value of \"" + id + "\" must be of type \"" + stElement.getType() +
//                            "\", got: " + input);
//                }
//                stElement.setNumberValue(value);
//            }
//        });
//        return null;
//    }
}

package com.dastamn.antlrcompiler.impl;

import com.dastamn.antlrcompiler.core.STElement;
import com.dastamn.antlrcompiler.core.Type;
import com.dastamn.antlrcompiler.core.Value;
import com.dastamn.antlrcompiler.gen.gBaseVisitor;
import com.dastamn.antlrcompiler.gen.gParser;
import com.dastamn.antlrcompiler.util.Logger;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
        if (ctx.lib() != null) {
            if (ctx.lib().getText().equals("Small_Java.lang")) {
                langImport = true;
            } else if (ctx.lib().getText().equals("Small_Java.io")) {
                ioImport = true;
            } else {
                Logger.warn("Unknown library: " + ctx.lib().getText()+".");
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
                    symbolTable.put(id, new STElement().setType(type).setName(id));
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
            Value v = (Value) this.visit(ctx.expression());
            stElement.setValue(v);
        } else {
            Logger.notDeclared(id);
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
            Logger.libraryNotImported("Small_Java.lang");
        }
        return ((Value) this.visit(ctx.expression(0))).times((Value) this.visit(ctx.expression(1)));
    }

    @Override
    public Object visitDiv(gParser.DivContext ctx) {
        if (!langImport) {
            Logger.libraryNotImported("Small_Java.lang");
        }
        return ((Value) this.visit(ctx.expression(0))).div((Value) this.visit(ctx.expression(1)));
    }

    @Override
    public Object visitPlus(gParser.PlusContext ctx) {
        if (!langImport) {
            Logger.libraryNotImported("Small_Java.lang");
        }
        return ((Value) this.visit(ctx.expression(0))).plus((Value) this.visit(ctx.expression(1)));
    }

    @Override
    public Value visitMinus(gParser.MinusContext ctx) {
        if (!langImport) {
            Logger.libraryNotImported("Small_Java.lang");
        }
        return ((Value) this.visit(ctx.expression(0))).minus((Value) this.visit(ctx.expression(1)));
    }

    @Override
    public Value visitUnaryMinus(gParser.UnaryMinusContext ctx) {
        if (!langImport) {
            Logger.libraryNotImported("Small_Java.lang");
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
            Logger.libraryNotImported("Small_Java.lang");
        }
        String str = ctx.getText();
        return new Value(str.substring(1, str.length() - 1).replaceAll("\\\\\"", "\""));
    }

    @Override
    public Value visitId(gParser.IdContext ctx) {
        String id = ctx.getText();
        STElement stElement = symbolTable.get(id);
        if (stElement != null) {
            if (stElement.getValue() != null) {
                return stElement.getValue();
            }
            Logger.notInitialised(id);
        } else {
            Logger.notDeclared(id);
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
            Logger.error("Can't evaluate a \"" + Type.STRING_SJ + "\" type.");
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
            Logger.libraryNotImported("Small_Java.io");
        }
        String[] formats = ctx.FORMAT().getText()
                .substring(1, ctx.FORMAT().getText().length() - 1)
                .replaceAll(" ", "")
                .split("(?<=\\G.{2})");
        String[] ids = (String[]) this.visit(ctx.idList());
        STElement[] stElements = Arrays.stream(ids)
                .map(id -> {
                    STElement stElement = symbolTable.get(id);
                    if (stElement == null) {
                        Logger.notDeclared(id);
                    }
                    return stElement;
                })
                .toArray(STElement[]::new);
        if (ids.length != formats.length) {
            Logger.error("Count mismatch between formats and identifiers in input instruction.");
        }
        for (int i = 0; i < formats.length; i++) {
            String format = formats[i];
            switch (format) {
                case "%d": {
                    STElement stElement = stElements[i];
                    if (stElement.getType() != Type.INT_SJ) {
                        Logger.formatMismatch("%d", stElement.getType().getFormat(), ids[i]);
                    }
                    break;
                }
                case "%f": {
                    STElement stElement = stElements[i];
                    if (stElement.getType() != Type.FLOAT_SJ) {
                        Logger.formatMismatch("%f", stElement.getType().getFormat(), ids[i]);
                    }
                    break;
                }
                case "%s": {
                    STElement stElement = stElements[i];
                    if (stElement.getType() != Type.STRING_SJ) {
                        Logger.formatMismatch("%s", stElement.getType().getFormat(), ids[i]);
                    }
                    break;
                }
            }
        }
        Arrays.stream(stElements).forEach(stElement -> {
            switch (stElement.getType()) {
                case INT_SJ:
                    stElement.setValue(scanner.nextInt());
                    break;
                case FLOAT_SJ:
                    stElement.setValue(scanner.nextFloat());
                    break;
                case STRING_SJ:
                    stElement.setValue(scanner.next());
                    break;
            }
        });
        return null;
    }

    @Override
    public Object visitOutput(gParser.OutputContext ctx) {
        if (!ioImport) {
            Logger.error("Library \"Small_Java.io\" not imported.");
            Logger.libraryNotImported("Small_Java.io");
        }
        this.visit(ctx.outputArgs());
        return null;
    }

    @Override
    public Object visitOutputArgs(gParser.OutputArgsContext ctx) {
        String str = ctx.STR().getText()
                .substring(1, ctx.STR().getText().length() - 1)
                .replaceAll("\\\\\"", "\"");
        if (ctx.outputIdList() != null) {
            String[] ids = (String[]) this.visit(ctx.outputIdList());
            Pattern pattern = Pattern.compile("%[dfs]");
            Matcher matcher = pattern.matcher(str);
            String[] formats = matcher.results()
                    .map(MatchResult::group)
                    .toArray(String[]::new);
            if (ids.length > formats.length) {
                Logger.error("More identifiers than type formats in output instruction.");
            }
            AtomicInteger index = new AtomicInteger(0);
            STElement[] stElements = Arrays.stream(ids)
                    .map(id -> {
                        STElement stElement = symbolTable.get(id);
                        if (stElement == null) {
                            Logger.notDeclared(id);
                        } else {
                            if (!stElement.getType().getFormat().equals(formats[index.get()])) {
                                Logger.formatMismatch(formats[index.get()], stElement.getType().getFormat(), id);
                            }
                        }
                        index.incrementAndGet();
                        return stElement;
                    })
                    .toArray(STElement[]::new);
            for (STElement stElement : stElements) {
                str = str.replaceFirst(stElement.getType().getFormat(), String.valueOf(stElement.getValue()));
            }
        }
        System.out.println(str);
        return null;
    }

    @Override
    public String[] visitOutputIdList(gParser.OutputIdListContext ctx) {
        return (String[]) this.visit(ctx.idList());
    }
}

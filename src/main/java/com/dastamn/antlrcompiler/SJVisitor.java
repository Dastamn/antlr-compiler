package com.dastamn.antlrcompiler;

import com.dastamn.antlrcompiler.entities.*;
import com.dastamn.antlrcompiler.gen.gBaseVisitor;
import com.dastamn.antlrcompiler.gen.gParser;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.antlr.v4.runtime.tree.ParseTree;

public class SJVisitor extends gBaseVisitor {
//    private Stack<String> rpnStack = new Stack<String>();
//    private Stack<String> operatorsStack = new Stack<String>();
//    private int tempCount = 1;
//    private String leftTemp;
//    private String rightTemp;
//    private String affect;
//    private Stack<String> tempStack = new Stack<String>();
//    private final LinkedList<QuadRiles> quads;
    private final Map<String, STElement> symbolTable;
    private QuadGen quadGen;
    private final Scanner scanner;
    private boolean ioImport;
    private boolean langImport;


    SJVisitor(Map<String, STElement> symbolTable, /*LinkedList<QuadRiles> quads,*/ QuadGen quadGen) {
        this.symbolTable = symbolTable;
//        this.quads = quads;
        this.scanner = new Scanner(System.in);
        this.ioImport = this.langImport = false;
        this.quadGen = quadGen;
    }

    @Override
    public Object visitImportLib(gParser.ImportLibContext ctx) {
        if (ctx.lib() != null) {
            if (ctx.lib().getText().equals("Small_Java.lang")) {
                langImport = true;
            } else if (ctx.lib().getText().equals("Small_Java.io")) {
                ioImport = true;
            } else {
                Logger.warn("Unknown library: " + ctx.lib().getText() + ".");
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
//            quads.add(new QuadRiles("=", id, tempStack.pop(), id));
//            tempCount = 1;
            stElement.setValue(v);
            quadGen.drainQuads(id);
        } else {
            Logger.notDeclared(id);
        }
        return null;
    }

    @Override
    public Value visitExpParen(gParser.ExpParenContext ctx) {
        return (Value) this.visit(ctx.expression());
    }

    @Override
    public Value visitTimes(gParser.TimesContext ctx) {
        if (!langImport) {
            Logger.libraryNotImported("Small_Java.lang");
        }
        quadGen.makeQuad(ctx.getChild(0), ctx.getChild(2), ctx.TIMES().getText());
//        makeQuad("*", ctx.getChild(0), ctx.getChild(2));
//        makeRPN(ctx.getChild(0), ctx.getChild(1), ctx.getChild(2));
        return ((Value) this.visit(ctx.expression(0))).times((Value) this.visit(ctx.expression(1)));
    }

    @Override
    public Value visitDiv(gParser.DivContext ctx) {
        if (!langImport) {
            Logger.libraryNotImported("Small_Java.lang");
        }
        quadGen.makeQuad(ctx.getChild(0), ctx.getChild(2), ctx.DIV().getText());
//        makeQuad("/", ctx.getChild(0), ctx.getChild(2));
//        makeRPN(ctx.getChild(0), ctx.getChild(1), ctx.getChild(2));
        return ((Value) this.visit(ctx.expression(0))).div((Value) this.visit(ctx.expression(1)));
    }

    @Override
    public Value visitPlus(gParser.PlusContext ctx) {
        if (!langImport) {
            Logger.libraryNotImported("Small_Java.lang");
        }
        quadGen.makeQuad(ctx.getChild(0), ctx.getChild(2), ctx.PLUS().getText());
//        makeQuad("+", ctx.getChild(0), ctx.getChild(2));
//        makeRPN(ctx.getChild(0), ctx.getChild(1), ctx.getChild(2));
        return ((Value) this.visit(ctx.expression(0))).plus((Value) this.visit(ctx.expression(1)));
    }

    @Override
    public Value visitMinus(gParser.MinusContext ctx) {
        if (!langImport) {
            Logger.libraryNotImported("Small_Java.lang");
        }
        quadGen.makeQuad(ctx.getChild(0), ctx.getChild(2), ctx.MINUS().getText());
//        makeQuad("-", ctx.getChild(0), ctx.getChild(2));
//        makeRPN(ctx.getChild(0), ctx.getChild(1), ctx.getChild(2));
        return ((Value) this.visit(ctx.expression(0))).minus((Value) this.visit(ctx.expression(1)));
    }

    @Override
    public Value visitUnaryMinus(gParser.UnaryMinusContext ctx) {
        if (!langImport) {
            Logger.libraryNotImported("Small_Java.lang");
        }
        quadGen.makeQuad(ctx.getChild(1), null, "*");
        return ((Value) this.visit(ctx.expression())).neg();
    }

    @Override
    public Value visitNumber(gParser.NumberContext ctx) {
        String number = ctx.getText().replace(",", ".");
        return number.contains(".") ? new Value(Float.parseFloat(number)) : new Value(Integer.parseInt(number));
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
    public Boolean visitEvalParen(gParser.EvalParenContext ctx) {
        return (Boolean) this.visit(ctx.evaluation());
    }

    @Override
    public Boolean visitComp(gParser.CompContext ctx) {
        Value left = (Value) this.visit(ctx.expression(0));
        Value right = (Value) this.visit(ctx.expression(1));
        if (left.isString() || right.isString()) {
            Logger.error("Can't evaluate a \"" + Type.STRING_SJ + "\" type.");
        }
        switch (ctx.evalOperand().getText()) {
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
    public Boolean visitOr(gParser.OrContext ctx) {
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

//    private void makeQuad(String signe, ParseTree left, ParseTree right) {
//        // affect = tempStack.isEmpty() ? "result" : tempStack.pop();
//        System.out.println("temp: " + tempStack);
//        if (tempStack.isEmpty()) {
//            affect = "result";
//            tempStack.push(affect);
//        } else {
//            affect = tempStack.pop();
//        }
//        if (right.getChildCount() > 1) {
//            rightTemp = "temp" + tempCount++;
//            tempStack.push(rightTemp);
//        } else {
//            rightTemp = right.getText();
//        }
//        if (left.getChildCount() > 1) {
//            leftTemp = "temp" + tempCount++;
//            tempStack.push(leftTemp);
//        } else {
//            leftTemp = left.getText();
//        }
//        quads.add(new QuadRiles(signe, leftTemp, rightTemp, affect));
//        System.out.println(tempStack.toString());
//    }
//
//    private void makeRPN(ParseTree left, ParseTree root, ParseTree right) {
//        operatorsStack.push(root.getText());
//        if (left.getChildCount() <= 1) rpnStack.push(left.getText());
//        if (right.getChildCount() <= 1) {
//            rpnStack.push(right.getText());
//            rpnStack.push(operatorsStack.pop());
//        }
//        System.out.println(rpnStack.toString());
//        System.out.println(operatorsStack.toString());
//    }
}

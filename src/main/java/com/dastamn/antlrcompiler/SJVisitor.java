package com.dastamn.antlrcompiler;

import com.dastamn.antlrcompiler.entities.*;
import com.dastamn.antlrcompiler.gen.gBaseVisitor;
import com.dastamn.antlrcompiler.gen.gParser;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SJVisitor extends gBaseVisitor {

    private final SymbolTable symbolTable;
    private QuadGen quadGen;
    private Stack<Boolean> evalStack;
    private final Scanner scanner;
    private Set<Library> libraries;

    SJVisitor() {
        this.symbolTable = new SymbolTable();
        this.quadGen = new QuadGen();
        this.evalStack = new Stack<>();
        this.scanner = new Scanner(System.in);
        this.libraries = new HashSet<>();
    }

    @Override
    public Object visitImportLib(gParser.ImportLibContext ctx) {
        for (Library library : Library.values()) {
            if (library.getName().equals(ctx.lib().getText())) {
                if (libraries.contains(library)) {
                    Logger.warn("duplicate import: " +library );
                } else {
                    libraries.add(library);
                }
                break;
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
            Value value = (Value) this.visit(ctx.expression());
            if (evalStack.isEmpty() || evalStack.peek()) {
                stElement.setValue(value);
                if (ctx.expression().getChildCount() == 1) {
                    quadGen.affect(id, value);
                }
            }
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
        if (!libraries.contains(Library.LANG)) {
            Logger.missingLibrary(Library.LANG);
        }
        quadGen.makeQuad(ctx.getChild(0), ctx.getChild(2), ctx.TIMES().getText());
        return ((Value) this.visit(ctx.expression(0))).times((Value) this.visit(ctx.expression(1)));
    }

    @Override
    public Value visitDiv(gParser.DivContext ctx) {
        if (!libraries.contains(Library.LANG)) {
            Logger.missingLibrary(Library.LANG);
        }
        quadGen.makeQuad(ctx.getChild(0), ctx.getChild(2), ctx.DIV().getText());
        return ((Value) this.visit(ctx.expression(0))).div((Value) this.visit(ctx.expression(1)));
    }

    @Override
    public Value visitPlus(gParser.PlusContext ctx) {
        if (!libraries.contains(Library.LANG)) {
            Logger.missingLibrary(Library.LANG);
        }
        quadGen.makeQuad(ctx.getChild(0), ctx.getChild(2), ctx.PLUS().getText());
        return ((Value) this.visit(ctx.expression(0))).plus((Value) this.visit(ctx.expression(1)));
    }

    @Override
    public Value visitMinus(gParser.MinusContext ctx) {
        if (!libraries.contains(Library.LANG)) {
            Logger.missingLibrary(Library.LANG);
        }
        quadGen.makeQuad(ctx.getChild(0), ctx.getChild(2), ctx.MINUS().getText());
        return ((Value) this.visit(ctx.expression(0))).minus((Value) this.visit(ctx.expression(1)));
    }

    @Override
    public Value visitUnaryMinus(gParser.UnaryMinusContext ctx) {
        if (!libraries.contains(Library.LANG)) {
            Logger.missingLibrary(Library.LANG);
        }
        quadGen.makeQuad(ctx.getChild(1), null, "-");
        return ((Value) this.visit(ctx.expression())).neg();
    }

    @Override
    public Value visitNumber(gParser.NumberContext ctx) {
        String number = ctx.getText().replace(",", ".");
        return number.contains(".") ? new Value(Float.parseFloat(number)) : new Value(Integer.parseInt(number));
    }

    @Override
    public Value visitStr(gParser.StrContext ctx) {
        if (!libraries.contains(Library.LANG)) {
            Logger.missingLibrary(Library.LANG);
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
                return new Value(stElement.getValue().getRaw());
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
        quadGen.makeQuad(ctx.getChild(0), ctx.getChild(2), ctx.evalOperand().getText());
        quadGen.drainQuads(null);
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
        Boolean res = (Boolean) this.visit(ctx.evaluation());
        quadGen.makeQuad(null, null, ctx.NOT().getText());
        return !res;
    }

    @Override
    public Boolean visitAnd(gParser.AndContext ctx) {
        Boolean left = (Boolean) this.visit(ctx.evaluation(0));
        Boolean right = (Boolean) this.visit(ctx.evaluation(1));
        quadGen.makeQuad(ctx.getChild(0), ctx.getChild(2), ctx.AND().getText());
        quadGen.drainQuads(null);
        return left && right;
    }

    @Override
    public Boolean visitOr(gParser.OrContext ctx) {
        Boolean left = (Boolean) this.visit(ctx.evaluation(0));
        Boolean right = (Boolean) this.visit(ctx.evaluation(1));
        quadGen.makeQuad(ctx.getChild(0), ctx.getChild(2), ctx.OR().getText());
        quadGen.drainQuads(null);
        return left || right;
    }

    @Override
    public Object visitCondition(gParser.ConditionContext ctx) {
        boolean noExe = !evalStack.isEmpty() && !evalStack.peek();
        boolean res = (Boolean) this.visit(ctx.ifStatement());
        evalStack.push(!noExe && res);
        this.visit(ctx.thenBlock());
        quadGen.updateLastJump();
        if (!noExe) {
            evalStack.push(!evalStack.pop());
        }
        if (ctx.elseBlock() != null) {
            this.visit(ctx.elseBlock());
        }
        evalStack.pop();
        return null;
    }

    @Override
    public Boolean visitIfStatement(gParser.IfStatementContext ctx) {
        return (Boolean) this.visit(ctx.evaluation());
    }

    @Override
    public Object visitThenBlock(gParser.ThenBlockContext ctx) {
        quadGen.jump();
        return super.visitThenBlock(ctx);
    }

    @Override
    public Object visitInput(gParser.InputContext ctx) {
        if (!libraries.contains(Library.IO)) {
            Logger.missingLibrary(Library.IO);
        }
        if (evalStack.isEmpty() || evalStack.peek()) {
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
        }
        return null;
    }

    @Override
    public Object visitOutput(gParser.OutputContext ctx) {
        if (!libraries.contains(Library.IO)) {
            Logger.missingLibrary(Library.IO);
        }
        if (evalStack.isEmpty() || evalStack.peek()) {
            this.visit(ctx.outputArgs());
        }
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

    @Override
    public Object visitEnd(gParser.EndContext ctx) {
        symbolTable.print();
        quadGen.print();
        return null;
    }
}

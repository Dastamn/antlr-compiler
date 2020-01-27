package com.dastamn.antlrcompiler;

import com.dastamn.antlrcompiler.entities.*;
import com.dastamn.antlrcompiler.gen.gBaseVisitor;
import com.dastamn.antlrcompiler.gen.gParser;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Visitor extends gBaseVisitor<Object> {

    private final SymbolTable symbolTable;
    private final Queue<Boolean> evalQueue;
    private final Set<Library> libraries;
    private final Scanner scanner;
    private boolean isEffective;

    Visitor(SymbolTable symbolTable, Queue<Boolean> evalQueue) {
        this.symbolTable = symbolTable;
        this.evalQueue = evalQueue;
        this.libraries = new HashSet<>();
        this.scanner = new Scanner(System.in);
        this.isEffective = evalQueue.isEmpty() || evalQueue.peek();
    }

    @Override
    public Object visitImportLib(gParser.ImportLibContext ctx) {
        for (Library library : Library.values()) {
            if (library.getName().equals(ctx.lib().getText())) {
                if (libraries.contains(library)) {
                    Logger.warn("Duplicate import: " + library);
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
                    if (symbolTable.containsKey(id)) {
                        Logger.error("Identifier '" + id + "' already declared");
                    }
                    if (id.length() > 10) {
                        Logger.error("Identifier must not exceed 10 characters: '" + id + "'");
                    }
                    symbolTable.put(id, new STElement(id, type));
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
            if (isEffective) {
                stElement.setValue(value);
            }
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
        return ((Value) this.visit(ctx.expression(0))).times((Value) this.visit(ctx.expression(1)));
    }

    @Override
    public Value visitDiv(gParser.DivContext ctx) {
        if (!libraries.contains(Library.LANG)) {
            Logger.missingLibrary(Library.LANG);
        }
        return ((Value) this.visit(ctx.expression(0))).div((Value) this.visit(ctx.expression(1)));
    }

    @Override
    public Value visitPlus(gParser.PlusContext ctx) {
        if (!libraries.contains(Library.LANG)) {
            Logger.missingLibrary(Library.LANG);
        }
        return ((Value) this.visit(ctx.expression(0))).plus((Value) this.visit(ctx.expression(1)));
    }

    @Override
    public Value visitMinus(gParser.MinusContext ctx) {
        if (!libraries.contains(Library.LANG)) {
            Logger.missingLibrary(Library.LANG);
        }
        return ((Value) this.visit(ctx.expression(0))).minus((Value) this.visit(ctx.expression(1)));
    }

    @Override
    public Value visitUnaryMinus(gParser.UnaryMinusContext ctx) {
        if (!libraries.contains(Library.LANG)) {
            Logger.missingLibrary(Library.LANG);
        }
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
            Logger.error("Can't evaluate a '" + Type.STRING_SJ + "' type in: " + ctx.getText());
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
        return !(Boolean) this.visit(ctx.evaluation());
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
        boolean eval = (Boolean) this.visit(ctx.ifStatement());
        isEffective = eval;
        evalQueue.offer(eval);
        this.visit(ctx.thenBlock());
        if (ctx.elseBlock() != null) {
            isEffective = !isEffective;
            evalQueue.offer(isEffective);
            this.visit(ctx.elseBlock());
        }
        isEffective = true;
        evalQueue.offer(true);
        return null;
    }

    @Override
    public Boolean visitIfStatement(gParser.IfStatementContext ctx) {
        return (Boolean) this.visit(ctx.evaluation());
    }

    @Override
    public Object visitInput(gParser.InputContext ctx) {
        if (!libraries.contains(Library.IO)) {
            Logger.missingLibrary(Library.IO);
        }
        if (isEffective) {

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
            Logger.error("Count mismatch: " + (ids.length > formats.length ? "more" : "less") +
                    " identifiers than type formats in input instruction: " + ctx.getText());
        }
        for (int i = 0; i < formats.length; i++) {
            String format = formats[i];
            switch (format) {
                case "%d": {
                    STElement stElement = stElements[i];
                    if (stElement.getType() != Type.INT_SJ) {
                        Logger.formatMismatch("%d", stElement.getType().getFormat(), ids[i], ctx.getText());
                    }
                    break;
                }
                case "%f": {
                    STElement stElement = stElements[i];
                    if (stElement.getType() != Type.FLOAT_SJ) {
                        Logger.formatMismatch("%f", stElement.getType().getFormat(), ids[i], ctx.getText());
                    }
                    break;
                }
                case "%s": {
                    STElement stElement = stElements[i];
                    if (stElement.getType() != Type.STRING_SJ) {
                        Logger.formatMismatch("%s", stElement.getType().getFormat(), ids[i], ctx.getText());
                    }
                    break;
                }
            }
        }
        if (isEffective) {
            Arrays.stream(stElements).forEach(stElement -> {
                System.out.print("In_SJ: ");
                try {
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
                } catch (InputMismatchException e) {
                    Logger.error("Type mismatch: expected '" + stElement.getType() +
                            "' for identifier '" + stElement + "'");
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
        this.visit(ctx.outputArgs());
        return null;
    }

    @Override
    public Object visitOutputArgs(gParser.OutputArgsContext ctx) {
        String str = ctx.strFormat().getText()
                .substring(1, ctx.strFormat().getText().length() - 1)
                .replaceAll("\\\\\"", "\"");
        if (ctx.outputIdList() != null) {
            String[] ids = (String[]) this.visit(ctx.outputIdList());
            Pattern pattern = Pattern.compile("%[dfs]");
            Matcher matcher = pattern.matcher(str);
            String[] formats = matcher.results()
                    .map(MatchResult::group)
                    .toArray(String[]::new);
            if (ids.length > formats.length) {
                Logger.error("Count mismatch: more identifiers than type formats in output instruction: " +
                        ctx.getParent().getText());
            }
            AtomicInteger index = new AtomicInteger(0);
            STElement[] stElements = Arrays.stream(ids)
                    .map(id -> {
                        STElement stElement = symbolTable.get(id);
                        if (stElement == null) {
                            Logger.notDeclared(id);
                        } else {
                            if (!stElement.getType().getFormat().equals(formats[index.get()])) {
                                Logger.formatMismatch(formats[index.get()], stElement.getType().getFormat(), id,
                                        ctx.getParent().getText());
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
        if (isEffective) {
            System.out.println("Out_SJ: " + str);
        }
        return null;
    }

    @Override
    public String[] visitOutputIdList(gParser.OutputIdListContext ctx) {
        return (String[]) this.visit(ctx.idList());
    }
}

package com.dastamn.antlrcompiler;

import com.dastamn.antlrcompiler.entities.QuadGen;
import com.dastamn.antlrcompiler.entities.STElement;
import com.dastamn.antlrcompiler.entities.SymbolTable;
import com.dastamn.antlrcompiler.gen.gBaseListener;
import com.dastamn.antlrcompiler.gen.gParser;

import java.util.Arrays;
import java.util.Queue;

public class Listener extends gBaseListener {

    private final QuadGen quadGen;
    private final SymbolTable symbolTable;
    private final Queue<Boolean> evalQueue;

    public Listener(SymbolTable symbolTable, Queue<Boolean> evalQueue) {
        this.quadGen = new QuadGen();
        this.symbolTable = symbolTable;
        this.evalQueue = evalQueue;
    }

    @Override
    public void exitAffectation(gParser.AffectationContext ctx) {
        quadGen.affect(ctx.ID().getText(),
                ctx.expression().getChildCount() > 1 ? null : ctx.expression().getText(),
                evalQueue.isEmpty() ? true : evalQueue.peek());
    }

    @Override
    public void exitTimes(gParser.TimesContext ctx) {
        quadGen.makeQuad(ctx.getChild(0), ctx.getChild(2), ctx.TIMES().getText(),
                evalQueue.isEmpty() ? true : evalQueue.peek());
    }

    @Override
    public void exitDiv(gParser.DivContext ctx) {
        quadGen.makeQuad(ctx.getChild(0), ctx.getChild(2), ctx.DIV().getText(),
                evalQueue.isEmpty() ? true : evalQueue.peek());
    }

    @Override
    public void exitPlus(gParser.PlusContext ctx) {
        quadGen.makeQuad(ctx.getChild(0), ctx.getChild(2), ctx.PLUS().getText(),
                evalQueue.isEmpty() ? true : evalQueue.peek());
    }

    @Override
    public void exitMinus(gParser.MinusContext ctx) {
        quadGen.makeQuad(ctx.getChild(0), ctx.getChild(2), ctx.MINUS().getText(),
                evalQueue.isEmpty() ? true : evalQueue.peek());
    }

    @Override
    public void exitUnaryMinus(gParser.UnaryMinusContext ctx) {
        quadGen.makeQuad(ctx.getChild(1), null, ctx.MINUS().getText(),
                evalQueue.isEmpty() ? true : evalQueue.peek());
    }

    @Override
    public void enterEvalParen(gParser.EvalParenContext ctx) {
//        System.out.println("enter eval paren");
    }

    @Override
    public void exitEvalParen(gParser.EvalParenContext ctx) {
//        System.out.println("exit eval paren");
    }

    @Override
    public void exitComp(gParser.CompContext ctx) {
        quadGen.makeQuad(ctx.getChild(0), ctx.getChild(2), ctx.evalOperand().getText(),
                evalQueue.isEmpty() ? true : evalQueue.peek());
    }

    @Override
    public void exitAnd(gParser.AndContext ctx) {
        quadGen.makeQuad(ctx.getChild(0), ctx.getChild(2), ctx.AND().getText(),
                evalQueue.isEmpty() ? true : evalQueue.peek());
    }

    @Override
    public void exitOr(gParser.OrContext ctx) {
        quadGen.makeQuad(ctx.getChild(0), ctx.getChild(2), ctx.OR().getText(),
                evalQueue.isEmpty() ? true : evalQueue.peek());
    }

    @Override
    public void exitNot(gParser.NotContext ctx) {
        quadGen.makeQuad(null, null, ctx.NOT().getText(), evalQueue.isEmpty() ? true : evalQueue.peek());
    }

    @Override
    public void enterThenBlock(gParser.ThenBlockContext ctx) {
        evalQueue.poll();
        quadGen.eval(evalQueue.isEmpty() ? true : evalQueue.peek());
    }

    @Override
    public void exitThenBlock(gParser.ThenBlockContext ctx) {
        quadGen.updateJump();
    }

    @Override
    public void enterElseBlock(gParser.ElseBlockContext ctx) {
        quadGen.updateJump();
        evalQueue.poll();
        quadGen.jump(evalQueue.isEmpty() ? true : evalQueue.peek());
    }

    @Override
    public void exitElseBlock(gParser.ElseBlockContext ctx) {
        quadGen.updateJump();
        quadGen.purgeJumps();
        evalQueue.poll();
    }

    @Override
    public void exitInput(gParser.InputContext ctx) {
        String[] idList = ctx.idList().getText().split(",");
        Arrays.stream(idList).forEach(id -> {
            STElement stElement = symbolTable.get(id);
            quadGen.affect(stElement.getName(), stElement.getValue(), evalQueue.isEmpty() ? true : evalQueue.peek());
        });
    }

    @Override
    public void exitAxiom(gParser.AxiomContext ctx) {
        symbolTable.print();
        quadGen.print();
    }
}

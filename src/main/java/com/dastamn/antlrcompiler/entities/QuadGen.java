package com.dastamn.antlrcompiler.entities;

import org.antlr.v4.runtime.tree.ParseTree;

import java.util.*;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class QuadGen {

    private final Quads quads;
    private final Stack<Quad> jumpStack;
    private Stack<Integer> jumpCount;
    private int tempIndex;
    private String acc;
    private List<AssemblyInst> assembly;

    public QuadGen() {
        this.quads = new Quads();
        this.jumpStack = new Stack<>();
        this.jumpCount = new Stack<>();
        this.assembly = new ArrayList<>();
        this.tempIndex = -1;
    }

    public void makeQuad(ParseTree left, ParseTree right, String operator, boolean isEffective) {
        String leftString = parseTreeToString(left);
        String rightString = parseTreeToString(right);
        if (leftString != null && rightString != null &&
                leftString.startsWith("temp") && rightString.startsWith("temp")) {
            String temp = leftString;
            leftString = rightString;
            rightString = temp;
        }
        quads.add(new Quad(isEffective)
                .setLeftOperand(leftString != null ? leftString : "temp" + tempIndex)
                .setRightOperand(rightString)
                .setOperator(operator)
                .setContainer("temp" + (leftString != null ? ++tempIndex : tempIndex)));
    }

    public void affect(String id, String value, boolean isEffective) {
        if (value == null) {
            quads.get(quads.size() - 1).setContainer(id);
            tempIndex = -1;
        } else {
            quads.add(new Quad(isEffective)
                    .setContainer(id)
                    .setLeftOperand(value)
                    .setOperator(":="));
        }
    }

    public void affect(String id, Value value, boolean isEffective) {
        quads.add(new Quad(isEffective)
                .setContainer(id)
                .setLeftOperand(value.toString())
                .setOperator(":="));
    }

    public void jump(boolean isEffective) {
        Quad quad = new Quad(isEffective).setOperator("BR");
        quads.add(quad);
        jumpStack.push(quad);
        incrementJumpCount();
    }

    public void eval(boolean isEffective) {
        String lastOperation = quads.get(quads.size() - 1).getOperator();
        String type;
        switch (lastOperation) {
            case "<":
                type = "BGE";
                break;
            case "<=":
                type = "BG";
                break;
            case ">":
                type = "BLE";
                break;
            case ">=":
                type = "BL";
                break;
            case "=":
                type = "BNE";
                break;
            case "!=":
                type = "BE";
                break;
            case "!":
                type = "BZ";
                break;
            default:
                type = "BNZ";
                break;
        }
        Quad quad = new Quad(isEffective).setOperator(type).setRightOperand("temp" + tempIndex);
        quads.add(quad);
        jumpStack.push(quad);
        jumpCount.push(1);
    }

    public void updateJump() {
        Quad quad = jumpStack.peek();
        quad.setLeftOperand(String.valueOf(quad.getLeftOperand() != null ?
                Integer.parseInt(quad.getLeftOperand()) + 1 :
                quads.size() + 1));
    }

    public void purgeJumps() {
        int count = jumpCount.pop();
        while (count > 0) {
            jumpStack.pop();
            count--;
        }
    }

    private void incrementJumpCount() {
        int count = jumpCount.pop();
        jumpCount.push(++count);
    }

    private String parseTreeToString(ParseTree parseTree) {
        if (parseTree == null) return null;
        String output;
        if (parseTree.getChildCount() > 1) {
            output = "temp" + (tempIndex > -1 ? tempIndex-- : tempIndex);
        } else {
            output = parseTree.getText();
        }
        return output;
    }

    public void generateCode() {
        Stack<AssemblyInst> jumpStack = new Stack<>();
        Set<String> labels = new HashSet<>();
        for (int i = 1; i <= quads.size(); i++) {
            Quad quad = quads.get(i - 1);
            if (quad.isConditionalJump()) {
                int jumpValue = Integer.parseInt(quad.getLeftOperand());
                assembly.get(assembly.size() - 1).setJumpIndex(jumpValue <= quads.size() ? jumpValue : -1);
                labels.add(quad.getLeftOperand());
                while (!jumpStack.isEmpty()) {
                    AssemblyInst jump = jumpStack.pop();
                    if (jump.isJumpToIf()) {
                        jump.setJumpIndex(i + 1);
                        labels.add(String.valueOf(i + 1));
                    }
                    if (!jump.isJumpToIf() && jump.isJumpToElse()) {
                        jump.setJumpIndex(quad.getLeftOperand());
                    }
                }
            }
            if (quad.isUnconditionalJump()) {
                int brJump = Integer.parseInt(quad.getLeftOperand());
                if (brJump < quads.size()) {
                    assembly.add(new AssemblyInst(acc, "JUMP").setJumpIndex(quad.getLeftOperand()));
                    labels.add(quad.getLeftOperand());
                } else {
                    assembly.add(new AssemblyInst(acc, "JUMP").setJumpIndex(-1));
                }
            }
            String indexString = String.valueOf(i);
            if (!quad.isAffect() && !quad.isEval() && !quad.isJump()) {
                getInAcc(quad, indexString, labels);
            }
            genAssembly(quad, indexString, jumpStack, labels);
        }
    }

    public void getInAcc(Quad quad, String indexString, Set<String> labels) {
        AssemblyInst inst = new AssemblyInst(acc);
        if (!labels.isEmpty() && labels.contains(indexString)) {
            inst.setLabel(indexString);
            labels.remove(indexString);
        }
        if (acc == null || !quad.isEffective()) {
            inst.setInstruction("LOAD " + quad.getLeftOperand());
            if (acc != null && !quad.isEffective()) {
                if (!acc.startsWith("temp") && !quad.getLeftOperand().equals(acc)) {
                    assembly.add(new AssemblyInst(acc, "STORE " + acc));
                    inst.setAcc(acc);
                }
            } else {
                inst.setAcc(quad.getLeftOperand());
            }
            assembly.add(inst);
            acc = quad.isEffective() ? quad.getLeftOperand() : acc;
        } else if (acc.equals(quad.getRightOperand()) && !quad.getOperator().matches("[-/]")) {
            quad.swapOperands();
        } else if (!acc.equals(quad.getLeftOperand()) || quad.getOperator().matches("[-/]")) {
            if (!acc.equals(quad.getLeftOperand())) {
                inst.setInstruction("STORE " + acc);
                assembly.add(inst);
                assembly.add(new AssemblyInst(quad.getLeftOperand(), "LOAD " + quad.getLeftOperand()));
            }
            acc = quad.getLeftOperand();
        }
    }

    public void genAssembly(Quad quad, String indexString, Stack<AssemblyInst> jumpStack, Set<String> labels) {
        AssemblyInst inst = new AssemblyInst(acc);
        if (!labels.isEmpty() && labels.contains(indexString)) {
            inst.setLabel(indexString);
            labels.remove(indexString);
        }
        if (!quad.getOperator().matches("[&|]") && !quad.getOperator().equals("!")) {
            AssemblyInst assemblyInst = new AssemblyInst(acc);
            if (!labels.isEmpty() && labels.contains(indexString)) {
                assemblyInst.setLabel(indexString);
                labels.remove(indexString);
            }
            if (quad.getOperator().equals(":=")) {
                assemblyInst.setInstruction("MOV " + quad.getContainer() + " " + quad.getLeftOperand());
                assembly.add(assemblyInst);
            } else {
                if (quad.isEffective()) {
                    assemblyInst.setAcc(quad.getContainer());
                    acc = quad.getContainer();
                }
                switch (quad.getOperator()) {
                    case "*":
                        assemblyInst.setInstruction("MULT" + " " + quad.getRightOperand());
                        assembly.add(assemblyInst);
                        break;
                    case "/":
                        assemblyInst.setInstruction("DIV" + " " + quad.getRightOperand());
                        assembly.add(assemblyInst);
                        break;
                    case "+":
                        assemblyInst.setInstruction("ADD" + " " + quad.getRightOperand());
                        assembly.add(assemblyInst);
                        break;
                    case "-":
                        assemblyInst.setInstruction("SUB" + " " + quad.getRightOperand());
                        assembly.add(assemblyInst);
                        break;
                    case "<":
                        assemblyInst.setInstruction("CMP " + quad.getLeftOperand() + " " + quad.getRightOperand());
                        assembly.add(assemblyInst);
                        AssemblyInst jge = new AssemblyInst(acc, "JGE");
                        jumpStack.push(jge);
                        assembly.add(jge);
                        break;
                    case "<=":
                        assemblyInst.setInstruction("CMP " + quad.getLeftOperand() + " " + quad.getRightOperand());
                        assembly.add(assemblyInst);
                        AssemblyInst jg = new AssemblyInst(acc, "JG");
                        jumpStack.push(jg);
                        assembly.add(jg);
                        break;
                    case ">":
                        assemblyInst.setInstruction("CMP " + quad.getLeftOperand() + " " + quad.getRightOperand());
                        assembly.add(assemblyInst);
                        AssemblyInst jle = new AssemblyInst(acc, "JLE");
                        jumpStack.push(jle);
                        assembly.add(jle);
                        break;
                    case ">=":
                        assemblyInst.setInstruction("CMP " + quad.getLeftOperand() + " " + quad.getRightOperand());
                        assembly.add(assemblyInst);
                        AssemblyInst jl = new AssemblyInst(acc, "JL");
                        jumpStack.push(jl);
                        assembly.add(jl);
                        break;
                    case "=":
                        assemblyInst.setInstruction("BNE " + quad.getLeftOperand() + " " + quad.getRightOperand());
                        assembly.add(assemblyInst);
                        jumpStack.push(assemblyInst);
                        break;
                    case "!=":
                        assemblyInst.setInstruction("BE " + quad.getLeftOperand() + " " + quad.getRightOperand());
                        assembly.add(assemblyInst);
                        jumpStack.push(assemblyInst);
                        break;
                    default:
                        break;
                }
                if (quad.getContainer() != null && !quad.getContainer().startsWith("temp")) {
                    assembly.add(new AssemblyInst(acc, "STORE " + quad.getContainer()));
                }
            }
        } else {
            switch (quad.getOperator()) {
                case "&":
                    jumpStack.get(jumpStack.size() - 1).setJumpToElse(true);
                    jumpStack.get(jumpStack.size() - 2).setJumpToElse(true);
                    break;
                case "|":
                    jumpStack.get(jumpStack.size() - 1).setJumpToElse(true);
                    jumpStack.get(jumpStack.size() - 2).negateInst().setJumpToIf(true);
                    break;
                case "!":
                    jumpStack.get(jumpStack.size() - 1).negateInst();
                    System.out.println("here: " + jumpStack);
                    break;
                default:
                    break;
            }
        }

        /*switch (quad.getOperator()) {
            case ":=":
                inst.setInstruction("MOV " + quad.getContainer() + " " + quad.getLeftOperand());
                assembly.add(inst);
                break;
            case "*":
                inst.setInstruction("MULT" + " " + quad.getRightOperand());
                if(quad.isEffective()) {
                    inst.setAcc(quad.getContainer());
                    acc = quad.getContainer();
                }
                assembly.add(inst);
                break;
            case "/":
                inst.setInstruction("DIV" + " " + quad.getRightOperand());
                if(quad.isEffective()) {
                    inst.setAcc(quad.getContainer());
                    acc = quad.getContainer();
                }
                assembly.add(inst);
                break;
            case "+":
                inst.setInstruction("ADD" + " " + quad.getRightOperand());
                if(quad.isEffective()) {
                    inst.setAcc(quad.getContainer());
                    acc = quad.getContainer();
                    System.out.println("maj acc: " + quad + ", acc = " + acc);
                }
                assembly.add(inst);
                break;
            case "-":
                inst.setInstruction(quad.getRightOperand() == null ? "CHS" : "SUB" + " " + quad.getRightOperand());
                if(quad.isEffective()) {
                    inst.setAcc(quad.getContainer());
                    acc = quad.getContainer();
                }
                assembly.add(inst);
                break;
            case "=":
                inst.setInstruction("BNE " + quad.getLeftOperand() + " " + quad.getRightOperand());
                assembly.add(inst);
                jumpStack.push(inst);
                // add jump to else
                break;
            case "!=":
                inst.setInstruction("BE " + quad.getLeftOperand() + " " + quad.getRightOperand());
                assembly.add(inst);
                jumpStack.push(inst);
                break;
            case "<":
                inst.setInstruction("CMP " + quad.getLeftOperand() + " " + quad.getRightOperand());
                assembly.add(inst);
                inst = new AssemblyInst(acc, "JGE");
                jumpStack.push(inst);
                assembly.add(inst);
                break;
            case "<=":
                inst.setInstruction("CMP " + quad.getLeftOperand() + " " + quad.getRightOperand());
                assembly.add(inst);
                inst = new AssemblyInst(acc, "JG");
                jumpStack.push(inst);
                assembly.add(inst);
                break;
            case ">":
                inst.setInstruction("CMP " + quad.getLeftOperand() + " " + quad.getRightOperand());
                assembly.add(inst);
                inst = new AssemblyInst(acc, "JLE");
                jumpStack.push(inst);
                assembly.add(inst);
                break;
            case ">=":
                inst.setInstruction("CMP " + quad.getLeftOperand() + " " + quad.getRightOperand());
                assembly.add(inst);
                inst = new AssemblyInst(acc, "JL");
                jumpStack.push(inst);
                assembly.add(inst);
                break;
            case "&":
                jumpStack.get(jumpStack.size() - 1).setJumpToElse(true);
                jumpStack.get(jumpStack.size() - 2).setJumpToElse(true);
                break;
            case "|":
                jumpStack.get(jumpStack.size() - 1).setJumpToElse(true);
                jumpStack.get(jumpStack.size() - 2).negateInst().setJumpToIf(true);
                break;
            case "!":
                jumpStack.get(jumpStack.size() - 1).negateInst();
                break;
            default:
                break;
        }*/
    }

    public void print() {
        generateCode();
        System.out.println(this + "\n");
        quads.printTable();
        assembly.forEach(inst -> System.out.println(inst.getAcc() + "\t|\t" + inst.getInstruction()));
    }

    @Override
    public String toString() {
        AtomicInteger index = new AtomicInteger(0);
        return "Quads: {" + "\n" +
                quads.stream().reduce("", (acc, curr) ->
                                acc + "\t" + index.incrementAndGet() + "- " + curr + "\n",
                        (acc, curr) -> acc + curr) +
                "}\n\n" +
                "Assembly: {" + "\n" + assembly.stream()
                .map(AssemblyInst::toString)
                .reduce("", (acc, curr) -> acc.isEmpty() ? "\t" + curr : acc + "\n\t" + curr) + "\n" +
                "}";
    }
}
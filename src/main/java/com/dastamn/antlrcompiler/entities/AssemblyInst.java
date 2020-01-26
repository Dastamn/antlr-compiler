package com.dastamn.antlrcompiler.entities;

public class AssemblyInst {

    private String instruction;
    private String label;
    private String jumpIndex;
    private String acc;
    private boolean jumpToIf;
    private boolean jumpToElse;

    public AssemblyInst(String acc) {
        this.acc = acc;
    }

    public AssemblyInst(String acc, String instruction) {
        this.acc = acc;
        this.instruction = instruction;
    }

    public String getAcc() {
        return acc;
    }

    public String getInstruction() {
        return instruction;
    }

    public AssemblyInst setInstruction(String instruction) {
        this.instruction = instruction;
        return this;
    }

    public AssemblyInst setJumpIndex(String jumpIndex) {
        this.jumpIndex = jumpIndex;
        return this;
    }

    public AssemblyInst setJumpIndex(int jumpIndex) {
        this.jumpIndex = String.valueOf(jumpIndex);
        return this;
    }

    public String getLabel() {
        return label;
    }

    public AssemblyInst setLabel(String label) {
        this.label = label;
        return this;
    }

    public boolean hasLabel() {
        return label != null;
    }

    public AssemblyInst setAcc(String acc) {
        this.acc = acc;
        return this;
    }

    public boolean isJumpToIf() {
        return jumpToIf;
    }

    public void setJumpToIf(boolean jumpToIf) {
        this.jumpToIf = jumpToIf;
    }

    public boolean isJumpToElse() {
        return jumpToElse;
    }

    public void setJumpToElse(boolean jumpToElse) {
        this.jumpToElse = jumpToElse;
    }

    public AssemblyInst negateInst() {
        switch (instruction.split(" ")[0]) {
            case "BNE":
                instruction = instruction.replaceFirst("BNE", "BE");
                break;
            case "BE":
                instruction = instruction.replaceFirst("BE", "BNE");
                break;
            case "JGE":
                instruction = instruction.replaceFirst("JGE", "JL");
                break;
            case "JG":
                instruction = instruction.replaceFirst("JG", "JLE");
                break;
            case "JLE":
                instruction = instruction.replaceFirst("JLE", "JG");
                break;
            case "JL":
                instruction = instruction.replaceFirst("JL", "JGE");
                break;
            default:
                break;
        }
        return this;
    }

    @Override
    public String toString() {
        return (label != null ? "J" + label + ": " : "") +
                instruction + " " +
                (jumpIndex != null ? jumpIndex.equals("-1") ? jumpIndex : "J" + jumpIndex : "");
    }
}

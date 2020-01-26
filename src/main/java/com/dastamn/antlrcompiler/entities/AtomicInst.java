package com.dastamn.antlrcompiler.entities;

public class AtomicInst extends AssemblyInstruction {

    private String instruction;
    private String label;
    private String jump;

    public String getInstruction() {
        return instruction;
    }

    public void setInstruction(String instruction) {
        this.instruction = instruction;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getJump() {
        return jump;
    }

    public void setJump(String jump) {
        this.jump = jump;
    }

    public AssemblyInstruction neg() {
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
                (jump != null ? jump.equals("-1") ? jump : "J" + jump : "");
    }
}

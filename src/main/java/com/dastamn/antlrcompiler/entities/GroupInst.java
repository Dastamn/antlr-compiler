package com.dastamn.antlrcompiler.entities;

import java.util.ArrayList;
import java.util.List;

public class GroupInst extends AssemblyInstruction {

    private List<AtomicInst> instructions;
    private String jump;
    private String label;

    public GroupInst() {
        this.instructions = new ArrayList<>();
    }

    public GroupInst(AtomicInst atomicInst) {
        this.instructions = new ArrayList<>() {{
            add(atomicInst);
        }};
    }

    public GroupInst(List<AtomicInst> instructions) {
        this.instructions = instructions;
    }

    public void addInstruction(AtomicInst atomicInst) {
        instructions.add(atomicInst);
    }

    public String getJump() {
        return jump;
    }

    public void setJump(String jump) {
        this.jump = jump;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder(label != null ? "J" + label + ": " : "");
        for (int i = 0; i < instructions.size(); i++) {
            if (i == instructions.size() - 1) {
                instructions.get(i).setJump(jump);
            }
            builder.append(instructions.get(i)).append("\n");
        }
        return builder.toString();
    }
}

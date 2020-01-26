package com.dastamn.antlrcompiler.entities;

public class AssemblyInstruction {

    protected boolean isJumpToIf;
    protected boolean isJumpToElse;

    public boolean isJumpToIf() {
        return isJumpToIf;
    }

    public void setJumpToIf(boolean jumpToIf) {
        isJumpToIf = jumpToIf;
    }

    public boolean isJumpToElse() {
        return isJumpToElse;
    }

    public void setJumpToElse(boolean jumpToElse) {
        isJumpToElse = jumpToElse;
    }
}

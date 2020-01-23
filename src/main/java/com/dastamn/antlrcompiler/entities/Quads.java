package com.dastamn.antlrcompiler.entities;

import java.util.ArrayList;

public class Quads extends ArrayList<Quad> {

    public void printTable() {
        String format = "| %-25s | %-10s | %-15s |%n";
        StringBuilder builder = new StringBuilder("Object Code:\n");
        builder.append("+---------------------------+------------+-----------------+\n");
        builder.append("| Quads                     | Acc        | Code            |\n");
        builder.append("+---------------------------+------------+-----------------+\n");
        this.forEach(quad -> {
            if (quad.hasCode() && !quad.isJump() && !quad.isEval()) {
                builder.append(String.format(format, quad,
                        quad.getFirstInst()[0], quad.getFirstInst()[1]));
                if (quad.hasManyInstructions()) {
                    for (int i = 1; i < quad.getInstCount(); i++) {
                        builder.append(String.format(format, "", quad.instAt(i)[0], quad.instAt(i)[1]));
                    }
                }
            }
        });
        builder.append("+---------------------------+------------+-----------------+\n");
        System.out.println(builder);
    }

}

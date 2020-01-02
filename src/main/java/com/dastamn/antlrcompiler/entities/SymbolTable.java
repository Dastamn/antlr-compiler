package com.dastamn.antlrcompiler.entities;

import com.dastamn.antlrcompiler.Logger;

import java.util.HashMap;

public class SymbolTable extends HashMap<String, STElement> {

    public void print() {
        String format = "| %-11s | %-11s | %-11s |%n";
        StringBuilder builder = new StringBuilder("\nSymbol Table:\n");
        builder.append("+-------------+-------------+-------------+\n");
        builder.append("| Identifier  | Type        | Value       |\n");
        builder.append("+-------------+-------------+-------------+\n");
        this.forEach((key, value) -> {
            if (value.getValue() == null) {
                Logger.warn("Identifier \"" + key + "\" not used.");
            }
            builder.append(String.format(format, key, value.getType().getTypeName(), value.getValue()));
        });
        builder.append("+-------------+-------------+-------------+\n");
        System.out.println(builder);
    }

}

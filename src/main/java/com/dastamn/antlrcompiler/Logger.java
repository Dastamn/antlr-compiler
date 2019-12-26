package com.dastamn.antlrcompiler;

import com.dastamn.antlrcompiler.entities.QuadGen;
import com.dastamn.antlrcompiler.entities.STElement;
import com.dastamn.antlrcompiler.entities.Type;
import org.slf4j.LoggerFactory;

import java.util.Map;

public class Logger {

    private final static org.slf4j.Logger logger;

    static {
        logger = LoggerFactory.getLogger("Logger");
    }

    public static void info(String msg) {
        logger.info(msg);
    }

    static void warn(String msg) {
        logger.warn(msg);
    }

    public static void error(String msg) {
        logger.error(msg);
        System.exit(1);
    }

    static void stLog(Map<String, STElement> symbolTable) {
        String format = "| %-11s | %-11s | %-11s |%n";
        StringBuilder builder = new StringBuilder("Symbol Table:\n");
        builder.append("+-------------+-------------+-------------+\n");
        builder.append("| Identifier  | Type        | Value       |\n");
        builder.append("+-------------+-------------+-------------+\n");
        symbolTable.forEach((key, value) -> {
            if (value.getValue() == null) {
                logger.warn("Identifier \"" + key + "\" not used.");
            }
            builder.append(String.format(format, key, value.getType().getTypeName(), value.getValue()));
        });
        builder.append("+-------------+-------------+-------------+\n");
        System.out.println(builder);
    }

    static void notDeclared(String id) {
        error("Identifier \"" + id + "\" not declared.");
    }

    static void notInitialised(String id) {
        error("Identifier \"" + id + "\" not initialised.");
    }

    public static void typeMismatch(String found, String expected, String id) {
        error("Type mismatch: found \"" + found + "\" expected \"" + expected + "\" for \"" + id + "\".");
    }

    static void formatMismatch(String found, String expected, String id) {
        error("Format mismatch: found \"" + found + "\" expected \"" + expected + "\" for \"" + id + "\".");
    }

    static void libraryNotImported(String lib) {
        error("Library \"" + lib + "\" not imported.");
    }

    public static void noStringInArithm() {
        error("Can't use type \"" + Type.STRING_SJ + "\" in arithmetic expressions.");
    }
}

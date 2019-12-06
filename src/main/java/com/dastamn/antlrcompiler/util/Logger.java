package com.dastamn.antlrcompiler.util;

import com.dastamn.antlrcompiler.core.STElement;
import com.dastamn.antlrcompiler.core.Type;
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

    public static void error(String msg) {
        logger.error(msg);
        System.exit(1);
    }

    public static void warn(String msg) {
        logger.warn(msg);
    }

    public static void stLog(Map<String, STElement> symbolTable) {
        symbolTable.forEach((key, value) -> {
            if (value.getValue() == null) {
                logger.warn("Identifier \"" + key + "\" not used.");
            }
        });
        logger.info("Symbol Table: " + symbolTable);
    }

    public static void notDeclared(String id) {
        error("Identifier \"" + id + "\" not declared.");
    }

    public static void notInitialised(String id) {
        error("Identifier \"" + id + "\" not initialised.");
    }

    public static void typeMismatch(String found, String expected, String id) {
        error("Type mismatch: found \"" + found + "\" expected \"" + expected + "\" for \"" + id + "\".");
    }

    public static void formatMismatch(String found, String expected, String id) {
        error("Format mismatch: found \"" + found + "\" expected \"" + expected + "\" for \"" + id + "\".");
    }

    public static void libraryNotImported(String lib) {
        error("Library \"" + lib + "\" not imported.");
    }

    public static void noStringInArithm() {
        error("Can't use type \"" + Type.STRING_SJ + "\" in arithmetic expressions.");
    }
}

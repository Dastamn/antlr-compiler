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

    public static void warn(String msg) {
        logger.warn(msg);
    }

    public static void error(String msg) {
        logger.error(msg);
        System.exit(1);
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

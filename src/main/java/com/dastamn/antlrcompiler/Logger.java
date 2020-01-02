package com.dastamn.antlrcompiler;

import com.dastamn.antlrcompiler.entities.Library;
import com.dastamn.antlrcompiler.entities.Type;

public class Logger {

    public static void warn(String msg) {
        System.err.println("WARN: " + msg);
    }

    public static void error(String msg) {
        System.err.println("ERROR: " + msg);
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

    static void missingLibrary(Library library) {
        error("missing import: " + library );
    }

    public static void noStringInArithm() {
        error("Can't use type \"" + Type.STRING_SJ + "\" in arithmetic expressions.");
    }
}

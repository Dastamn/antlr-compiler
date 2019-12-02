package com.dastamn.antlrcompiler.util;

import java.util.logging.Level;

public class Logger {

    private final static java.util.logging.Logger logger;

    static {
        logger = java.util.logging.Logger.getLogger("Logger");
    }

    public static void info(String msg) {
        logger.info(msg);
    }

    public static void error(String msg) {
        logger.log(Level.SEVERE, msg);
        System.exit(Level.SEVERE.intValue());
    }

    public static void warn(String msg) {
        logger.log(Level.WARNING, msg);
    }
}

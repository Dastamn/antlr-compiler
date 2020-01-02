package com.dastamn.antlrcompiler;

import org.antlr.v4.runtime.*;

public class ErrorListener extends BaseErrorListener {
    @Override
    public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine,
                            String msg, RecognitionException e) {
        StringBuilder builder = new StringBuilder("line " + line + ":" + charPositionInLine + " " + msg + "\n");
        underlineError(recognizer, (Token) offendingSymbol, line, charPositionInLine, builder);
    }

    protected void underlineError(Recognizer<?, ?> recognizer, Token offendingToken, int line,
                                  int charPositionInLine, StringBuilder msg) {
        CommonTokenStream tokens = (CommonTokenStream) recognizer.getInputStream();
        String input = tokens.getTokenSource().getInputStream().toString();
        String[] lines = input.split("\n");
        msg.append(lines[line - 2]).append("\n");
        msg.append(lines[line - 1]).append("\n");
        for (int i = 0; i < charPositionInLine; i++) {
            msg.append(" ");
        }
        int start = offendingToken.getStartIndex();
        int stop = offendingToken.getStopIndex();
        if (start >= 0 && stop >= 0) {
            for (int i = start; i <= stop; i++) {
                msg.append("^");
            }
        }
        Logger.error(msg.toString());
    }
}

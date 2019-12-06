package com.dastamn.antlrcompiler;

import com.dastamn.antlrcompiler.core.STElement;
import com.dastamn.antlrcompiler.gen.gLexer;
import com.dastamn.antlrcompiler.gen.gParser;
import com.dastamn.antlrcompiler.impl.SJListener;
import com.dastamn.antlrcompiler.impl.SJVisitor;
import com.dastamn.antlrcompiler.util.Logger;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Compiler {

    public static void main(String[] args) {
        gLexer lexer = null;
        try {
            lexer = new gLexer(CharStreams.fromFileName("src/main/resources/text.txt"));
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
        CommonTokenStream tokenStream = new CommonTokenStream(lexer);
        gParser parser = new gParser(tokenStream);
        ParseTree tree = parser.axiom();
        Map<String, STElement> symbolTable = new HashMap<>();
        userVisitor(symbolTable, tree);
        Logger.stLog(symbolTable);
    }

    private static void useListener(Map<String, STElement> symbolTable, ParseTree tree) {
        ParseTreeWalker walker = new ParseTreeWalker();
        walker.walk(new SJListener(symbolTable), tree);
    }

    private static void userVisitor(Map<String, STElement> symbolTable, ParseTree tree) {
        SJVisitor visitor = new SJVisitor(symbolTable);
        visitor.visit(tree);
    }
}

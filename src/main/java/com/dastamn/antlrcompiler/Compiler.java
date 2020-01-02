package com.dastamn.antlrcompiler;

import com.dastamn.antlrcompiler.gen.gLexer;
import com.dastamn.antlrcompiler.gen.gParser;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.IOException;

public class Compiler {

    public static void main(String[] args) {
        gLexer lexer = null;
        try {
            lexer = new gLexer(CharStreams.fromFileName("src/main/resources/algo"));
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
        CommonTokenStream tokenStream = new CommonTokenStream(lexer);
        gParser parser = new gParser(tokenStream);
        parser.removeErrorListeners();
        parser.addErrorListener(new ErrorListener());
        ParseTree tree = parser.axiom();
        SJVisitor visitor = new SJVisitor();
        visitor.visit(tree);
    }
}

package com.dastamn.antlrcompiler;

import com.dastamn.antlrcompiler.entities.Quad;
import com.dastamn.antlrcompiler.entities.QuadGen;
import com.dastamn.antlrcompiler.entities.STElement;
import com.dastamn.antlrcompiler.entities.QuadRiles;
import com.dastamn.antlrcompiler.gen.gLexer;
import com.dastamn.antlrcompiler.gen.gParser;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.IOException;
import java.util.*;

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
        ParseTree tree = parser.axiom();
        Map<String, STElement> symbolTable = new HashMap<>();
//        LinkedList<QuadRiles> quads = new LinkedList<QuadRiles>();
        QuadGen quadGen = new QuadGen();
        SJVisitor visitor = new SJVisitor(symbolTable, /*quads,*/ quadGen);
        visitor.visit(tree);
        Logger.stLog(symbolTable);
        System.out.println(quadGen);
    }
}

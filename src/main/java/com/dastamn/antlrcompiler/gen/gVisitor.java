// Generated from D:/IdeaProjects/antlrcompiler/src/main/resources\g.g4 by ANTLR 4.7.2
package com.dastamn.antlrcompiler.gen;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link gParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface gVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link gParser#axiom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAxiom(gParser.AxiomContext ctx);
	/**
	 * Visit a parse tree produced by {@link gParser#progName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgName(gParser.ProgNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link gParser#varDec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarDec(gParser.VarDecContext ctx);
	/**
	 * Visit a parse tree produced by {@link gParser#idList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdList(gParser.IdListContext ctx);
	/**
	 * Visit a parse tree produced by {@link gParser#progDesc}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgDesc(gParser.ProgDescContext ctx);
	/**
	 * Visit a parse tree produced by {@link gParser#instruction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInstruction(gParser.InstructionContext ctx);
	/**
	 * Visit a parse tree produced by {@link gParser#affectation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAffectation(gParser.AffectationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Div}
	 * labeled alternative in {@link gParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDiv(gParser.DivContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Number}
	 * labeled alternative in {@link gParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumber(gParser.NumberContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Times}
	 * labeled alternative in {@link gParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTimes(gParser.TimesContext ctx);
	/**
	 * Visit a parse tree produced by the {@code UnaryMinus}
	 * labeled alternative in {@link gParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryMinus(gParser.UnaryMinusContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Id}
	 * labeled alternative in {@link gParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitId(gParser.IdContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Plus}
	 * labeled alternative in {@link gParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPlus(gParser.PlusContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Minus}
	 * labeled alternative in {@link gParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMinus(gParser.MinusContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Paren}
	 * labeled alternative in {@link gParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParen(gParser.ParenContext ctx);
	/**
	 * Visit a parse tree produced by {@link gParser#condition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCondition(gParser.ConditionContext ctx);
	/**
	 * Visit a parse tree produced by {@link gParser#ifStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStatement(gParser.IfStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link gParser#thenBlock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitThenBlock(gParser.ThenBlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link gParser#elseBlock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElseBlock(gParser.ElseBlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link gParser#evaluation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEvaluation(gParser.EvaluationContext ctx);
	/**
	 * Visit a parse tree produced by {@link gParser#scan}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitScan(gParser.ScanContext ctx);
	/**
	 * Visit a parse tree produced by {@link gParser#print}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrint(gParser.PrintContext ctx);
	/**
	 * Visit a parse tree produced by {@link gParser#str}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStr(gParser.StrContext ctx);
}
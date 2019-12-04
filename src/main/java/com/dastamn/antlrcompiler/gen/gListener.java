// Generated from D:/IdeaProjects/antlrcompiler/src/main/resources\g.g4 by ANTLR 4.7.2
package com.dastamn.antlrcompiler.gen;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link gParser}.
 */
public interface gListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link gParser#axiom}.
	 * @param ctx the parse tree
	 */
	void enterAxiom(gParser.AxiomContext ctx);
	/**
	 * Exit a parse tree produced by {@link gParser#axiom}.
	 * @param ctx the parse tree
	 */
	void exitAxiom(gParser.AxiomContext ctx);
	/**
	 * Enter a parse tree produced by {@link gParser#progName}.
	 * @param ctx the parse tree
	 */
	void enterProgName(gParser.ProgNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link gParser#progName}.
	 * @param ctx the parse tree
	 */
	void exitProgName(gParser.ProgNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link gParser#varDec}.
	 * @param ctx the parse tree
	 */
	void enterVarDec(gParser.VarDecContext ctx);
	/**
	 * Exit a parse tree produced by {@link gParser#varDec}.
	 * @param ctx the parse tree
	 */
	void exitVarDec(gParser.VarDecContext ctx);
	/**
	 * Enter a parse tree produced by {@link gParser#idList}.
	 * @param ctx the parse tree
	 */
	void enterIdList(gParser.IdListContext ctx);
	/**
	 * Exit a parse tree produced by {@link gParser#idList}.
	 * @param ctx the parse tree
	 */
	void exitIdList(gParser.IdListContext ctx);
	/**
	 * Enter a parse tree produced by {@link gParser#progDesc}.
	 * @param ctx the parse tree
	 */
	void enterProgDesc(gParser.ProgDescContext ctx);
	/**
	 * Exit a parse tree produced by {@link gParser#progDesc}.
	 * @param ctx the parse tree
	 */
	void exitProgDesc(gParser.ProgDescContext ctx);
	/**
	 * Enter a parse tree produced by {@link gParser#instruction}.
	 * @param ctx the parse tree
	 */
	void enterInstruction(gParser.InstructionContext ctx);
	/**
	 * Exit a parse tree produced by {@link gParser#instruction}.
	 * @param ctx the parse tree
	 */
	void exitInstruction(gParser.InstructionContext ctx);
	/**
	 * Enter a parse tree produced by {@link gParser#affectation}.
	 * @param ctx the parse tree
	 */
	void enterAffectation(gParser.AffectationContext ctx);
	/**
	 * Exit a parse tree produced by {@link gParser#affectation}.
	 * @param ctx the parse tree
	 */
	void exitAffectation(gParser.AffectationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Div}
	 * labeled alternative in {@link gParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterDiv(gParser.DivContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Div}
	 * labeled alternative in {@link gParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitDiv(gParser.DivContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Number}
	 * labeled alternative in {@link gParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterNumber(gParser.NumberContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Number}
	 * labeled alternative in {@link gParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitNumber(gParser.NumberContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Times}
	 * labeled alternative in {@link gParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterTimes(gParser.TimesContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Times}
	 * labeled alternative in {@link gParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitTimes(gParser.TimesContext ctx);
	/**
	 * Enter a parse tree produced by the {@code UnaryMinus}
	 * labeled alternative in {@link gParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterUnaryMinus(gParser.UnaryMinusContext ctx);
	/**
	 * Exit a parse tree produced by the {@code UnaryMinus}
	 * labeled alternative in {@link gParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitUnaryMinus(gParser.UnaryMinusContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Id}
	 * labeled alternative in {@link gParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterId(gParser.IdContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Id}
	 * labeled alternative in {@link gParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitId(gParser.IdContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Plus}
	 * labeled alternative in {@link gParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterPlus(gParser.PlusContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Plus}
	 * labeled alternative in {@link gParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitPlus(gParser.PlusContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Minus}
	 * labeled alternative in {@link gParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterMinus(gParser.MinusContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Minus}
	 * labeled alternative in {@link gParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitMinus(gParser.MinusContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Paren}
	 * labeled alternative in {@link gParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterParen(gParser.ParenContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Paren}
	 * labeled alternative in {@link gParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitParen(gParser.ParenContext ctx);
	/**
	 * Enter a parse tree produced by {@link gParser#condition}.
	 * @param ctx the parse tree
	 */
	void enterCondition(gParser.ConditionContext ctx);
	/**
	 * Exit a parse tree produced by {@link gParser#condition}.
	 * @param ctx the parse tree
	 */
	void exitCondition(gParser.ConditionContext ctx);
	/**
	 * Enter a parse tree produced by {@link gParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void enterIfStatement(gParser.IfStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link gParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void exitIfStatement(gParser.IfStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link gParser#thenBlock}.
	 * @param ctx the parse tree
	 */
	void enterThenBlock(gParser.ThenBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link gParser#thenBlock}.
	 * @param ctx the parse tree
	 */
	void exitThenBlock(gParser.ThenBlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link gParser#elseBlock}.
	 * @param ctx the parse tree
	 */
	void enterElseBlock(gParser.ElseBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link gParser#elseBlock}.
	 * @param ctx the parse tree
	 */
	void exitElseBlock(gParser.ElseBlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link gParser#evaluation}.
	 * @param ctx the parse tree
	 */
	void enterEvaluation(gParser.EvaluationContext ctx);
	/**
	 * Exit a parse tree produced by {@link gParser#evaluation}.
	 * @param ctx the parse tree
	 */
	void exitEvaluation(gParser.EvaluationContext ctx);
	/**
	 * Enter a parse tree produced by {@link gParser#scan}.
	 * @param ctx the parse tree
	 */
	void enterScan(gParser.ScanContext ctx);
	/**
	 * Exit a parse tree produced by {@link gParser#scan}.
	 * @param ctx the parse tree
	 */
	void exitScan(gParser.ScanContext ctx);
	/**
	 * Enter a parse tree produced by {@link gParser#print}.
	 * @param ctx the parse tree
	 */
	void enterPrint(gParser.PrintContext ctx);
	/**
	 * Exit a parse tree produced by {@link gParser#print}.
	 * @param ctx the parse tree
	 */
	void exitPrint(gParser.PrintContext ctx);
}
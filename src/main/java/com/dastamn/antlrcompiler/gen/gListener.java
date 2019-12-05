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
	 * Enter a parse tree produced by {@link gParser#importLib}.
	 * @param ctx the parse tree
	 */
	void enterImportLib(gParser.ImportLibContext ctx);
	/**
	 * Exit a parse tree produced by {@link gParser#importLib}.
	 * @param ctx the parse tree
	 */
	void exitImportLib(gParser.ImportLibContext ctx);
	/**
	 * Enter a parse tree produced by {@link gParser#declaration}.
	 * @param ctx the parse tree
	 */
	void enterDeclaration(gParser.DeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link gParser#declaration}.
	 * @param ctx the parse tree
	 */
	void exitDeclaration(gParser.DeclarationContext ctx);
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
	 * Enter a parse tree produced by {@link gParser#mainBlock}.
	 * @param ctx the parse tree
	 */
	void enterMainBlock(gParser.MainBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link gParser#mainBlock}.
	 * @param ctx the parse tree
	 */
	void exitMainBlock(gParser.MainBlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link gParser#instBlock}.
	 * @param ctx the parse tree
	 */
	void enterInstBlock(gParser.InstBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link gParser#instBlock}.
	 * @param ctx the parse tree
	 */
	void exitInstBlock(gParser.InstBlockContext ctx);
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
	 * Enter a parse tree produced by the {@code Str}
	 * labeled alternative in {@link gParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterStr(gParser.StrContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Str}
	 * labeled alternative in {@link gParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitStr(gParser.StrContext ctx);
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
	 * Enter a parse tree produced by the {@code ExpParen}
	 * labeled alternative in {@link gParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpParen(gParser.ExpParenContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExpParen}
	 * labeled alternative in {@link gParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpParen(gParser.ExpParenContext ctx);
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
	 * Enter a parse tree produced by the {@code Not}
	 * labeled alternative in {@link gParser#evaluation}.
	 * @param ctx the parse tree
	 */
	void enterNot(gParser.NotContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Not}
	 * labeled alternative in {@link gParser#evaluation}.
	 * @param ctx the parse tree
	 */
	void exitNot(gParser.NotContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Or}
	 * labeled alternative in {@link gParser#evaluation}.
	 * @param ctx the parse tree
	 */
	void enterOr(gParser.OrContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Or}
	 * labeled alternative in {@link gParser#evaluation}.
	 * @param ctx the parse tree
	 */
	void exitOr(gParser.OrContext ctx);
	/**
	 * Enter a parse tree produced by the {@code And}
	 * labeled alternative in {@link gParser#evaluation}.
	 * @param ctx the parse tree
	 */
	void enterAnd(gParser.AndContext ctx);
	/**
	 * Exit a parse tree produced by the {@code And}
	 * labeled alternative in {@link gParser#evaluation}.
	 * @param ctx the parse tree
	 */
	void exitAnd(gParser.AndContext ctx);
	/**
	 * Enter a parse tree produced by the {@code EvalParen}
	 * labeled alternative in {@link gParser#evaluation}.
	 * @param ctx the parse tree
	 */
	void enterEvalParen(gParser.EvalParenContext ctx);
	/**
	 * Exit a parse tree produced by the {@code EvalParen}
	 * labeled alternative in {@link gParser#evaluation}.
	 * @param ctx the parse tree
	 */
	void exitEvalParen(gParser.EvalParenContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Comp}
	 * labeled alternative in {@link gParser#evaluation}.
	 * @param ctx the parse tree
	 */
	void enterComp(gParser.CompContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Comp}
	 * labeled alternative in {@link gParser#evaluation}.
	 * @param ctx the parse tree
	 */
	void exitComp(gParser.CompContext ctx);
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
	 * Enter a parse tree produced by {@link gParser#input}.
	 * @param ctx the parse tree
	 */
	void enterInput(gParser.InputContext ctx);
	/**
	 * Exit a parse tree produced by {@link gParser#input}.
	 * @param ctx the parse tree
	 */
	void exitInput(gParser.InputContext ctx);
	/**
	 * Enter a parse tree produced by {@link gParser#output}.
	 * @param ctx the parse tree
	 */
	void enterOutput(gParser.OutputContext ctx);
	/**
	 * Exit a parse tree produced by {@link gParser#output}.
	 * @param ctx the parse tree
	 */
	void exitOutput(gParser.OutputContext ctx);
}
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
	 * Visit a parse tree produced by {@link gParser#importLib}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImportLib(gParser.ImportLibContext ctx);
	/**
	 * Visit a parse tree produced by {@link gParser#declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaration(gParser.DeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link gParser#idList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdList(gParser.IdListContext ctx);
	/**
	 * Visit a parse tree produced by {@link gParser#mainBlock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMainBlock(gParser.MainBlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link gParser#instBlock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInstBlock(gParser.InstBlockContext ctx);
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
	 * Visit a parse tree produced by the {@code Str}
	 * labeled alternative in {@link gParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStr(gParser.StrContext ctx);
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
	 * Visit a parse tree produced by the {@code ExpParen}
	 * labeled alternative in {@link gParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpParen(gParser.ExpParenContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Minus}
	 * labeled alternative in {@link gParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMinus(gParser.MinusContext ctx);
	/**
	 * Visit a parse tree produced by {@link gParser#condition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCondition(gParser.ConditionContext ctx);
	/**
	 * Visit a parse tree produced by {@link gParser#thenBlock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitThenBlock(gParser.ThenBlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link gParser#ifStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStatement(gParser.IfStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Not}
	 * labeled alternative in {@link gParser#evaluation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNot(gParser.NotContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Or}
	 * labeled alternative in {@link gParser#evaluation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOr(gParser.OrContext ctx);
	/**
	 * Visit a parse tree produced by the {@code And}
	 * labeled alternative in {@link gParser#evaluation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnd(gParser.AndContext ctx);
	/**
	 * Visit a parse tree produced by the {@code EvalParen}
	 * labeled alternative in {@link gParser#evaluation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEvalParen(gParser.EvalParenContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Comp}
	 * labeled alternative in {@link gParser#evaluation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComp(gParser.CompContext ctx);
	/**
	 * Visit a parse tree produced by {@link gParser#elseBlock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElseBlock(gParser.ElseBlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link gParser#input}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInput(gParser.InputContext ctx);
	/**
	 * Visit a parse tree produced by {@link gParser#output}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOutput(gParser.OutputContext ctx);
	/**
	 * Visit a parse tree produced by {@link gParser#outputArgs}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOutputArgs(gParser.OutputArgsContext ctx);
	/**
	 * Visit a parse tree produced by {@link gParser#outputIdList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOutputIdList(gParser.OutputIdListContext ctx);
}
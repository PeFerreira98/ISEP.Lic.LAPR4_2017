// Generated from C:\enginfo\BitBucket repo\lapr4-2017-2dl\src\main\antlr4\lapr4\green\s3\lang\n1970581\formula\compiler\Formula4.g4 by ANTLR 4.4

    package lapr4.green.s3.lang.n1970581.formula.compiler;

import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link Formula4Parser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface Formula4Visitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link Formula4Parser#reference}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReference(@NotNull Formula4Parser.ReferenceContext ctx);
	/**
	 * Visit a parse tree produced by {@link Formula4Parser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(@NotNull Formula4Parser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link Formula4Parser#comparison}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComparison(@NotNull Formula4Parser.ComparisonContext ctx);
	/**
	 * Visit a parse tree produced by {@link Formula4Parser#concatenation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConcatenation(@NotNull Formula4Parser.ConcatenationContext ctx);
	/**
	 * Visit a parse tree produced by {@link Formula4Parser#function_call}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunction_call(@NotNull Formula4Parser.Function_callContext ctx);
	/**
	 * Visit a parse tree produced by {@link Formula4Parser#assignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignment(@NotNull Formula4Parser.AssignmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link Formula4Parser#variable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariable(@NotNull Formula4Parser.VariableContext ctx);
	/**
	 * Visit a parse tree produced by {@link Formula4Parser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(@NotNull Formula4Parser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link Formula4Parser#for_loop}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFor_loop(@NotNull Formula4Parser.For_loopContext ctx);
	/**
	 * Visit a parse tree produced by {@link Formula4Parser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtom(@NotNull Formula4Parser.AtomContext ctx);
	/**
	 * Visit a parse tree produced by {@link Formula4Parser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteral(@NotNull Formula4Parser.LiteralContext ctx);
}
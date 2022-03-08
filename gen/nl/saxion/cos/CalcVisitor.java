// Generated from D:/Prog/COS/Seminar/Week 5 - Codegen/Assignment/src/nl/saxion/cos\Calc.g4 by ANTLR 4.8
package nl.saxion.cos;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link CalcParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface CalcVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link CalcParser#start}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStart(CalcParser.StartContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExNegate}
	 * labeled alternative in {@link CalcParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExNegate(CalcParser.ExNegateContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExMulOp}
	 * labeled alternative in {@link CalcParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExMulOp(CalcParser.ExMulOpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExAddOp}
	 * labeled alternative in {@link CalcParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExAddOp(CalcParser.ExAddOpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExIntLiteral}
	 * labeled alternative in {@link CalcParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExIntLiteral(CalcParser.ExIntLiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExParentheses}
	 * labeled alternative in {@link CalcParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExParentheses(CalcParser.ExParenthesesContext ctx);
}
// Generated from C:/Users/Rita/lab4/src\Grammar.g4 by ANTLR 4.9.2
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link GrammarParser}.
 */
public interface GrammarListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link GrammarParser#start}.
	 * @param ctx the parse tree
	 */
	void enterStart(GrammarParser.StartContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#start}.
	 * @param ctx the parse tree
	 */
	void exitStart(GrammarParser.StartContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#rules}.
	 * @param ctx the parse tree
	 */
	void enterRules(GrammarParser.RulesContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#rules}.
	 * @param ctx the parse tree
	 */
	void exitRules(GrammarParser.RulesContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#nTerm}.
	 * @param ctx the parse tree
	 */
	void enterNTerm(GrammarParser.NTermContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#nTerm}.
	 * @param ctx the parse tree
	 */
	void exitNTerm(GrammarParser.NTermContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#term}.
	 * @param ctx the parse tree
	 */
	void enterTerm(GrammarParser.TermContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#term}.
	 * @param ctx the parse tree
	 */
	void exitTerm(GrammarParser.TermContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#opts}.
	 * @param ctx the parse tree
	 */
	void enterOpts(GrammarParser.OptsContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#opts}.
	 * @param ctx the parse tree
	 */
	void exitOpts(GrammarParser.OptsContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#opt}.
	 * @param ctx the parse tree
	 */
	void enterOpt(GrammarParser.OptContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#opt}.
	 * @param ctx the parse tree
	 */
	void exitOpt(GrammarParser.OptContext ctx);
}
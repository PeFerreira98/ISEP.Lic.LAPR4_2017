/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.red.s2.lang.n1140388.formula.compiler;

import csheets.core.Cell;
import csheets.core.formula.BinaryOperation;
import csheets.core.formula.BinaryOperator;
import csheets.core.formula.Expression;
import csheets.core.formula.Literal;
import csheets.core.formula.compiler.ExpressionCompiler;
import csheets.core.formula.compiler.FormulaCompilationException;
import csheets.core.formula.lang.Language;
import java.util.Collections;
import java.util.List;
import lapr4.red.s2.lang.n1140388.formula.lang.MoneyRate;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.Tree;

/**
 * A compiler that generates Monetary-style formulas from strings.
 *
 * @author Alexandra Ferreira 1140388
 */
public class MonetaryExpressionCompiler implements ExpressionCompiler {

    /**
     * The character that signals that a cell's content is a formula ('#')
     */
    public static final char FORMULA_STARTER = '#';

    private String currencyName;
    public static final MoneyRate ml = new MoneyRate();

    /**
     * Creates the Monetary expression compiler.
     */
    public MonetaryExpressionCompiler() {
    }

    /**
     * Compiles the ANTLR tree and returns a monetary expression
     *
     * @param cell
     * @param source
     * @return
     * @throws FormulaCompilationException
     */
    @Override
    public Expression compile(Cell cell, String source) throws FormulaCompilationException {

        // Creates the lexer and parser
        ANTLRInputStream input = new ANTLRInputStream(source);

        // create the buffer of tokens between the lexer and parser        
        CurrencyLexer lexer = new CurrencyLexer(input);

        CommonTokenStream tokens = new CommonTokenStream(lexer);

        CurrencyParser parser = new CurrencyParser(tokens);

        CurrencyErrorListener formulaErrorListener = new CurrencyErrorListener();
        parser.removeErrorListeners(); // remove default ConsoleErrorListener
        parser.addErrorListener(formulaErrorListener); // add ours

        // Attempts to match an expression
        ParseTree tree = parser.expression();
        if (parser.getNumberOfSyntaxErrors() > 0) {
            throw new FormulaCompilationException(formulaErrorListener.getErrorMessage());
        }

        // Visit the expression and returns it
        CurrencyEvalVisitor eval = new CurrencyEvalVisitor(cell);
        Expression result = eval.visit(tree);
        if (eval.getNumberOfErrors() > 0) {
            throw new FormulaCompilationException(eval.getErrorsMessage());
        }

        return result;
    }

    /**
     * @return the character that initiates the formula
     */
    @Override
    public char getStarter() {
        return FORMULA_STARTER;
    }

    public static class CurrencyErrorListener extends BaseErrorListener {

        private StringBuilder buf;

        public String getErrorMessage() {
            return buf.toString();
        }

        @Override
        public void syntaxError(Recognizer<?, ?> recognizer,
                Object offendingSymbol,
                int line, int charPositionInLine,
                String msg,
                RecognitionException e) {
            List<String> stack = ((Parser) recognizer).getRuleInvocationStack();
            Collections.reverse(stack);

            buf = new StringBuilder();
            buf.append("line ").append(line).append(":").append(charPositionInLine).append(": ").append(msg);
        }
    }
}

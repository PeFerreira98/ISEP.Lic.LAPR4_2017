/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.red.s2.lang.n1140388.formula.compiler;

import csheets.core.Cell;
import csheets.core.formula.Expression;
import csheets.core.formula.compiler.ExpressionCompiler;
import csheets.core.formula.compiler.FormulaCompilationException;
import lapr4.blue.s1.lang.n1141233.formula.compiler.Formula3Lexer;
import lapr4.blue.s1.lang.n1141233.formula.compiler.Formula3Parser;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
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
        Formula3Lexer lexer = new Formula3Lexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);

        Formula3Parser parser = new Formula3Parser(tokens);

        // Attempts to match an expression
        ParseTree tree = parser.expression();
        if (parser.getNumberOfSyntaxErrors() > 0) {
            throw new FormulaCompilationException();
        }

        // Converts the expression and returns it
        return convert(cell, tree);
    }

    /**
     * @return the character that initiates the formula
     */
    @Override
    public char getStarter() {
        return FORMULA_STARTER;
    }

    protected Expression convert(Cell cell, Tree node) throws FormulaCompilationException {
        return null;
    }
}

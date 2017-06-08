/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.red.s2.lang.n1140388.formula.compiler;

import csheets.core.formula.Expression;
import csheets.core.formula.compiler.FormulaCompilationException;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.RuleContext;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Alexandra Ferreira 1140388
 */
public class CurrencyEvalVisitorTest {

    private CurrencyParser parser;
    
    public CurrencyEvalVisitorTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {

        // Creates the lexer and parser
        ANTLRInputStream input = new ANTLRInputStream("euro{1\u20AC}");

        // create the buffer of tokens between the lexer and parser        
        CurrencyLexer lexer = new CurrencyLexer(input);

        CommonTokenStream tokens = new CommonTokenStream(lexer);

        parser = new CurrencyParser(tokens);

        MonetaryExpressionCompiler.CurrencyErrorListener formulaErrorListener = new MonetaryExpressionCompiler.CurrencyErrorListener();
        parser.removeErrorListeners(); // remove default ConsoleErrorListener
        parser.addErrorListener(formulaErrorListener); // add ours

        // Attempts to match an expression
        ParseTree tree = parser.expression();

    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getNumberOfErrors method, of class CurrencyEvalVisitor.
     */
    @Test
    public void testGetNumberOfErrors() {
        System.out.println("getNumberOfErrors");
        CurrencyEvalVisitor instance = new CurrencyEvalVisitor();
        int expResult = 0;
        int result = instance.getNumberOfErrors();
        assertEquals(expResult, result);
    }

    /**
     * Test of getErrorsMessage method, of class CurrencyEvalVisitor.
     */
    @Test
    public void testGetErrorsMessage() {
        System.out.println("getErrorsMessage");
        CurrencyEvalVisitor instance = new CurrencyEvalVisitor();
        String expResult = "";
        String result = instance.getErrorsMessage();
        assertEquals(expResult, result);
    }

    /**
     * Test of visitCurrenciesName method, of class CurrencyEvalVisitor.
     */
    @Test
    public void testVisitCurrenciesName() {
        System.out.println("visitCurrenciesName");
        CurrencyParser.CurrenciesNameContext ctx = new CurrencyParser.CurrenciesNameContext(RuleContext.EMPTY, 0);
        CurrencyEvalVisitor instance = new CurrencyEvalVisitor();
        Expression expResult = null;
        Expression result = instance.visitCurrenciesName(ctx);
        assertEquals(expResult, result);
    }

    /**
     * Test of visitCurrenciesCount method, of class CurrencyEvalVisitor.
     */
    @Test
    public void testVisitCurrenciesCount() {
        System.out.println("visitCurrenciesCount");
        CurrencyParser.CurrenciesCountContext ctx = new CurrencyParser.CurrenciesCountContext(RuleContext.EMPTY, 0);
        CurrencyEvalVisitor instance = new CurrencyEvalVisitor();
        Expression expResult = null;
        Expression result = instance.visitCurrenciesCount(ctx);
        assertEquals(expResult, result);
    }

    /**
     * Test of visitCurrenciesSymb method, of class CurrencyEvalVisitor.
     */
    @Test
    public void testVisitCurrenciesSymb() {
        System.out.println("visitCurrenciesSymb");
        CurrencyParser.CurrenciesSymbContext ctx = new CurrencyParser.CurrenciesSymbContext(RuleContext.EMPTY, 0);
        CurrencyEvalVisitor instance = new CurrencyEvalVisitor();
        Expression expResult = null;
        Expression result = instance.visitCurrenciesSymb(ctx);
        assertEquals(expResult, result);
    }

}

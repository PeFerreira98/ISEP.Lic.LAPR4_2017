/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.red.s2.lang.n1140388.formula.compiler;

import csheets.core.Cell;
import csheets.core.formula.Expression;
import csheets.core.formula.Literal;
import csheets.ext.CellExtension;
import lapr4.red.s2.lang.n1140388.formula.MoneyRate;
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
public class MonetaryExpressionCompilerTest {
    
    public MonetaryExpressionCompilerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getStarter method, of class MonetaryExpressionCompiler.
     */
    @Test
    public void testGetStarter() {
        System.out.println("getStarter");
        MonetaryExpressionCompiler instance = new MonetaryExpressionCompiler();
        char expResult = '#';
        char result = instance.getStarter();
        assertEquals(expResult, result);
    }
    
}

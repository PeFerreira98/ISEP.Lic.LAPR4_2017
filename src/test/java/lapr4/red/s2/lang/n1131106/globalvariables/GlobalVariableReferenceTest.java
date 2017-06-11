/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.red.s2.lang.n1131106.globalvariables;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Nuno Filipe 1131106
 */
public class GlobalVariableReferenceTest {

    public GlobalVariableReferenceTest() {
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
     * Test of getVariable method, of class GlobalVariableReference.
     */
    @Test
    public void testGetVariable() {
        System.out.println("getVariable");
        GlobalVariableReference instance = new GlobalVariableReference("@test");
        String expResult = "@test";
        String result = instance.getVariable();
        assertEquals(expResult, result);
    }

}

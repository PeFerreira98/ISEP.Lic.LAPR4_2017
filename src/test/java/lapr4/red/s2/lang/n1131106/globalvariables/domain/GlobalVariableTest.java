/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.red.s2.lang.n1131106.globalvariables.domain;

import csheets.core.Spreadsheet;
import csheets.core.Value;
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
public class GlobalVariableTest {

    public GlobalVariableTest() {
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
     * Test of getValue method, of class GlobalVariable.
     */
    @Test
    public void testGetValue() {
        System.out.println("getValue");
        GlobalVariable instance = new GlobalVariable("@glob", new Value(25), null);
        Value expResult = new Value(25);
        Value result = instance.getValue();
        assertEquals(expResult, result);
    }

    /**
     * Test of getName method, of class GlobalVariable.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        GlobalVariable instance = new GlobalVariable("@count", new Value(25), null);
        String expResult = "@count";
        String result = instance.getName();
        assertEquals(expResult, result);
    }

    /**
     * Test of setName method, of class GlobalVariable.
     */
    @Test
    public void testSetName() {
        System.out.println("setName");
        String name = "testName";
        GlobalVariable instance = new GlobalVariable();
        instance.setName(name);
        assertEquals(instance.getName(), "testName");
    }

    /**
     * Test of setValue method, of class GlobalVariable.
     */
    @Test
    public void testSetValue() {
        System.out.println("setValue");
        Value value = new Value(12);
        GlobalVariable instance = new GlobalVariable();
        instance.setValue(value);
        assertEquals(instance.getValue(), new Value(12));
    }

    /**
     * Test of getSpreadsheet method, of class GlobalVariable.
     */
    @Test
    public void testGetSpreadsheet() {
        System.out.println("getSpreadsheet");
        GlobalVariable instance = new GlobalVariable("@count", new Value(28), null);
        Spreadsheet expResult = null;
        Spreadsheet result = instance.getSpreadsheet();
        assertEquals(expResult, result);
    }

}

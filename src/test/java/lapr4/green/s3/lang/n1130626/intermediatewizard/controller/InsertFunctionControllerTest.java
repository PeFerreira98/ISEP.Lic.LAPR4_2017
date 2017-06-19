/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.green.s3.lang.n1130626.intermediatewizard.controller;

import csheets.CleanSheets;
import csheets.core.Cell;
import csheets.core.Spreadsheet;
import csheets.core.Workbook;
import csheets.core.formula.BinaryOperator;
import csheets.core.formula.Formula;
import csheets.core.formula.Function;
import csheets.core.formula.compiler.FormulaCompiler;
import csheets.ui.ctrl.UIController;
import lapr4.blue.s1.lang.n1141233.formula.lang.Language;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Pedro Pereira
 */
public class InsertFunctionControllerTest {
    
    public InsertFunctionControllerTest() {
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
     * Test of obtainActiveCell method, of class InsertFunctionController.
     */
    @Test
    public void testObtainActiveCell() {
        System.out.println("obtainActiveCell");
        UIController uiCtrl;
        CleanSheets app;
        Workbook wb;
        Spreadsheet s;
        Cell c1;
        // Try to create the CS application object
        app = new CleanSheets();
        // This will create a workbook with 3 sheets
        app.create();
        
        uiCtrl = new UIController(app);
        wb = new Workbook(2);
        s = wb.getSpreadsheet(0);
        c1 = s.getCell(0,1);
        uiCtrl.setActiveWorkbook(wb);
        uiCtrl.setActiveCell(c1);
        InsertFunctionController instance = new InsertFunctionController(uiCtrl);
        Cell expResult = c1;
        Cell result = instance.obtainActiveCell();
        assertEquals(expResult, result);
    }

    /**
     * Test of getListSupportedFunctions method, of class InsertFunctionController.
     */
    @Test
    public void testGetListSupportedFunctions() {
        System.out.println("getListSupportedFunctions");
        CleanSheets c1 = new CleanSheets();
        UIController u1 = new UIController(c1);
        InsertFunctionController instance = new InsertFunctionController(u1);
        Function[] expResult = Language.getInstance().getFunctions();
        Function[] result = instance.getListSupportedFunctions();
        assertArrayEquals(expResult, result);
    }

   

    /**
     * Test of getFunction method, of class InsertFunctionController.
     */
    @Test
    public void testGetFunction() throws Exception {
        System.out.println("getFunction");
        CleanSheets c1 = new CleanSheets();
        UIController u1 = new UIController(c1);
        String identifier = "FACT";
        InsertFunctionController instance = new InsertFunctionController(u1);
        Function expResult = Language.getInstance().getFunction(identifier);
        Function result = instance.getFunction(identifier);
        assertEquals(expResult, result);
    }

    /**
     * Test of hasFunction method, of class InsertFunctionController.
     */
    @Test
    public void testHasFunction() {
        System.out.println("hasFunction");
        CleanSheets c1 = new CleanSheets();
        UIController u1 = new UIController(c1);
        String identifier = "SUM";
        InsertFunctionController instance = new InsertFunctionController(u1);
        boolean expResult = true;
        boolean result = instance.hasFunction(identifier);
        assertEquals(expResult, result);
    }

    /**
     * Test of getOperator method, of class InsertFunctionController.
     */
    @Test
    public void testGetOperator() throws Exception {
        System.out.println("getOperator");
        CleanSheets c1 = new CleanSheets();
        UIController u1 = new UIController(c1);
        String identifier = "<";
        InsertFunctionController instance = new InsertFunctionController(u1);
        BinaryOperator expResult = Language.getInstance().getBinaryOperator(identifier);
        BinaryOperator result = instance.getOperator(identifier);
        assertEquals(expResult, result);
    }

    /**
     * Test of compileFormula method, of class InsertFunctionController.
     */
    @Test
    public void testCompileFormula() throws Exception {
        System.out.println("compileFormula");
        CleanSheets c1 = new CleanSheets();
        UIController u1 = new UIController(c1);
        String formulaData = "FACT(2)";
        InsertFunctionController instance = new InsertFunctionController(u1);
        Formula expResult = FormulaCompiler.getInstance().compile(null, formulaData);
        Formula result = instance.compileFormula(formulaData);
        assertEquals(expResult, result);
    }
    
}

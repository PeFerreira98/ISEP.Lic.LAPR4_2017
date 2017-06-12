/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.blue.s1.lang.n1140956.ConditionalFormatting;

import csheets.CleanSheets;
import csheets.core.Address;
import csheets.core.Cell;
import csheets.core.CellListener;
import csheets.core.Spreadsheet;
import csheets.core.Value;
import csheets.core.Workbook;
import csheets.core.formula.Formula;
import csheets.core.formula.compiler.FormulaCompilationException;
import csheets.ui.ctrl.UIController;
import java.awt.Color;
import java.awt.Font;
import java.util.SortedSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Marcos
 */
public class CondFormattingControllerTest {

    CleanSheets app;
    Cell[][] arrayCell;
    Workbook wb;
    Spreadsheet s;
    Cell c1;
    Cell c2;
    public CondFormattingControllerTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        
        
        // Try to create the CS application object
        app = new CleanSheets();

        // This will create a workbook with 3 sheets
        app.create();
        
        arrayCell = new Cell[2][2];
        wb = new Workbook(2);
        s = wb.getSpreadsheet(0);
        c1 = s.getCell(0,1);
        c2 = s.getCell(0,0);
        arrayCell[0][0] = c2;
        arrayCell[0][1] = c1;
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of addListener method, of class CondFormattingController.
     */
    @Test
    public void testAddListener() throws FormulaCompilationException {
        System.out.println("addListener");

        String value = "10";
        String operator = ">";
        Cell cell = app.getWorkbooks()[0].getSpreadsheet(0).getCell(new Address(0, 0));

        cell.setContent("15");

        CondFormattingController instance = new CondFormattingController(new UIController(new CleanSheets()));
        CondFormattingListener cl = instance.addListener(value, operator, cell);

        CellListener[] expResult = cell.getCellListeners();

        for (CellListener c : expResult) {
            System.out.println(c);
            if (c instanceof CondFormattingListener) {
                assertEquals(c,cl);
                return;
            } 
        }
        fail();
    }
    
    /**
     * Test of selectionTypeChange method, of class CondFormattingController.
     */
    @Test
    public void testSelectionTypeChange() {
        System.out.println("selectionTypeChange");
        Cell[][] arrayCells = arrayCell;
        CondFormattingController instance = new CondFormattingController(new UIController(new CleanSheets()));
        String expResult = "Multiple Selection";
        String result = instance.selectionTypeChange(arrayCells);
        assertEquals(expResult, result);
    }

}

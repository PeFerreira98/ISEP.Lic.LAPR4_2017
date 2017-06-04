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

}

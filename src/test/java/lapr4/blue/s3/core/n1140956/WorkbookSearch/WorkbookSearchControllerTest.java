/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.blue.s3.core.n1140956.WorkbookSearch;

import csheets.CleanSheets;
import csheets.core.Cell;
import csheets.core.Spreadsheet;
import csheets.core.Workbook;
import csheets.core.formula.compiler.FormulaCompilationException;
import csheets.ui.ctrl.UIController;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Marcos
 */
public class WorkbookSearchControllerTest {
    
    UIController uiCtrl;
    CleanSheets app;
    Workbook wb;
    Spreadsheet s;
    Cell c1;
    public WorkbookSearchControllerTest() {
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
        
        uiCtrl = new UIController(app);
        wb = new Workbook(2);
        s = wb.getSpreadsheet(0);
        c1 = s.getCell(0,1);
        uiCtrl.setActiveWorkbook(wb);
        
        try {
            this.c1.setContent("a");
        } catch (FormulaCompilationException ex) {
            Logger.getLogger(WorkbookSearchControllerTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of checkCell method, of class WorkbookSearchController.
     */
    @Test
    public void testCheckCell() throws FormulaCompilationException {
        System.out.println("checkCell");        
        String input = "a|b";
        
        WorkbookSearchController instance = new WorkbookSearchController(uiCtrl);
        boolean expResult = true;
        boolean result = instance.checkCell(input, c1);
        assertEquals(expResult, result);
    }

    /**
     * Test of search method, of class WorkbookSearchController.
     */
    @Test
    public void testSearch() {
        System.out.println("search");
        String input = "a|b";
        
        ArrayList<Cell> list = new ArrayList<>();
        list.add(c1);
        ArrayList<Cell> expResult = list;
        
        WorkbookSearchController instance = new WorkbookSearchController(uiCtrl);
        instance.search(input);
        assertEquals(expResult, instance.getCellList());
    }


    /**
     * Test of clear method, of class WorkbookSearchController.
     */
    @Test
    public void testClear() {
        System.out.println("clear");
        String input = "a|b";
        WorkbookSearchController instance = new WorkbookSearchController(uiCtrl);
        
        ArrayList<Cell> list = new ArrayList<>();
        instance.search(input);
        instance.clear();
        assertEquals(list, instance.getCellList());
    }
    
}

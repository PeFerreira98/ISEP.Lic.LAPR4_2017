/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.green.s2.core.n1140618.richComments.controller;

import csheets.CleanSheets;
import csheets.core.Cell;
import csheets.core.Spreadsheet;
import csheets.core.Workbook;
import csheets.ui.ctrl.UIController;
import lapr4.green.s2.core.n1140618.richComments.CommentNew;
import lapr4.green.s2.core.n1140618.richComments.ui.commentPanel;
import lapr4.white.s1.core.n1234567.comments.CommentableCell;
import lapr4.white.s1.core.n1234567.comments.CommentsExtension;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Tiago
 */
public class CommentControllerTest {
    
    CommentableCell comCell;
    CommentController instance;
    CommentNew inicial;
    
    public CommentControllerTest() {
        UIController ctrl = new UIController(new CleanSheets());
        commentPanel panel = new commentPanel(ctrl);
        // create a workbook with 2 sheets
        Workbook wb = new Workbook(2);
        Spreadsheet s = wb.getSpreadsheet(0);
        // get the first cell
        Cell c = s.getCell(0, 0);

        // activate the comments on the first cell
        comCell = (CommentableCell) c.getExtension(CommentsExtension.NAME);
        instance = new CommentController(ctrl, panel);
        inicial = new CommentNew("ola", "User", "red", "i", "14");
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
     * Test of setComment method, of class CommentController.
     */
    @Test
    public void testSetComment() {
        System.out.println("setComment");
        String commentString = "OI";
        String userString = "Tiago";
        boolean expResult = true;
        boolean result = instance.setComment(comCell, commentString, userString, "red", "b", "14");
        assertEquals(expResult, result);

    }

    /**
     * Test of editComment method, of class CommentController.
     */
    @Test
    public void testEditComment() {
        System.out.println("editComment");
        CommentNew c = new CommentNew("ola", "user", "red", "strong", "14");
        String comment = "a";
        String author = "b";
        String color = "c";
        String style = "d";
        instance.editComment(comCell, c, comment, author, color, style, "14");
        System.out.println(c.getClass());
        assertTrue(c.getClass() == inicial.getClass());
    }
    
}

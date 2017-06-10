/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.green.s2.core.n1140618.richComments.ui;

import csheets.CleanSheets;
import csheets.core.Cell;
import csheets.core.Spreadsheet;
import csheets.core.Workbook;
import csheets.ui.ctrl.SelectionEvent;
import csheets.ui.ctrl.UIController;
import java.util.ArrayList;
import lapr4.green.s2.core.n1140618.richComments.CommentNew;
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
public class commentPanelTest {
    
    
    
    CommentableCell comCell;
    commentPanel instance;
    
    public commentPanelTest() {
        UIController ctrl = new UIController(new CleanSheets());
        instance = new commentPanel(ctrl);
        // create a workbook with 2 sheets
        Workbook wb = new Workbook(2);
        Spreadsheet s = wb.getSpreadsheet(0);
        // get the first cell
        Cell c = s.getCell(0, 0);

        // activate the comments on the first cell
        comCell = (CommentableCell) c.getExtension(CommentsExtension.NAME);
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
     * Test of addComment method, of class CommentPanel.
     */
    @Test
    public void testAddComment() {
        System.out.println("addComment");
        instance.commentChanged(comCell);
        instance.addComment("OI", "Tiago", "red", "i", "14");
        assertEquals("OI", comCell.getUserComments().get(0).getContent());

    }
    
}

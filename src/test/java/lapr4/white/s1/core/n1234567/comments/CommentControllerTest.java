/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.white.s1.core.n1234567.comments;

import csheets.CleanSheets;
import csheets.core.Address;
import csheets.core.Cell;
import csheets.core.CellImpl;
import csheets.core.Spreadsheet;
import csheets.core.SpreadsheetImpl;
import csheets.core.Workbook;
import csheets.ext.CellExtension;
import csheets.ui.ctrl.UIController;
import java.util.ArrayList;
import java.util.List;
import lapr4.red.s1.core.n1140376.comments.Comment;
import lapr4.white.s1.core.n1234567.comments.CommentableCell;
import lapr4.white.s1.core.n1234567.comments.CommentableCellListener;
import lapr4.white.s1.core.n1234567.comments.ui.CommentController;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author i140376
 */
public class CommentControllerTest {
    List<Comment> list;
    Comment c1;
    Comment c2;
    CleanSheets app;
    Workbook wb;
    Spreadsheet s;
    Cell c;
    CommentableCell cc1;
    CommentController cct1;
    UIController uic1;
    public CommentControllerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        list = new ArrayList<>();
        c1 = new Comment("Ze","c1");
        c2 = new Comment("ZeZe","c2");
        list.add(c1);
        list.add(c2);
        wb = new Workbook(2);
        s = wb.getSpreadsheet(0);
        c = s.getCell(0, 0);
        cc1 = new CommentableCell(c);
        cc1.addComment("Ze", "c1");
        cc1.addComment("ZeZe", "c2");
        app = new CleanSheets();
        uic1 = new UIController(app);
        cct1 = new CommentController(uic1,c);
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
        CommentableCell cell = cc1;
        String commentString = "comment1";
        CommentController instance = cct1;
        boolean expResult = true;
        boolean result = instance.setComment(cell, commentString);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of getCommentList method, of class CommentController.
     */
    @Test
    public void testGetCommentList() {
        System.out.println("getCommentList");
        CommentableCell cell = cc1;
        CommentController instance = cct1;
        List<Comment> expResult = list;
        List<Comment> result = instance.getCommentList(cell);
        assertEquals(expResult, result);
        
    }
    
}

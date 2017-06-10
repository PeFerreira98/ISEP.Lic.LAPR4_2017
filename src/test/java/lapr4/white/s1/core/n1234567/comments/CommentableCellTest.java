package lapr4.white.s1.core.n1234567.comments;

import lapr4.white.s1.core.n1234567.comments.CommentableCellListener;
import lapr4.white.s1.core.n1234567.comments.CommentableCell;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import csheets.core.Cell;
import csheets.core.Spreadsheet;
import csheets.core.Workbook;
import java.util.ArrayList;
import java.util.List;
import lapr4.green.s2.core.n1140618.richComments.CommentNew;
import lapr4.red.s1.core.n1140376.comments.Comment;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;

/**
 * A Unit Test class to test CommentableCell.
 *
 * @see CommentableCell
 * @author Alexandre Braganca
 */
public class CommentableCellTest {

    private boolean isNotified = false;

    // create a workbook with 2 sheets
    Workbook wb = new Workbook(2);
    Spreadsheet s = wb.getSpreadsheet(0);
    // get the first cell
    Cell c = s.getCell(0, 0);

    // activate the comments on the first cell
    CommentableCell cc = new CommentableCell(c);

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    /**
     * A method that tests the property hasComment.
     */
    @Test
    public void testHasComment() {

        // create a workbook with 2 sheets
        Workbook wb = new Workbook(2);
        Spreadsheet s = wb.getSpreadsheet(0);
        // get the first cell
        Cell c = s.getCell(0, 0);

        // activate the comments on the first cell
        CommentableCell cc = new CommentableCell(c);

        boolean hasComment = cc.hasComments();

        assertTrue(hasComment == false);

        cc.setUserComment("user", "coment", "blue", "strong", "14");

        hasComment = cc.hasComments();

        assertTrue(hasComment);
    }

    /**
     * A method that tests the setter and getter of the user comment.
     */
    @Test
    public void testSetGetUserComment() {

        // create a workbook with 2 sheets
        Workbook wb = new Workbook(2);
        Spreadsheet s = wb.getSpreadsheet(0);
        // get the first cell
        Cell c = s.getCell(0, 0);

        // activate the comments on the first cell
        CommentableCell cc = new CommentableCell(c);

        cc.setUserComment("user", "Hello", "i", "strong", "14");

        assertTrue(cc.hasComments());
    }

    /**
     * A method that tests the notifications for commented cell listeners.
     *
     * @see CommentableCellListener
     */
    @Test
    public void testCommentableCellListenner() {

        // create a workbook with 2 sheets
        Workbook wb = new Workbook(2);
        Spreadsheet s = wb.getSpreadsheet(0);
        // get the first cell
        Cell c = s.getCell(0, 0);

        // activate the comments on the first cell
        CommentableCell cc = new CommentableCell(c);

        CommentableCellListener listener = new CommentableCellListenerImpl();

        cc.addCommentableCellListener(listener);

        // modify the cell... this should create an event
        cc.addComment("user", "Hello");

        assertTrue(isNotified);
    }

    /**
     * A inner utility class used by the method testCommentableCellListenner.
     */
    class CommentableCellListenerImpl implements CommentableCellListener {

        @Override
        public void commentChanged(CommentableCell cell) {
            isNotified = true;
        }

    }

    /**
     * Test of addCommentableCellListener method, of class CommentableCell.
     */
    @Test
    public void testAddCommentableCellListener() {
        CommentableCellListener listener = new CommentableCellListenerImpl();

        cc.addCommentableCellListener(listener);

        // modify the cell... this should create an event
        cc.setUserComment("Hello", "User", "red", "strong", "14");

        assertTrue(isNotified);
    }

    /**
     * Test of removeCommentableCellListener method, of class CommentableCell.
     */
    @Test
    public void testRemoveCommentableCellListener() {
        CommentableCellListener listener = new CommentableCellListenerImpl();

        cc.removeCommentableCellListener(listener);

        // modify the cell... this should create an event
        cc.setUserComment("Hello", "User", "red", "strong", "14");

        assertTrue(!isNotified);
    }

    /**
     * Test of getAllHistoryComments method, of class CommentableCell.
     */
    @Test
    public void testGetAllHistoryComments() {
        System.out.println("getAllHistoryComments");
        CommentableCell instance = new CommentableCell(c);
        CommentNew cmt = new CommentNew("ola", "user", "red", "strong", "14");
        ArrayList<String> expResult = new ArrayList<>();
        expResult.add("Comment: " + cmt.getContent());
        instance.setUserComment("ola", "user", "red", "strong", "14");
        ArrayList<String> result = instance.getAllHistoryComments();
        assertEquals(expResult, result);
    }
}

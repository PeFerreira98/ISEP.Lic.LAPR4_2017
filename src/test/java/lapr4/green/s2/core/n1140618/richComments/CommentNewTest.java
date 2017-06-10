/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.green.s2.core.n1140618.richComments;

import java.util.ArrayList;
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
public class CommentNewTest {
    private CommentNew instance;
    
    public CommentNewTest() {
        instance = new CommentNew("OI", "Tiago","red","strong", "14");
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
     * Test of getContent method, of class CommentNew.
     */
    @Test
    public void testGetContent() {
        System.out.println("getContent");

        String expResult = "OI";
        String result = instance.getContent();
        assertEquals(expResult, result);
    }

    /**
     * Test of getAuthor method, of class CommentNew.
     */
    @Test
    public void testGetAuthor() {
        System.out.println("getAuthor");

        String expResult = "Tiago";
        String result = instance.getAuthor();
        assertEquals(expResult, result);
    }

    /**
     * Test of setContent method, of class CommentNew.
     */
    @Test
    public void testSetContent() {
        System.out.println("setContent");
        String content = "OLA";

        instance.setContent(content);

        assertEquals(content, instance.getContent());
    }

    /**
     * Test of setAuthor method, of class CommentNew.
     */
    @Test
    public void testSetAuthor() {
        System.out.println("setAuthor");
        String author = "Manuel";
        instance.setAuthor(author);
        assertEquals(author, instance.getAuthor());
    }


    /**
     * Test of clone method, of class CommentNew.
     */
    @Test
    public void testClone() {
        System.out.println("clone");
        CommentNew instance = new CommentNew("ola", "user", "red", "strong", "14");
        CommentNew expResult = new CommentNew("ola", "user", "red", "strong", "14");
        CommentNew result = instance.clone();
        assertEquals(expResult, result);
    }

    /**
     * Test of addChange method, of class CommentNew.
     */
    @Test
    public void testAddChange() {
        System.out.println("addChange");
        CommentNew oldComment = new CommentNew("ola", "user", "red", "strong", "14");;
        instance.addChange(oldComment);
    }

    /**
     * Test of getHistory method, of class CommentNew.
     */
    @Test
    public void testGetHistory() {
        System.out.println("getHistory");
        CommentChange c = new CommentChange(instance);
        ArrayList<CommentChange> expResult = new ArrayList<>();
        expResult.add(c);
        instance.getHistory().add(c);
        ArrayList<CommentChange> result = instance.getHistory();
        assertEquals(expResult, result);
    }

    /**
     * Test of equals method, of class CommentNew.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object obj = new CommentNew("ola", "user", "red", "strong", "14");
        CommentNew instance = new CommentNew("ola", "user", "red", "strong", "14");
        boolean expResult = true;
        boolean result = instance.equals(obj);
        assertEquals(expResult, result);
    }
    
}

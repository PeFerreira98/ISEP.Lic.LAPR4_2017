/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.red.s1.core.n1140376.comments;

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
public class CommentTest {
    Comment c1;
    Comment c2;
    public CommentTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        c1 = new Comment("Manuel","Comment1");
        c2 = new Comment("Ze Agusto", "C2");
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of userName method, of class Comment.
     */
    @Test
    public void testUserName() {
        System.out.println("userName");
        Comment instance = c1;
        String expResult = "Manuel";
        String result = instance.userName();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of text method, of class Comment.
     */
    @Test
    public void testText() {
        System.out.println("text");
        Comment instance = c1;
        String expResult = "Comment1";
        String result = instance.text();
        assertEquals(expResult, result);
       
    }

    /**
     * Test of setUsername method, of class Comment.
     */
    @Test
    public void testSetUsername() {
        System.out.println("setUsername");
        String username = "Zeze";
        Comment instance = c1;
        instance.setUsername(username);
        assertEquals(username,instance.userName());
    }

    /**
     * Test of setText method, of class Comment.
     */
    @Test
    public void testSetText() {
        System.out.println("setText");
        String text = "Comment2";
        Comment instance = c1;
        instance.setText(text);
        assertEquals(text,instance.text());
    }

    /**
     * Test of equals method, of class Comment.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object obj = c1;
        Comment instance = c1;
        boolean expResult = true;
        boolean result = instance.equals(obj);
        assertEquals(expResult, result);
        Object obj1 = c2;
        boolean expResult1 = false;
        boolean result1 = instance.equals(obj1);
        assertEquals(expResult1, result1);
    }
    
}

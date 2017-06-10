/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.green.s2.core.n1140618.richComments;

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
public class CommentChangeTest {
    
    private CommentNew c;
    
    public CommentChangeTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        c = new CommentNew("ola", "user", "red", "strong", "14");
    }
    
    @After
    public void tearDown() {
    }



    /**
     * Test of getComment method, of class CommentChange.
     */
    @Test
    public void testGetComment() {
        System.out.println("getComment");
        CommentChange instance = new CommentChange(c);
        CommentNew expResult = c;
        CommentNew result = instance.getComment();
        assertEquals(expResult, result);
    }
    
}

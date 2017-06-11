/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.green.s2.core.n1970581.autodescriptionextensions;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Hugo
 */
public class NameTest {
    
    public NameTest() {
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
     * Test of name method, of class Name.
     */
    @Test
    public void testName() {
        System.out.println("name");
        String s = "name";
        Name n1 = new Name(s);
        
        assertEquals(n1.name(), s);
        
        Name n2;
        try{
            n2 = new Name(null);
            fail();
        }
        catch(IllegalArgumentException ex){
            assertTrue(true);
        }
        
        
        
        
        
    }

    

    /**
     * Test of equals method, of class Name.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        String s1 = "1";
        String s11 = "1";
        String s2 = "2";
        Name n1 = new Name(s1);
        Name n11 = new Name(s11);
        Name n2 = new Name(s2);
       
        assertEquals(n1 , n1);
        assertEquals(n1 , n11);
        assertFalse(n1.equals(n2));
        assertFalse(n1.equals(null));
        assertFalse(n1.equals(new Integer(2)));
        
        
    }

    /**
     * Test of toString method, of class Name.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Name instance = new Name("nome");
        String expResult = "nome";
        String result = instance.toString();
        assertEquals(expResult, result);
    }
    
    
}

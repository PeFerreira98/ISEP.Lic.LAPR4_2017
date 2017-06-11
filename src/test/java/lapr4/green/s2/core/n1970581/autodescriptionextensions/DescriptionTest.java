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
public class DescriptionTest {
    
    public DescriptionTest() {
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
     * Test of description method, of class Description.
     */
    @Test
    public void testDescription() {
        System.out.println("description");
        Description instance = new Description("ola");
        String expResult = "ola";
        String result = instance.description();
        assertEquals(expResult, result);
        
        try{
            new Description(null);
            fail();
        }
        catch(IllegalArgumentException ex){
            assertTrue(true);
        }
        
    }

    /**
     * Test of hashCode method, of class Description.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        Description d1 = new Description("ola");
        Description d2 = new Description("ola");
        Description d3 = new Description("zzz");
        
        assertEquals(d1.hashCode(), d2.hashCode());
        assertFalse(d3.hashCode() == d1.hashCode());
        
    }

    /**
     * Test of equals method, of class Description.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object obj = new Integer(1);
        Description d1 = new Description("ola");
        Description d2 = new Description("ola");
        Description d3 = new Description("zzz");
        
        assertEquals(d1, d1);
        assertEquals(d1, d2);
        assertFalse(d3.equals(d1));
        assertFalse(d3.equals(obj));
        assertFalse(d3.equals(null));
    }

    /**
     * Test of toString method, of class Description.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Description instance = new Description("ola");
        String expResult = "ola";
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of compareTo method, of class Description.
     */
    @Test
    public void testCompareTo() {
        System.out.println("compareTo");
        
        String s1 = "1";
        String s11 = "1";
        String s3 = "2";
        
        Description d1 = new Description(s1);
        Description d11 = new Description(s11);
        Description d3 = new Description(s3);
        
        assertTrue(d1.compareTo(d11) == 0);
        assertTrue(d1.compareTo(d1) == 0);
        assertTrue(d1.compareTo(d3) < 0);
        assertTrue(d3.compareTo(d1) > 0);
        
        
    }

    /**
     * Test of clone method, of class Description.
     */
    @Test
    public void testClone() {
        System.out.println("clone");
        String s1 = "1";
        String s11 = "1";
        String s3 = "2";
        
        Description d1 = new Description(s1);
        Description d11 = new Description(s11);
        Description d3 = new Description(s3);
        
        assertEquals(d1, d1.clone());
        assertFalse(d1.clone().equals(d3));
        
        
    }
    
}

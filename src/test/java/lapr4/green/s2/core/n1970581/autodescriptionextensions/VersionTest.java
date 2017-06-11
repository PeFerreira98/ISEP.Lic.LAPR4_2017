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
public class VersionTest {
    
    public VersionTest() {
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
     * Test of equals method, of class Version.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        
        Version v1 = new Version(1);
        Version v11 = new Version(1);
        Version v2 = new Version(2);
        
        assertEquals(v1, v1);
        assertEquals(v1, v11);
        assertFalse(v1.equals(v2));
        assertFalse(v1.equals(null));
        assertFalse(v1.equals(new Integer(12)));
        
        
        
    }

    /**
     * Test of toString method, of class Version.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        
        Version v1 = new Version(1);
        assertEquals(v1.toString(), "1");
        
    }

    
    
}

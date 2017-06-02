/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.green.s1.ipc.n1970581.findworkbook;

import java.io.File;
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
public class FilenameFilterBasicTest {
    
    public FilenameFilterBasicTest() {
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
     * Test of accept method, of class FilenameFilterBasic.
     */
    @Test
    public void testAccept() {
        System.out.println("accept");
        File dir = null;
        String name = null;
        FilenameFilterBasic instance = new FilenameFilterBasic();
        boolean expResult = false;
        boolean result = instance.accept(dir, name);
        assertEquals(expResult, result);
        
        assertEquals(true, instance.accept(null, "ola.cls"));        
        assertEquals(true, instance.accept(null, "ola2.cls"));
        assertEquals(false, instance.accept(null, "asd.cxs"));
        assertEquals(false, instance.accept(null, ".cls"));
        
        
        
    }
    
}

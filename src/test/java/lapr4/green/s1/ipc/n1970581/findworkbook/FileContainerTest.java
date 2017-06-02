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
public class FileContainerTest {
    
    public FileContainerTest() {
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
     * Test of insertFile method, of class FileContainer.
     */
    @Test
    public void testInsertFile() {
        System.out.println("insertFile");
        File file = null;
        FileContainer instance = new FileContainer();
        try{
            instance.insertFile(file);
            fail("Failed to throw exception");
        }
        catch(IllegalArgumentException ex){
            assertTrue(true);
        }
    }

    /**
     * Test of get method, of class FileContainer.
     */
    @Test
    public void testGet() {
        System.out.println("get");
        int i = 0;
        FileContainer instance = new FileContainer();
        FileDTO expResult = null;
        try{
            FileDTO result = instance.get(i);
            fail(); // Can't get anything from an empty List, throws exception.
            assertEquals(expResult, result); // Can't insert files, so can't test the get.
        }
        catch(IndexOutOfBoundsException ex){
            assertTrue(true);
        }
            
    }

    /**
     * Test of emptyMe method, of class FileContainer.
     */
    @Test
    public void testEmptyMe() {
        System.out.println("emptyMe");
        FileContainer instance = new FileContainer();
        
        instance.emptyMe();
        assertEquals(0, instance.size());
    }

    /**
     * Test of size method, of class FileContainer.
     */
    @Test
    public void testSize() {
        System.out.println("size");
        FileContainer instance = new FileContainer();
        int expResult = 0;
        int result = instance.size();
        assertEquals(0, result);
        
    }

    /**
     * Test of setToExit method, of class FileContainer.
     */
    @Test
    public void testSetToExit() {
        System.out.println("setToExit");
        FileContainer instance = new FileContainer();
        
        instance.setToExit();
        assertTrue(instance.isToExit());
        
    }

    /**
     * Test of isToExit method, of class FileContainer.
     */
    @Test
    public void testIsToExit() {
        System.out.println("isToExit");
        FileContainer instance = new FileContainer();
        boolean expResult = false;
        boolean result = instance.isToExit();
        assertEquals(expResult, result);
        instance.setToExit();
        assertEquals(true, instance.isToExit());
        
    }
    
}

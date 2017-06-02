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
public class FileDTOTest {
    
    public FileDTOTest() {
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
     * Test of serial method, of class FileDTO.
     */
    @Test
    public void testFileDTO() {
        System.out.println("FileDTO constructor");
        FileDTO instance = null;
        
        try{ 
            instance = new FileDTO(null, 0);
            fail();
        }
        catch(IllegalArgumentException ex){
            assertTrue(true);
        }
        
    }

   
    
}

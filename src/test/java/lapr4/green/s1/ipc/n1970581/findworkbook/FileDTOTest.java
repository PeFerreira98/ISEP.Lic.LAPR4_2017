/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.green.s1.ipc.n1970581.findworkbook;

import java.io.File;
import java.util.Objects;
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
        
        File mockFile = new File("zzz:/deleteme.txt");
        instance = new FileDTO(mockFile, 0);
        
    }

    /**
     * Test of serial method, of class FileDTO.
     */
    @Test
    public void testSerial() {
        System.out.println("serial");
        FileDTO instance = null;
        File mockFile = new File("zzz:/deleteme.txt");
        instance = new FileDTO(mockFile, 10);
        assertEquals(10, instance.serial());
        
    }

    

    /**
     * Test of path method, of class FileDTO.
     */
    @Test
    public void testPath() {
        System.out.println("path");
        FileDTO instance = null;
        File mockFile = new File("zzz:/deleteme.txt");
        instance = new FileDTO(mockFile, 10);
        assertEquals(instance.path(), mockFile.getAbsolutePath());
    }

    /**
     * Test of toString method, of class FileDTO.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        FileDTO instance = null;
        File mockFile = new File("zzz:/deleteme.txt");
        instance = new FileDTO(mockFile, 10);
        assertEquals(instance.toString(), mockFile.getName());
        
    }

    /**
     * Test of hashCode method, of class FileDTO.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        FileDTO instance = null;
        File mockFile = new File("zzz:/deleteme.txt");
        instance = new FileDTO(mockFile, 10);
        
        int hash = 3;
        hash = 67 * hash + Objects.hashCode(instance.path());
        
        int expResult = hash;
        
        
        int result = instance.hashCode();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of equals method, of class FileDTO.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object obj = null;
        FileDTO instance = null;
        File mockFile = new File("zzz:/deleteme.txt");
        instance = new FileDTO(mockFile, 10);
        File mockFile2 = new File("zzz:/deleteme.txt");
        FileDTO instance2 = new FileDTO(mockFile2, 10);
        File mockFile3 = new File("zzz:/deleteme2.txt");
        FileDTO instance3 = new FileDTO(mockFile3, 10);
        
        boolean expResult = false;
        boolean result = instance.equals(obj);
        assertEquals(expResult, result);
        
        assertEquals(instance, instance);
        assertEquals(instance, instance2);
        assertFalse(instance2.equals(instance3));
        assertFalse(instance2.equals(new Integer(1)));
        
    }

    /**
     * Test of filename method, of class FileDTO.
     */
    @Test
    public void testFilename() {
        System.out.println("filename");
        FileDTO instance = null;
        File mockFile = new File("zzz:/deleteme.txt");
        instance = new FileDTO(mockFile, 10);
        String expResult = mockFile.getName();
        String result = instance.filename();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of compareTo method, of class FileDTO.
     */
    @Test
    public void testCompareTo() {
        System.out.println("compareTo");
        
        FileDTO instance = null;
        File mockFile = new File("zzz:/deleteme.txt");
        instance = new FileDTO(mockFile, 10);
        File mockFile2 = new File("zzz:/deleteme.txt");
        FileDTO instance2 = new FileDTO(mockFile2, 10);
        File mockFile3 = new File("zzz:/deleteme2.txt");
        FileDTO instance3 = new FileDTO(mockFile3, 10);
        
        
        int expResult = 0;
        int result = instance.compareTo(instance2);
        assertEquals(expResult, result);
        assertTrue(instance.compareTo(instance3) <0);
        assertTrue(instance3.compareTo(instance2) >0);
    }

   
    
}

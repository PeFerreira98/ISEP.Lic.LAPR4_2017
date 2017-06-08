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
public class MetadataFactoryTest {
    
    public MetadataFactoryTest() {
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
     * Test of instance method, of class MetadataFactory.
     */
    @Test
    public void testInstance() {
        System.out.println("instance");
        MetadataFactory instance = MetadataFactory.instance();
        assertTrue(instance != null);
    }

    /**
     * Test of buildMetadata method, of class MetadataFactory.
     */
    @Test
    public void testBuildMetadata_3args() {
        System.out.println("buildMetadata 3 args");
        String name = "nome";
        int version = 10;
        String description = " a description";
        MetadataFactory instance = MetadataFactory.instance();
        Metadata expResult = null;
        Metadata result = instance.buildMetadata(name, version, description);
        
        assertTrue(result!= null);
        //String n = result.getName();
        assertTrue(result.getName().equals(name));
        assertTrue(result.version() == version);
        assertTrue(result.description().equals(description));
        
        
    }

    /**
     * Test of buildMetadata method, of class MetadataFactory.
     */
    @Test
    public void testBuildMetadata_String() {
        System.out.println("buildMetadata 1 arg");
        String name = "name";
        MetadataFactory instance = MetadataFactory.instance();
        Metadata expResult = null;
        Metadata result = instance.buildMetadata(name);
        
        assertTrue(result!= null);
        //String n = result.getName();
        assertTrue(result.getName().equals(name));
        
        assertTrue(result.description() != null);
        
        
    }
    
}

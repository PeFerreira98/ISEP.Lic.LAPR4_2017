/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.green.s2.core.n1970581.autodescriptionextensions;

import csheets.ext.Extension;
import csheets.ext.simple.ExtensionExample;
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
        
        Metadata mmm;
        try{
            mmm = instance.buildMetadata(null, version, description);
            fail();
        }
        catch(IllegalArgumentException ex){assertTrue(true);}
        try{
            mmm = instance.buildMetadata(name, version, null);
            fail();
        }
        catch(IllegalArgumentException ex){assertTrue(true);}
        
        
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
        
        Metadata mmm;
        try{
            mmm = instance.buildMetadata(null);
            fail();
        }
        catch(IllegalArgumentException ex){assertTrue(true);}
        
    }

    /**
     * Test of buildExtensionDTO method, of class MetadataFactory.
     */
    @Test
    public void testBuildExtensionDTO() {
        System.out.println("buildExtensionDTO");
        
        Extension ex1 = new ExtensionExample();
        Extension ex2 = new ExtensionExample2();
        
        ExtensionDTO exDTO1 = MetadataFactory.instance().buildExtensionDTO(ex1);
        ExtensionDTO exDTO2 = MetadataFactory.instance().buildExtensionDTO(ex2);
        
        assertEquals(exDTO1.getName(), ex1.getName());
        assertEquals(exDTO2.getName(), ex2.getName());
        assertEquals(exDTO1.version(), ex1.version());
        assertEquals(exDTO1.description(), ex1.description());
        
        assertEquals(exDTO1.className(), ex1.getClass().getCanonicalName());
        assertEquals(exDTO2.className(), ex2.getClass().getCanonicalName());
        
        try {
            ExtensionDTO nullavel = MetadataFactory.instance().buildExtensionDTO(null);
            fail();
        }
        catch(IllegalArgumentException ex){
            assertTrue(ex != null);
        }
        
    }
    
}

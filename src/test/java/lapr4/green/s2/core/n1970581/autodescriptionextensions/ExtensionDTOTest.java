/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.green.s2.core.n1970581.autodescriptionextensions;

import csheets.ext.Extension;
import csheets.ext.simple.ExtensionExample;
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
public class ExtensionDTOTest {
    
    ExtensionDTO e1;
    ExtensionDTO e2;
    ExtensionDTO e3;
    ExtensionDTO e11;
    Metadata m1;
    Metadata m11;
    Metadata m2;
    Metadata m3;
    Metadata m123;
    String n1;
    String n2;
    String n3;
    String d1;
    String d2;
    String d3;
    
    public ExtensionDTOTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        n1 = "n1";
        n2 = "n2";
        n3 = "n3";
        d1 = "d1";
        d2 = "d2";
        d3 = "d3";
        
        m1 = MetadataFactory.instance().buildMetadata(n1, 1, d1);
        m11 = MetadataFactory.instance().buildMetadata(n1, 1, d1);
        m2 = MetadataFactory.instance().buildMetadata(n2, 2, d2);
        m3 = MetadataFactory.instance().buildMetadata(n3, 3, d3);
        m123 = MetadataFactory.instance().buildMetadata(n3, 3, d1);
        
        e1 = MetadataFactory.instance().buildExtensionDTO(m1);
        e2 = MetadataFactory.instance().buildExtensionDTO(m2);
        e3 = MetadataFactory.instance().buildExtensionDTO(m3);
        e11 = MetadataFactory.instance().buildExtensionDTO(m11);
        
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of ExtensionDTO method, of class ExtensionDTO.
     */
    @Test
    public void testExtensionDTO() {
        System.out.println("MetadataDTO");
        
        try{
            ExtensionDTO aux1 = new ExtensionDTO(null, n1);
            fail();
        }
        catch(IllegalArgumentException ex){
            assertTrue(ex != null);
        }
        try{
            ExtensionDTO aux2 = new ExtensionDTO(m1, null);
            fail();
        }
        catch(IllegalArgumentException ex){
            assertTrue(ex != null);
        }
        
        
        
    }
    
    /**
     * Test of getName method, of class ExtensionDTO.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        
        assertTrue(e1.getName().equals(n1)) ;
    }

    /**
     * Test of version method, of class ExtensionDTO.
     */
    @Test
    public void testVersion() {
        System.out.println("version");
        assertTrue(e1.version() == 1) ;
    }

    /**
     * Test of description method, of class ExtensionDTO.
     */
    @Test
    public void testDescription() {
        System.out.println("description");
        assertTrue(e1.description().equals(d1)) ;
    }

    /**
     * Test of metadata method, of class ExtensionDTO.
     */
    @Test
    public void testMetadata() {
        System.out.println("metadata");
        
        assertTrue(e1.metadata().equals(m1)) ;
    }

    /**
     * Test of className method, of class ExtensionDTO.
     */
    @Test
    public void testClassName() {
        System.out.println("className");
        
        String cname = m1.getClass().getCanonicalName();
        
        assertTrue(e1.className().equals(cname)) ;
        assertTrue(e1.className() != null) ;
        assertFalse(e1.className().isEmpty()) ;
        
    }

    /**
     * Test of hashCode method, of class ExtensionDTO.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        
        assertTrue(e1.hashCode() == e11.hashCode()) ;
        assertTrue(e1.hashCode() == e1.hashCode()) ;
        assertTrue(e1.hashCode() != e2.hashCode()) ; 
        
        
    }

    /**
     * Test of equals method, of class ExtensionDTO.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object obj = null;
        
        assertTrue(e1.equals(e1)) ;
        assertTrue(e1.equals(e11)) ;
        
        
    }

    /**
     * Test of toString method, of class ExtensionDTO.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        
        assertTrue(e1.toString().equals(e1.toString()));
        assertTrue(e1.toString().equals(e11.toString()));
        assertFalse(e1.toString().equals(e2.toString()));
        
        
    }

    /**
     * Test of compareTo method, of class ExtensionDTO.
     */
    @Test
    public void testCompareTo() {
        System.out.println("compareTo");
        
        Extension ex1 = new ExtensionExample();
        Extension ex2 = new ExtensionExample2();
        ExtensionDTO exDTO1 = MetadataFactory.instance().buildExtensionDTO(ex1);
        ExtensionDTO exDTO2 = MetadataFactory.instance().buildExtensionDTO(ex2);
        
        
        assertTrue(exDTO1.compareTo(exDTO2) < 0);
        assertTrue(exDTO2.compareTo(exDTO1) > 0);
        assertTrue(exDTO1.compareTo(exDTO1) == 0);
        
    }
    
}

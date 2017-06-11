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
public class MetadataTest {
    
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
    
    
    public MetadataTest() {
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
    }
    
    @After
    public void tearDown() {
    }

    
    
    /**
     * Test of constructor, of class Metadata.
     */
    @Test
    public void testMetadataConstructor() {
        System.out.println("Metadata()");
        Metadata da;
        
        Name nn1 = new Name("nome");
        Description dd1 = new Description("desc");
        Version vv1 = new Version(1);
        
        
        try{
            da = new Metadata(null, vv1,dd1 );
            fail();
        }
        catch(IllegalArgumentException ex){
            assertTrue(true);
        }
        try{
            da = new Metadata(nn1, null,dd1 );
            fail();
        }
        catch(IllegalArgumentException ex){
            assertTrue(true);
        }
        try{
            da = new Metadata(nn1, vv1,null );
            fail();
        }
        catch(IllegalArgumentException ex){
            assertTrue(true);
        }
        
    }
    
    
    /**
     * Test of hashCode method, of class Metadata.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        
        assertEquals(m1.hashCode(), m11.hashCode());
        assertFalse(m1.hashCode() == m2.hashCode());
        assertFalse(m1.hashCode() == m3.hashCode());
        
    }

    /**
     * Test of equals method, of class Metadata.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object obj = null;
        Metadata instance = null;
        boolean expResult = false;
        
        assertTrue(m1.equals(m11));
        assertFalse(m1.equals(m2));
        assertFalse(m1.equals(m3));
        assertFalse(m1.equals(new Integer(2)));
        
        assertFalse(m1.equals(null));
        
        Metadata x = MetadataFactory.instance().buildMetadata(n1, 2, d1);
        assertFalse(m1.equals(x));
        
        
    }

    /**
     * Test of compareTo method, of class Metadata.
     */
    @Test
    public void testCompareTo() {
        System.out.println("compareTo");
        
        assertTrue(m1.compareTo(m1) == 0);
        assertTrue(m1.compareTo(m11) == 0);
        assertTrue(m1.compareTo(m2) < 0);
        assertTrue(m1.compareTo(m3) < 0);
        assertTrue(m3.compareTo(m1) > 0);
        assertTrue(m3.compareTo(m123) == 0 );
        
        
    }

    /**
     * Test of getName method, of class Metadata.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        
        assertEquals(m1.getName() , n1);
        assertFalse(m1.getName().equals(n2));
    }

    /**
     * Test of version method, of class Metadata.
     */
    @Test
    public void testVersion() {
        System.out.println("version");
        
        assertEquals(m1.version() , 1);
        assertFalse(m2.version() == 1);
        
    }

    /**
     * Test of description method, of class Metadata.
     */
    @Test
    public void testDescription() {
        System.out.println("description");
        
         assertEquals(m1.description() , d1);
        assertFalse(m1.description().equals(d2));
        
    }

    /**
     * Test of metadata method, of class Metadata.
     */
    @Test
    public void testMetadata() {
        System.out.println("metadata");
        
        assertTrue(m1.metadata().equals(m1));
        assertTrue(m1.metadata().equals(m11));
        assertFalse(m1.metadata().equals(m2));
        
        
    }

    /**
     * Test of clone method, of class Metadata.
     */
    @Test
    public void testClone() {
        System.out.println("clone");
        
        assertTrue(m1.clone().equals(m1));
        assertTrue(m1.clone().equals(m11));
        assertFalse(m1.clone().equals(m2));
        
        
    }
    
}

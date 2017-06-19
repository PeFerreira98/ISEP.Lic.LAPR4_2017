/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.green.s3.lang.n1970581.arraysandvariableeditor;

import csheets.core.Value;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class ArrayItemDTOTest {
    
    ArrayItem a1;
    ArrayItem a11;
    ArrayItem a2;
    ArrayItem a3;
    Value v1;
    Value v2;
    Value v3;
    String n1;
    String n2;
    String n3;
    ArrayItemDTO d1;
    ArrayItemDTO d2;
    ArrayItemDTO d3;
    ArrayItemDTO d11;
    
    public ArrayItemDTOTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        v1 = Value.parseValue("1");
        n1 = "a1";
        a1 = new ArrayItem(n1, v1);
        
        v2 = Value.parseValue("2");
        n2 = "a2";
        a2 = new ArrayItem(n2, v2);
        
        v3 = Value.parseValue("3");
        n3 = "a3";
        a3 = new ArrayItem(n3, v3);
        
        a11 = new ArrayItem(n1, v1);
        
        d1 = a1.toDTO();
        d2 = a2.toDTO();
        d3 = a3.toDTO();
        d11 = a1.toDTO();
        
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of name method, of class ArrayItemDTO.
     */
    @Test
    public void testName() {
        System.out.println("name");
        
        assertTrue(d1.name().equals(n1));
        
    }

    /**
     * Test of value method, of class ArrayItemDTO.
     */
    @Test
    public void testValue() {
        System.out.println("value");
        
        assertTrue(d1.value().equals("1"));
        
    }

    /**
     * Test of compareTo method, of class ArrayItemDTO.
     */
    @Test
    public void testCompareTo() {
        System.out.println("compareTo");
        
        assertTrue(d1.compareTo(d11)== 0);
        assertTrue(d1.compareTo(d2) < 0);
        assertTrue(d2.compareTo(d1) > 0);
        
        
        
    }

    /**
     * Test of hashCode method, of class ArrayItemDTO.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        
        assertTrue(d1.hashCode() == d11.hashCode());
        assertFalse(d1.hashCode() == d2.hashCode());
        
        
    }

    /**
     * Test of equals method, of class ArrayItemDTO.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        
        assertTrue(d1.equals(d1));
        assertTrue(d1.equals(d11));
        assertFalse(d1.equals(d2));
        assertFalse(d1.equals(null));
        assertFalse(d1.equals(new Integer(1)));
        
        
    }

    /**
     * Test of clone method, of class ArrayItemDTO.
     */
    @Test
    public void testClone() {
        System.out.println("clone");
        
        ArrayItemDTO clone = null;
        try {
            clone = (ArrayItemDTO) d1.clone();
        } catch (CloneNotSupportedException ex) {
            fail();
        }
        
        assertTrue(d1.equals(clone));
        
        
    }

    /**
     * Test of toString method, of class ArrayItemDTO.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        assertTrue(d1.toString() != null);
    }
    
}

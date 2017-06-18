/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.green.s3.lang.n1970581.arraysandvariableeditor;

import csheets.core.Value;
import csheets.core.formula.util.ExpressionVisitor;
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
public class ArrayItemTest {
    
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
    
    public ArrayItemTest() {
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
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getName method, of class ArrayItem.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        
        assertTrue(a1.getName().equals(n1));
    }

    /**
     * Test of getValue method, of class ArrayItem.
     */
    @Test
    public void testGetValue() {
        System.out.println("getValue");
        
        assertTrue(a1.getValue().equals(v1));
        
    }

    /**
     * Test of setValue method, of class ArrayItem.
     */
    @Test
    public void testSetValue() {
        System.out.println("setValue");
        Value value = Value.parseValue("2");
        a1.setValue(value);
        
        assertTrue(a1.getValue().equals(value));
    }

    /**
     * Test of isInitiated method, of class ArrayItem.
     */
    @Test
    public void testIsInitiated() {
        System.out.println("isInitiated");
        ArrayItem instance = new ArrayItem("algo");
        
        assertFalse(instance.isInitiated());
        instance.setValue(v1);
        assertTrue(instance.isInitiated());
    }

    /**
     * Test of applyTo method, of class ArrayItem.
     */
    @Test
    public void testApplyTo() {
        System.out.println("applyTo");
        
        try{
            a1.applyTo("algo");
            fail();
        }
        catch( UnsupportedOperationException ex){
            assertTrue(true);
        }
    }

    /**
     * Test of getOperandValueType method, of class ArrayItem.
     */
    @Test
    public void testGetOperandValueType() {
        System.out.println("getOperandValueType");
        
        assertTrue(v1.getType().equals(a1.getOperandValueType()));
        
        
    }

    /**
     * Test of evaluate method, of class ArrayItem.
     */
    @Test
    public void testEvaluate() {
        System.out.println("evaluate");
        try{
                assertTrue(a1.evaluate().equals(v1));
        }
        catch(Exception e){fail();}
        
    }

   
    /**
     * Test of toDTO method, of class ArrayItem.
     */
    @Test
    public void testToDTO() {
        System.out.println("toDTO");
        
        assertTrue(a1.toDTO() != null);
        
    }

    /**
     * Test of hashCode method, of class ArrayItem.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        
        assertTrue(a1.hashCode() == a11.hashCode());
        assertFalse(a1.hashCode() == a2.hashCode());
        
    }

    /**
     * Test of equals method, of class ArrayItem.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        
        assertTrue(a1.equals(a11));
        assertFalse(a1.equals(null));
        assertFalse(a1.equals(new Integer(1)));
        assertFalse(a1.equals(a2));
    }

    /**
     * Test of compareTo method, of class ArrayItem.
     */
    @Test
    public void testCompareTo() {
        System.out.println("compareTo");
        
        assertTrue(a1.compareTo(a11)== 0);
        assertTrue(a1.compareTo(a2) < 0);
        assertTrue(a2.compareTo(a1) > 0);
        
        
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.green.s2.core.n1970581.autodescriptionextensions;

import csheets.ext.Extension;
import csheets.ext.simple.ExtensionExample;
import java.util.ArrayList;
import java.util.List;
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
public class DescriptionExtensionLoaderTest {
    
    public DescriptionExtensionLoaderTest() {
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
     * Test of validateLoadingListOfUniqueExtensions method, of class DescriptionExtensionLoader.
     */
    @Test
    public void testValidateLoadingListOfUniqueExtensions() {
        System.out.println("validateLoadingListOfUniqueExtensions");
        List<ExtensionDTO> listToValidateLoad = new ArrayList<>();
        DescriptionExtensionLoader instance = new DescriptionExtensionLoader();
        boolean expResult = true;
        boolean result = instance.validateLoadingListOfUniqueExtensions(listToValidateLoad);
        assertEquals(expResult, result);
        
        Extension ex1 = new ExtensionExample2();
        Extension ex2 = new ExtensionExample2();
        listToValidateLoad.add(MetadataFactory.instance().buildExtensionDTO(ex1));
        listToValidateLoad.add(MetadataFactory.instance().buildExtensionDTO(ex2));
        
        assertFalse(instance.validateLoadingListOfUniqueExtensions(listToValidateLoad));
        
    }

    /**
     * Test of isUserFinishedSelection method, of class DescriptionExtensionLoader.
     */
    @Test
    public void testIsUserFinishedSelection() {
        System.out.println("isUserFinishedSelection");
        DescriptionExtensionLoader instance = new DescriptionExtensionLoader();
        boolean expResult = false;
        boolean result = instance.isUserFinishedSelection();
        assertEquals(expResult, result);
        instance.indicateUserFinishedSelection();
        assertTrue(instance.isUserFinishedSelection());
    }

    /**
     * Test of indicateUserFinishedSelection method, of class DescriptionExtensionLoader.
     */
    @Test
    public void testIndicateUserFinishedSelection() {
        System.out.println("indicateUserFinishedSelection");
        DescriptionExtensionLoader instance = new DescriptionExtensionLoader();
        assertFalse(instance.isUserFinishedSelection());
        instance.indicateUserFinishedSelection();
        assertTrue(instance.isUserFinishedSelection());
    }

    /**
     * Test of retrieveAllExtensions method, of class DescriptionExtensionLoader.
     */
    @Test
    public void testRetrieveAllExtensions() {
        System.out.println("retrieveAllExtensions");
        DescriptionExtensionLoader instance = new DescriptionExtensionLoader();
        try{
            instance.retrieveAllExtensions();
            assertTrue(true);
        }
        catch(NullPointerException ex){
            fail();
        }
    }
    
}

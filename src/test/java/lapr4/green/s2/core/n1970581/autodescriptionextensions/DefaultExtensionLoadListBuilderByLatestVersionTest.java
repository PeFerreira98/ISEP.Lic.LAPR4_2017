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
public class DefaultExtensionLoadListBuilderByLatestVersionTest {
    
    public DefaultExtensionLoadListBuilderByLatestVersionTest() {
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
     * Test of buildDefaultLoadList method, of class DefaultExtensionLoadListBuilderByLatestVersion.
     */
    @Test
    public void testBuildDefaultLoadList() {
        System.out.println("buildDefaultLoadList");
        List<ExtensionDTO> allExtensions = new ArrayList<>();
        List<ExtensionDTO> expResult = new ArrayList<>();
        
        Extension ex1 = new ExtensionExample();
        Extension ex2 = new ExtensionExample2();
        ExtensionDTO exDTO1 = MetadataFactory.instance().buildExtensionDTO(ex1);
        ExtensionDTO exDTO2 = MetadataFactory.instance().buildExtensionDTO(ex2);
        
        allExtensions.add(exDTO1);
        allExtensions.add(exDTO2);
        allExtensions.add(exDTO1);
        allExtensions.add(exDTO2);
        
        expResult.add(exDTO2);
        
        DefaultExtensionLoadListBuilderByLatestVersion instance = new DefaultExtensionLoadListBuilderByLatestVersion();
        
        List<ExtensionDTO> result = instance.buildDefaultLoadList(allExtensions);
        assertEquals(expResult, result);
        
    }
    
}

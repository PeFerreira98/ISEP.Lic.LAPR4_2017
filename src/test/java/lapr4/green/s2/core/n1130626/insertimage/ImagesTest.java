/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.green.s2.core.n1130626.insertimage;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Pedro Pereira
 */
public class ImagesTest {
    Images i1;
    Images i2;
    
    public ImagesTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        i1 = new Images("C:/Documentos/imagem1.jpeg");
        i2 = new Images("C:/Documentos/imagem2.jpeg");
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of urlLink method, of class Images.
     */
    @Test
    public void testUrlLink() {
        System.out.println("urlLink");
        Images instance = i1;
        String expResult = "C:/Documentos/imagem1.jpeg";
        String result = instance.urlLink();
        assertEquals(expResult, result);      
    }

    /**
     * Test of modify_URL_Link method, of class Images.
     */
    @Test
    public void testModify_URL_Link() {
        System.out.println("modify_URL_Link");
        String url_link = "C:/Documentos/imagem2.png";
        Images instance = i2;
        instance.modify_URL_Link(url_link);
        assertEquals(url_link, instance.urlLink());
    }

    /**
     * Test of equals method, of class Images.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object obj = i1;
        Images instance = i1;
        boolean expResult = true;
        boolean result = instance.equals(obj);
        assertEquals(expResult, result);
        Object obj2 = i2;
        boolean expResult2 = false;
        boolean result2 = instance.equals(obj2);
        assertEquals(expResult2, result2);
    }
    
}

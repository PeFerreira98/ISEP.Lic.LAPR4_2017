/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.red.s3.ipc.n1131106.realtimeworkbook;

import csheets.ui.ctrl.SelectionEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JButton;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Nuno Filipe 1131106
 */
public class RealTimeSearchTest {

    public RealTimeSearchTest() {
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
     * Test of showWbooks method, of class RealTimeSearch.
     */
    @Test
    public void testShowWbooks() {
        System.out.println("showWbooks");
        String path = "C:\\Users\\NunoCosta\\Desktop\\search";
        RealTimeSearch instance = new RealTimeSearch(path);
        Map<String, String> map = new HashMap<String, String>();
        map.put(path, path);
        instance.changeWbooks(map);
        Map<String, String> expResult = map;
        Map<String, String> result = instance.showWbooks();
        assertEquals(expResult, result);
    }

    /**
     * Test of changeWbooks method, of class RealTimeSearch.
     */
    @Test
    public void testChangeWbooks() {
        System.out.println("changeWbooks");
        String path = "C:\\Users\\NunoCosta\\Desktop\\search";
        RealTimeSearch instance = new RealTimeSearch(path);
        Map<String, String> map = new HashMap<String, String>();
        map.put(path, path);
        instance.changeWbooks(map);
        Map<String, String> expResult = map;
        Map<String, String> result = instance.showWbooks();
        assertEquals(expResult, result);
    }

}

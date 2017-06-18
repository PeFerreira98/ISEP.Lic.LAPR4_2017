/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.green.s3.lang.n1970581.arraysandvariableeditor;

import java.util.Observable;
import java.util.Observer;
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
public class VariableEditorWatchdogTest {
    
    public VariableEditorWatchdogTest() {
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
     * Test of instance method, of class VariableEditorWatchdog.
     */
    @Test
    public void testInstance() {
        System.out.println("instance");
       
        VariableEditorWatchdog result = VariableEditorWatchdog.instance();
        assertTrue(result != null);
        
    }

    /**
     * Test of signalChange method, of class VariableEditorWatchdog.
     */
    @Test
    public void testSignalChange() {
        System.out.println("signalChange");
        VariableEditorWatchdog instance = VariableEditorWatchdog.instance();
        AuxTest aux = new AuxTest();
        instance.addObserver(aux);
        assertTrue(aux.warned == false);
        instance.signalChange();
        assertTrue(aux.warned == true);
        
    }
    
    /**
     * Class to aid test of watchdog.
     */
    private class AuxTest implements Observer{
        
        boolean warned;
        
        public AuxTest(){this.warned = false;}

        @Override
        public void update(Observable o, Object arg) {
            this.warned = true;
        }
        
        
        
    }
    
    
}

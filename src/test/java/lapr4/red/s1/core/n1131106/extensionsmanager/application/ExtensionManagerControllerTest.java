/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.red.s1.core.n1131106.extensionsmanager.application;

import csheets.CleanSheets;
import csheets.ui.ctrl.UIController;
import javax.swing.JComponent;
import javax.swing.JToolBar;
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
public class ExtensionManagerControllerTest {

    public ExtensionManagerControllerTest() {
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
     * Test of changeState method, of class ExtensionManagerController.
     */
    @Test
    public void testChangeState() {
        
        System.out.println("changeState");
        int i = 0;
        boolean flag = false;
        UIController uiController = new UIController(new CleanSheets());
        ExtensionManagerController instance = new ExtensionManagerController(uiController);
        instance.changeState(i, flag);
        boolean result = false;

        if (uiController.getExtensions()[i].getSideBar() != null) {
            JComponent sidebar = uiController.getExtensions()[i].getSideBar();
            for (int j = 0; j < sidebar.getComponents().length; j++) {
                if (sidebar.getComponents()[j].isEnabled() || sidebar.getComponents()[j].isVisible()) {
                    result = true;
                }
            }
        }
        if (uiController.getExtensions()[i].getCellDecorator() != null) {
            if (uiController.getExtensions()[i].getCellDecorator().isEnabled()) {
                result = true;
            }
        }

        if (uiController.getExtensions()[i].getMenu() != null) {
            if (uiController.getExtensions()[i].getMenu().isEnabled()) {
                result = true;
            }
        }

        if (uiController.getExtensions()[i].getToolBar() != null) {
            JToolBar toolbar = uiController.getExtensions()[i].getToolBar();
            for (int j = 0; j < toolbar.getComponents().length; j++) {
                if (toolbar.getComponents()[j].isEnabled() || toolbar.getComponents()[j].isVisible()) {
                    result = true;
                }

            }
        }

        assertEquals(flag, result);
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.blue.s1.lang.n1140948.functionwizard;

import csheets.CleanSheets;
import csheets.core.IllegalValueTypeException;
import csheets.core.Value;
import csheets.core.formula.Expression;
import csheets.core.formula.Function;
import csheets.core.formula.FunctionParameter;
import csheets.core.formula.lang.And;
import csheets.core.formula.lang.Average;
import csheets.core.formula.lang.Count;
import csheets.core.formula.lang.If;
import csheets.core.formula.lang.Sum;
import csheets.ui.ctrl.UIController;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Tiago Silvestre
 */
public class FunctionWizardGUITest {

    /**
     * Test of buildAndSyntax method, of class FunctionWizardGUI.
     */
    @Test
    public void testBuildAndSyntax() {
        System.out.println("buildSyntax");
        Function func = new And();
        FunctionParameter[] param = func.getParameters();
        CleanSheets app = new CleanSheets();
        UIController uiController = new UIController(app);
        FunctionWizardGUI instance = new FunctionWizardGUI(uiController);
        String expResult = "=AND(BOOLEAN)";
        String result = instance.buildSyntax(func, param);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of buildSumSyntax method, of class FunctionWizardGUI.
     */
    @Test
    public void testBuildSumSyntax() {
        System.out.println("buildSyntax");
        Function func = new Sum();
        FunctionParameter[] param = func.getParameters();
        CleanSheets app = new CleanSheets();
        UIController uiController = new UIController(app);
        FunctionWizardGUI instance = new FunctionWizardGUI(uiController);
        String expResult = "=SUM(NUMERIC)";
        String result = instance.buildSyntax(func, param);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of buildAverageSyntax method, of class FunctionWizardGUI.
     */
    @Test
    public void testBuildAverageSyntax() {
        System.out.println("buildSyntax");
        Function func = new Average();
        FunctionParameter[] param = func.getParameters();
        CleanSheets app = new CleanSheets();
        UIController uiController = new UIController(app);
        FunctionWizardGUI instance = new FunctionWizardGUI(uiController);
        String expResult = "=AVERAGE(NUMERIC)";
        String result = instance.buildSyntax(func, param);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of buildCountSyntax method, of class FunctionWizardGUI.
     */
    @Test
    public void testBuildCountSyntax() {
        System.out.println("buildSyntax");
        Function func = new Count();
        FunctionParameter[] param = func.getParameters();
        CleanSheets app = new CleanSheets();
        UIController uiController = new UIController(app);
        FunctionWizardGUI instance = new FunctionWizardGUI(uiController);
        String expResult = "=COUNT(UNDEFINED)";
        String result = instance.buildSyntax(func, param);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of buildIfSyntax method, of class FunctionWizardGUI.
     */
    @Test
    public void testBuildIfSyntax() {
        System.out.println("buildSyntax");
        Function func = new If();
        FunctionParameter[] param = func.getParameters();
        CleanSheets app = new CleanSheets();
        UIController uiController = new UIController(app);
        FunctionWizardGUI instance = new FunctionWizardGUI(uiController);
        String expResult = "=IF(BOOLEAN;UNDEFINED;UNDEFINED)";
        String result = instance.buildSyntax(func, param);
        assertEquals(expResult, result);
    }
    
}

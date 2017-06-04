/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.blue.s1.lang.n1140948.functionwizard;

import csheets.core.formula.Formula;
import csheets.core.formula.Function;
import csheets.core.formula.lang.And;
import csheets.core.formula.lang.Language;
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
public class AddFunctionControllerTest {

    /**
     * Test of listFunctions method, of class AddFunctionController.
     */
    @Test
    public void testListFunctions() {
        System.out.println("listFunctions");
        AddFunctionController instance = new AddFunctionController();
        Function[] expResult = Language.getInstance().getFunctions();
        Function[] result = instance.listFunctions();
        assertArrayEquals(expResult, result);
    }    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.blue.s1.lang.n1140948.functionwizard;

import csheets.ui.ctrl.FocusOwnerAction;
import csheets.ui.ctrl.UIController;
import java.awt.event.ActionEvent;

/**
 *
 * @author Tiago Silvestre
 */
public class FunctionWizardAction extends FocusOwnerAction {

    protected UIController uiController;
    public static String NAME = "Functions";

    public FunctionWizardAction(UIController uiController) {
        this.uiController = uiController;

    }

    @Override
    protected String getName() {
        return NAME;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        new FunctionWizardGUI(uiController);
    }
    
}

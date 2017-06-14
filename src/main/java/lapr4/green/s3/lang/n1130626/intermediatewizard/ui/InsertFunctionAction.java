/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.green.s3.lang.n1130626.intermediatewizard.ui;

import csheets.ui.ctrl.BaseAction;
import csheets.ui.ctrl.UIController;
import java.awt.event.ActionEvent;

/**
 *
 * @author Pedro Pereira
 */
public class InsertFunctionAction extends BaseAction {

    private final UIController uiController;
    
    public InsertFunctionAction(UIController uiController){
        this.uiController = uiController;
    }
    
    @Override
    protected String getName() {
        return "Wizard";
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

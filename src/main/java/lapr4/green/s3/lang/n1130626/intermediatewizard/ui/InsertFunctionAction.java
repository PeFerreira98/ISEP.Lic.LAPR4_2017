/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.green.s3.lang.n1130626.intermediatewizard.ui;

import csheets.ui.ctrl.BaseAction;
import csheets.ui.ctrl.UIController;
import java.awt.event.ActionEvent;
import lapr4.green.s3.lang.n1130626.intermediatewizard.controller.InsertFunctionController;

/**
 *
 * @author Pedro Pereira
 */
public class InsertFunctionAction extends BaseAction {

    private final UIController uiController;
    private final InsertFunctionController controller;
    
    public InsertFunctionAction(UIController uiController){
        this.uiController = uiController;
        this.controller = new InsertFunctionController(this.uiController);
    }
    
    @Override
    protected String getName() {
        return "Wizard";
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        InsertFunctionUI insertUI = new InsertFunctionUI(controller);
        insertUI.setVisible(true);
    }
    
}

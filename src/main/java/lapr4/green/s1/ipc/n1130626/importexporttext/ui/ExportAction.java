/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.green.s1.ipc.n1130626.importexporttext.ui;

import csheets.ui.ctrl.BaseAction;
import csheets.ui.ctrl.UIController;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;

/**
 * An action of the extension that exemplifies how to export data to a text file.
 * @author Pedro Pereira
 */
public class ExportAction extends BaseAction {
    
        /** The user interface controller */
	protected UIController uiController;

        public ExportAction(UIController uiController){
            this.uiController = uiController;
        }
        
        @Override
        protected String getName() {
            return "Export data to a text file";
        }

        protected void defineProperties() {
	}
        
        /**
         * A simple action that presents a confirmation dialog.
	 * For now this is for test purposes, it will be replaced.
         * @param ae the event that was fired
         */
        @Override
        public void actionPerformed(ActionEvent ae) {
            JOptionPane.showMessageDialog(null, "This is only a test if it work here. Export");
        }
    
}

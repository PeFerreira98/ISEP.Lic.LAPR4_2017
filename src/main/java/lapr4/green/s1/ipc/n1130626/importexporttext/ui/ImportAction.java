/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.green.s1.ipc.n1130626.importexporttext.ui;

import csheets.ui.ctrl.FocusOwnerAction;
import csheets.ui.ctrl.UIController;
import java.awt.event.ActionEvent;

/**
 * An action of the extension that exemplifies how to import data from a text file.
 * @author Pedro Pereira
 */
public class ImportAction extends FocusOwnerAction {
    
        /** The user interface controller */
	protected UIController uiController;

        /**
         * Creates a new action.
         * @param uiController the user interface controller
         */
        public ImportAction(UIController uiController){
            this.uiController = uiController;
        }
        
        @Override
        protected String getName() {
            return "Import data from a text file";
        }

        protected void defineProperties() {
	}
        
        /**
         * The action that perfoms when select this option.
	 * It opens a specific UI to fill the data and Imports.
         * @param ae the event that was fired
         */
        @Override
        public void actionPerformed(ActionEvent ae) {
            //JOptionPane.showMessageDialog(null, "This is only a test if it work here. Import");
            ImportUI iui = new ImportUI(uiController);
            iui.setVisible(true);
            focusOwner.updateUI();
        }
    
}

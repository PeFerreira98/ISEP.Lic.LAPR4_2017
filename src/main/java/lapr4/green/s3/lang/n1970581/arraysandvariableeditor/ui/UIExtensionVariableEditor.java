/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.green.s3.lang.n1970581.arraysandvariableeditor.ui;

import csheets.ext.Extension;
import csheets.ui.ctrl.UIController;
import csheets.ui.ext.UIExtension;
import javax.swing.Icon;
import javax.swing.JComponent;

/**
 * Ui extension for the VariableEditor
 * @author Hugo
 */
public class UIExtensionVariableEditor extends UIExtension{
    
    
        /**
         * Constructor 
         * @param extension the ExtensionVariableEditor extension
         * @param uiController the UIController of the application.
         */
	public UIExtensionVariableEditor(Extension extension, UIController uiController) {
		super(extension, uiController);
		// TODO Auto-generated constructor stub
	}
	


	/**
	 * Returns a side bar that gives access to extension-specific
	 * functionality.
	 * @return a component, or null if the extension does not provide one
	 */
	public JComponent getSideBar() {
		return new  VariableEditorPanel(this.uiController);
	}	
    
    
}

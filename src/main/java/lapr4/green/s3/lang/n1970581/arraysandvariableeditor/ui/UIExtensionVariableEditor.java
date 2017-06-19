/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.green.s3.lang.n1970581.arraysandvariableeditor.ui;

import csheets.ext.Extension;
import csheets.ui.ctrl.UIController;
import csheets.ui.ext.CellDecorator;
import csheets.ui.ext.UIExtension;
import javax.swing.Icon;
import javax.swing.JComponent;

/**
 * Ui extension for the VariableEditor
 * @author Hugo
 */
public class UIExtensionVariableEditor extends UIExtension{
    
    
    /** The icon to display with the extension's name */
    private Icon icon;
    
    /** A cell decorator that visualizes comments on cells */
    private CellDecorator cellDecorator;
	
    /** A side bar that provides editing of comments */
    private JComponent sideBar;
    
    
    
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
    @Override
	public JComponent getSideBar() {
            if (sideBar == null){
        	
        	sideBar = new VariableEditorPanel(uiController);}
            return sideBar;
		
	}	
    
    
}

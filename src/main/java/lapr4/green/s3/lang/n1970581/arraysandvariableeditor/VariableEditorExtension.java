/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.green.s3.lang.n1970581.arraysandvariableeditor;

import csheets.ext.Extension;
import csheets.ui.ctrl.UIController;
import csheets.ui.ext.UIExtension;
import lapr4.green.s3.lang.n1970581.arraysandvariableeditor.ui.UIExtensionVariableEditor;

/**
 * Extension for use case of editing the global or arrays variables
 * @author Hugo
 */
public class VariableEditorExtension extends Extension{
    
    /** The name of the extension */
	public static final String NAME = "VariableEditor";
        /** The version number */
	public static final int VERSION = 3;
	/** The description */
	public static final String DESCRIPTION = "Extension for the Variable Editor ( Sprint 3).";

	/**
	 * Creates a new Example extension.
	 */
	public VariableEditorExtension() {
		super(NAME, VERSION, DESCRIPTION);
	}
	
	/**
	 * Returns the user interface extension of this extension (an instance of the class {@link  csheets.ext.simple.ui.UIExtensionExample}).
	 * In this extension example we are only extending the user interface.
	 * @param uiController the user interface controller
	 * @return a user interface extension, or null if none is provided
	 */
	public UIExtension getUIExtension(UIController uiController) {
		//return new UIExtensionExample(this, uiController);
		return new UIExtensionVariableEditor(this, uiController);
                
	}
    
    
}

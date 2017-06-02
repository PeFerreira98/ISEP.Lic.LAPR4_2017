/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.blue.s1.lang.n1140956.ConditionalFormatting;

import lapr4.blue.s1.lang.n1140956.ConditionalFormatting.ui.UIExtensionFormattingCells;
import csheets.ext.Extension;
import csheets.ui.ctrl.UIController;
import csheets.ui.ext.UIExtension;

/**
 *
 * @author Marcos
 */
public class FormattingExtension extends Extension{
    
    /** The name of the extension */
	public static final String NAME = "Formating Cells";

	/**
	 * Creates a new Example extension.
	 */
	public FormattingExtension() {
            super(NAME);
	}
	
	/**
	 * Returns the user interface extension of this extension 
	 * @param uiController the user interface controller
	 * @return a user interface extension, or null if none is provided
	 */
        @Override
	public UIExtension getUIExtension(UIController uiController) {
		return new UIExtensionFormattingCells(this, uiController);
	}
    
}

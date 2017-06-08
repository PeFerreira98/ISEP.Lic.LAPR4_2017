/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.green.s2.core.n1970581.autodescriptionextensions;

import csheets.ext.Extension;
import csheets.ext.simple.ui.UIExtensionExample;
import csheets.ui.ctrl.UIController;
import csheets.ui.ext.UIExtension;

/**
 * Extension example for the new metadata information application
 * Copy past from ExtensionExample with minor changes.
 * @author Hugo
 */
public class ExtensionExample2 extends Extension {

	/** The name of the extension */
	public static final String NAME = "Example";
	/** The version number */
	public static final int VERSION = 2;
	/** The description */
	public static final String DESCRIPTION = "Extension example for the new metadata information application";

	/**
	 * Creates a new Example extension.
	 */
	public ExtensionExample2() {
		super(NAME, VERSION, DESCRIPTION);
	}
	
	/**
	 * Returns the user interface extension of this extension (an instance of the class {@link  csheets.ext.simple.ui.UIExtensionExample}).
	 * In this extension example we are only extending the user interface.
	 * @param uiController the user interface controller
	 * @return a user interface extension, or null if none is provided
	 */
	public UIExtension getUIExtension(UIController uiController) {
		return new UIExtensionExample(this, uiController);
	}
}

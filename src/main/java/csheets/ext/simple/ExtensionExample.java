package csheets.ext.simple;

import csheets.ext.Extension;
import csheets.ext.simple.ui.UIExtensionExample;
import csheets.ui.ctrl.UIController;
import csheets.ui.ext.UIExtension;

/**
 * A simple extension just to show how the extension mechanism works.
 * An extension must extend the Extension abstract class.
 * The class that implements the Extension is the "bootstrap" of the extension.
 * @see Extension
 * @author Alexandre Braganca
 */
public class ExtensionExample extends Extension {

	/** The name of the extension */
	public static final String NAME = "Example";
        /** The version number */
	public static final int VERSION = 0;
	/** The description */
	public static final String DESCRIPTION = "Extension example for changing a cell value (Original).";

	/**
	 * Creates a new Example extension.
	 */
	public ExtensionExample() {
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

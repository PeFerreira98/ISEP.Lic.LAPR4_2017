/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.white.s1.core.n4567890.contacts;

import csheets.ext.Extension;
import csheets.ui.ctrl.UIController;
import csheets.ui.ext.UIExtension;
import lapr4.white.s1.core.n4567890.contacts.ui.UIExtensionContacts;

/**
 * An extension to support contacts.
 * 
 * @author Alexandre Braganca
 */
public class ContactsExtension extends Extension {

	/** The name of the extension */
	public static final String NAME = "Contacts";
        /** The version number */
        public static final int VERSION = 0;
        /** The description */
        public static final String DESCRIPTION = "Contacts addicion extension, Original.";

        
	/**
	 * Creates a new Example extension.
	 */
	public ContactsExtension() {
            super(NAME, VERSION, DESCRIPTION);
	}
	
	/**
	 * Returns the user interface extension of this extension 
	 * @param uiController the user interface controller
	 * @return a user interface extension, or null if none is provided
	 */
        @Override
	public UIExtension getUIExtension(UIController uiController) {
		return new UIExtensionContacts(this, uiController);
	}
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.white.s1.core.n4567890.contacts;

import csheets.ext.Extension;
import csheets.ui.ctrl.UIController;
import csheets.ui.ext.UIExtension;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import lapr4.white.s1.core.n4567890.contacts.persistence.PersistenceContext;

/**
 * An extension to support contacts.
 * 
 * @author Alexandre Braganca
 */
public class ContactsExtension extends Extension {

	/** The name of the extension */
	public static final String NAME = "Contacts";

	/**
	 * Creates a new Example extension.
	 */
	public ContactsExtension() {
		super(NAME);
	}
	
	/**
	 * Returns the user interface extension of this extension 
	 * @param uiController the user interface controller
	 * @return a user interface extension, or null if none is provided
	 */
	public UIExtension getUIExtension(UIController uiController) {
 
                // A small test to see if JPA is working
                          
                // Register Contact
                final String firstName = "john";
                final String lastName = "doe";

                final AddContactController contactController = new AddContactController(uiController.getUserProperties());
                try {
                    contactController.addContact(firstName, lastName);
                } catch (final Exception e) {
                    // ignoring exception. assuming it is justa primiray key violation
                    // due to the tentative of inserting a duplicated user
                    
                    // Lets log the exception...
                    // FIXME handle exception properly
                    Logger.getLogger(ContactsExtension.class.getName()).log(Level.WARNING, null, e);
                }
            
                return null;
		//return new UIExtensionComments(this, uiController);
	}
}
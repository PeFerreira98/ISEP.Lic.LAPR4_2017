/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.white.s1.core.n4567890.contacts.ui;

import javax.swing.JComponent;

import csheets.ext.Extension;
import csheets.ui.ctrl.UIController;
import csheets.ui.ext.UIExtension;

/**
 * This class implements the UI interface extension for the comments extension.
 * A UI interface extension must extend the UIExtension abstract class.
 * @see UIExtension
 * @author Alexandre Braganca
 */
public class UIExtensionContacts extends UIExtension {

	/** The icon to display with the extension's name */
//	private Icon icon;

	/** A side bar that provides editing of comments */
	private JComponent sideBar;

	/** The menu of the extension
        * @param extension extension
        * @param uiController ui controller 
        */
	public UIExtensionContacts(Extension extension, UIController uiController) {
		super(extension, uiController);
	}
	
	/**
	 * Returns a side bar that provides editing of comments.
	 * @return a side bar
	 */
        @Override
	public JComponent getSideBar() {
            if (sideBar == null)
		sideBar = new ContactPanel(uiController);
            return sideBar;
	}	
}

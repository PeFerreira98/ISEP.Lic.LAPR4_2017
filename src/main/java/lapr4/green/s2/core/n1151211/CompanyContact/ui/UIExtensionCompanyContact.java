/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.green.s2.core.n1151211.CompanyContact.ui;

import csheets.ext.Extension;
import csheets.ui.ctrl.UIController;
import csheets.ui.ext.UIExtension;
import javax.swing.JComponent;

/**
 *
 * @author Fernando
 */
public class UIExtensionCompanyContact extends UIExtension {

	/** The icon to display with the extension's name */
//	private Icon icon;

	/** A side bar that provides editing of comments */
	private JComponent sideBar;

	/** The menu of the extension
        * @param extension extension
        * @param uiController ui controller 
        */
	public UIExtensionCompanyContact(Extension extension, UIController uiController) {
		super(extension, uiController);
	}
	
	/**
	 * Returns a side bar that provides editing of comments.
	 * @return a side bar
	 */
        @Override
	public JComponent getSideBar() {
            if (sideBar == null)
		sideBar = new UICompanyContactPanel(uiController);
            return sideBar;
	}	
}

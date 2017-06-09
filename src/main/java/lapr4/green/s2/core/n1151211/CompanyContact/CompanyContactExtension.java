/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.green.s2.core.n1151211.CompanyContact;

import csheets.ext.Extension;
import csheets.ui.ctrl.UIController;
import csheets.ui.ext.UIExtension;
import lapr4.green.s2.core.n1151211.CompanyContact.ui.UIExtensionCompanyContact;

/**
 *
 * @author Fernando
 */
public class CompanyContactExtension extends Extension {

    /**
     * The name of the extension
     */
    public static final String NAME = "CompanyContact";

    /**
     * Creates a new Event extension.
     */
    public CompanyContactExtension() {
        super(NAME);
        
        System.out.println("CompanyContactExtension");
    }

    /**
     * Returns the user interface extension of this extension
     *
     * @param uiController the user interface controller
     * @return a user interface extension, or null if none is provided
     */
    @Override
    public UIExtension getUIExtension(UIController uiController) {
        return new UIExtensionCompanyContact(this, uiController);
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.red.s1.core.n1131106.extensionsmanager;

import csheets.ext.Extension;
import csheets.ui.ctrl.UIController;
import csheets.ui.ext.UIExtension;
import lapr4.red.s1.core.n1131106.extensionsmanager.ui.UIExtensionManager;

/**
 *
 * @author Nuno Filipe 1131106
 */
public class ManagerExtension extends Extension {

    /**
     * The name of the extension
     */
    public static final String NAME = "Extension Manager";

    /**
     * Creates a new Example extension.
     */
    public ManagerExtension() {
        super(NAME);
    }

    /**
     * Returns the user interface extension of this extension
     *
     * @param uiController the user interface controller
     * @return a user interface extension, or null if none is provided
     */
    @Override
    public UIExtension getUIExtension(UIController uiController) {
        return new UIExtensionManager(this, uiController);
    }

}

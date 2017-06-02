/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.red.s1.core.n1131106.extensionsmanager.ui;

import csheets.ext.Extension;
import csheets.ui.ctrl.UIController;
import csheets.ui.ext.UIExtension;
import javax.swing.Icon;
import javax.swing.JComponent;
import javax.swing.JMenu;
import javax.swing.JToolBar;

/**
 *
 * @author Nuno Filipe 1131106
 */
public class UIExtensionManager extends UIExtension {

    /**
     * A side bar that provides the option to enable/disable extensions
     */
    private JComponent sideBar;

    /**
     * The menu of the extension
     *
     * @param extension extension
     * @param uiController ui Controller
     */
    public UIExtensionManager(Extension extension, UIController uiController) {
        super(extension, uiController);

    }

    /**
     * Returns a side bar that provides editing of comments.
     *
     * @return a side bar
     */
    public JComponent getSideBar() {
        if (sideBar == null) {
            sideBar = new ExtensionManagerPanel(uiController);
        }
        return sideBar;
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.blue.s3.core.n1140948.contactstag;

import csheets.ext.Extension;
import csheets.ui.ctrl.UIController;
import csheets.ui.ext.CellDecorator;
import csheets.ui.ext.TableDecorator;
import csheets.ui.ext.UIExtension;
import javax.swing.Icon;
import javax.swing.JComponent;
import javax.swing.JMenu;
import javax.swing.JToolBar;
import lapr4.blue.s3.core.n1140948.contactstag.ui.TagPanel;
import lapr4.white.s1.core.n4567890.contacts.ui.ContactPanel;

/**
 *
 * @author Tiago Silvestre
 */
public class UIExtensionContactsTags extends UIExtension {

    /**
     * The sideBar of the extension
     */
    public static final String NAME = "Contacts Tags";
    private JComponent sideBar;

    public UIExtensionContactsTags(Extension extension, UIController uiController) {
        super(extension, uiController);
    }

    /**
     * Returns an instance of a class that implements JComponent
     *
     * @return a JComponent sideBar
     */
    @Override
    public JComponent getSideBar() {
        if (sideBar == null) {
            sideBar = new TagPanel(uiController);
        }
        return sideBar;
    }

}

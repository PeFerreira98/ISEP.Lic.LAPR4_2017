/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.green.s1.ipc.n1140618.ChatApplication.ui;

import csheets.ext.Extension;
import csheets.ui.ctrl.UIController;
import csheets.ui.ext.CellDecorator;
import csheets.ui.ext.UIExtension;
import javax.swing.Icon;
import javax.swing.JComponent;

/**
 *
 * @author Tiago
 */
public class UIExtensionChat extends UIExtension {

    /**
     * The icon to display with the extension's name
     */
    private Icon icon;
    
    /** A cell decorator that visualizes comments on cells */
    private CellDecorator cellDecorator;
    /**
     * A side bar that provides editing of comments
     */
    private JComponent sideBar;

    public UIExtensionChat(Extension extension, UIController uiController) {
        super(extension, uiController);
    }

    /**
     * Returns a side bar that provides a Chat functionality
     *
     * @return a side bar
     */
    @Override
    public JComponent getSideBar() {
        if (sideBar == null) {
            sideBar = new ChatPanel(uiController);
        }
        return sideBar;
    }

}

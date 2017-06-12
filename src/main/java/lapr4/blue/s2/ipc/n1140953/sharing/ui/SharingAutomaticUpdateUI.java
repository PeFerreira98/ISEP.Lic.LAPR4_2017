/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.blue.s2.ipc.n1140953.sharing.ui;

import csheets.ext.Extension;
import csheets.ui.ctrl.UIController;
import csheets.ui.ext.UIExtension;
import javax.swing.JComponent;

/**
 *
 * @author zero_
 */
public class SharingAutomaticUpdateUI extends UIExtension {

    private SharingAutomaticUpdateUISidebar sideBar;

    public SharingAutomaticUpdateUI(Extension extension, UIController uiController) {
        super(extension, uiController);
    }

    /**
     * Returns a side bar that provides automatic sharing
     *
     * @return a side bar
     */
    @Override
    public JComponent getSideBar() {
        if (sideBar == null) {
            sideBar = new SharingAutomaticUpdateUISidebar(uiController);
        }
        return sideBar;
    }

}

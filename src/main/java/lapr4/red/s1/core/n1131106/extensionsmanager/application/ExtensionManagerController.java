/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.red.s1.core.n1131106.extensionsmanager.application;

import csheets.ui.ctrl.UIController;
import javax.swing.JComponent;
import javax.swing.JToolBar;

/**
 *
 * @author Nuno Filipe 1131106
 */
public class ExtensionManagerController {

    private UIController uiController;

    public ExtensionManagerController(UIController uiController) {
        this.uiController = uiController;
    }

    public void changeState(int i, boolean flag) {
        if (this.uiController.getExtensions()[i].getSideBar() != null) {
            JComponent sidebar = this.uiController.getExtensions()[i].getSideBar();
            for (int j = 0; j < sidebar.getComponents().length; j++) {
                sidebar.getComponents()[j].setEnabled(flag);
                sidebar.getComponents()[j].setVisible(flag);
            }
        }

        if (this.uiController.getExtensions()[i].getCellDecorator() != null) {
            this.uiController.getExtensions()[i].getCellDecorator().setEnabled(flag);
        }

        if (this.uiController.getExtensions()[i].getMenu() != null) {
            this.uiController.getExtensions()[i].getMenu().setEnabled(flag);
        }

        if (this.uiController.getExtensions()[i].getToolBar() != null) {
            JToolBar toolbar = this.uiController.getExtensions()[i].getToolBar();
            if (!toolbar.isEnabled()) {
                toolbar.setVisible(flag);
            }
            for (int j = 0; j < toolbar.getComponents().length; j++) {
                toolbar.getComponents()[j].setEnabled(flag);
                toolbar.getComponents()[j].setVisible(flag);

            }
        }
    }

}

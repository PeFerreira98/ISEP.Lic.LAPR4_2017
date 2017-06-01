/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.red.s1.core.n1131106.extensionsmanager;

import csheets.ext.Extension;
import csheets.ui.ctrl.UIController;
import java.util.ArrayList;
import javax.swing.JCheckBox;
import lapr4.red.s1.core.n1131106.extensionsmanager.application.ExtensionNavigatorController;

/**
 *
 * @author Nuno Filipe 1131106
 */
public class ExtensionNavigatorPanel {
    
    private ExtensionNavigatorController controller;
    private Extension[] extensions = csheets.ext.ExtensionManager.getInstance().getExtensions();
    private ArrayList<JCheckBox> checkBoxes = new ArrayList<JCheckBox>();
    
    public ExtensionNavigatorPanel(UIController uiController) {

    }
    
    
}

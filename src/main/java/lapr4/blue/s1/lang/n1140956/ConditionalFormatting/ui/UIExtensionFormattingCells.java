/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.blue.s1.lang.n1140956.ConditionalFormatting.ui;

import csheets.ext.Extension;
import csheets.ui.ctrl.UIController;
import csheets.ui.ext.UIExtension;
import javax.swing.JComponent;

/**
 *
 * @author Marcos
 */
public class UIExtensionFormattingCells extends UIExtension{
    
    private JComponent sideBar;
    
    public UIExtensionFormattingCells(Extension extension, UIController uiController) {
        super(extension, uiController);
    }
    
    /**
	 * Returns a side bar that provides editing of comments.
	 * @return a side bar
	 */
        @Override
	public JComponent getSideBar() {
            if (sideBar == null)
		sideBar = new FormatingPanel(uiController);
            return sideBar;
	}
    
}

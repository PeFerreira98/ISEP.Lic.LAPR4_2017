/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.blue.s3.core.n1140956.WorkbookSearch.ui;

import csheets.ext.Extension;
import csheets.ui.ctrl.UIController;
import csheets.ui.ext.UIExtension;
import javax.swing.JComponent;
import lapr4.green.s1.ipc.n1970581.findworkbook.ui.SearchWorkbookPanel;

/**
 *
 * @author Marcos
 */
public class UIExtensionSearch  extends UIExtension {
    
    private JComponent sideBar;
    
    public UIExtensionSearch(Extension extension, UIController uiController) {
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
            sideBar = new SearchPanel(uiController);
        }
        return sideBar;
    }
    
}

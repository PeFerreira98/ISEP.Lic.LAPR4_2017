/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.blue.s3.core.n1140953.address.ui;

import csheets.ext.Extension;
import csheets.ui.ctrl.UIController;
import csheets.ui.ext.UIExtension;
import javax.swing.JComponent;

/**
 *
 * @author zero_
 */
public class UIAddressExtension extends UIExtension{
    
    private JComponent sidebar;
    
    public UIAddressExtension(Extension extension, UIController uiController) {
        super(extension, uiController);
    }
    
    @Override
    public JComponent getSideBar() {
        if (sidebar == null) {
            sidebar = new AddressPanel(uiController);
        }
        return sidebar;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.blue.s2.ipc.n1140953.sharing.ui;

import csheets.ext.Extension;
import csheets.ui.ctrl.UIController;
import csheets.ui.ext.UIExtension;

/**
 *
 * @author zero_
 */
public class SharingAutomaticUpdateExtension extends Extension{
    
    public static final String NAME = "Sharing Automatic Updates";
    public static final int VERSION = 1;
    public static final String DESCRIPTION = "Sharing Automatic Update extension from sprint 2.";
    
    public SharingAutomaticUpdateExtension() {
        super(NAME, VERSION, DESCRIPTION);
    }
    
    public UIExtension getUIExtension(UIController uiController){
        return new SharingAutomaticUpdateUI(this, uiController);
    }
    
}

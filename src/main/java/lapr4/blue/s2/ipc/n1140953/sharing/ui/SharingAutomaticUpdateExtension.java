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
    
    public SharingAutomaticUpdateExtension() {
        super(NAME);
    }
    
    public UIExtension getUIExtension(UIController uiController){
        return new SharingAutomaticUpdateUI(this, uiController);
    }
    
}

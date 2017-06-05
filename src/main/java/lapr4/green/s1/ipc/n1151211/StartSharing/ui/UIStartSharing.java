/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.green.s1.ipc.n1151211.StartSharing.ui;

import csheets.ext.Extension;
import csheets.ui.ctrl.UIController;
import csheets.ui.ext.UIExtension;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import javax.swing.Icon;
import javax.swing.JComponent;
import javax.swing.JMenu;
import lapr4.green.s1.ipc.n1151211.StartSharing.StartSharingExtension;
import static lapr4.green.s1.ipc.n1151211.StartSharing.StartSharingExtension.NAME;
import lapr4.green.s1.ipc.n1151211.comm.BroadcastServer;
import lapr4.green.s1.ipc.n1151211.comm.ListenerServer;
import lapr4.green.s1.ipc.n1151211.comm.PeerService;

/**
 *
 * @author Fernando
 */
public class UIStartSharing extends UIExtension {

    private JComponent sideBar;

    public UIStartSharing(Extension extension, UIController uiController) {
        super(extension, uiController);
    }

    public Icon getIcon() {
        return null;
    }

    public JMenu getMenu() {
        return null;
    }

    public JComponent getSideBar() {
        if (sideBar == null) {
            
            sideBar = new ShareCellsPanel(uiController, this);
            
        }
        return sideBar;
    }
    

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.green.s1.ipc.n1151211.StartSharing;

import csheets.ext.Extension;
import csheets.ui.ctrl.UIController;
import csheets.ui.ext.UIExtension;
import lapr4.green.s1.ipc.n1151211.StartSharing.ui.UIStartSharing;
import lapr4.green.s1.ipc.n1151211.comm.BroadcastServer;
import lapr4.green.s1.ipc.n1151211.comm.CommServer2;
import lapr4.green.s1.ipc.n1151211.comm.ListenerServer;
import lapr4.green.s1.ipc.n1151211.comm.PeerService;

/**
 *
 * @author Fernando
 */
public class StartSharingExtension extends Extension {

    private CommServer2 commServer;
    private ListenerServer listenerServer;
    private BroadcastServer broadcastServer;

    /**
     * The name of the extension
     */
    public static final String NAME = "StartSharing";
    /** The version number */
    public static final int VERSION = 1;
    /** The description */
    public static final String DESCRIPTION = "Cell sharing and network communication extension from sprint 1.";

    /**
     * Creates a new Example extension.
     */
    public StartSharingExtension() {
        super(NAME , VERSION, DESCRIPTION);



    }

    /**
     * Returns the user interface extension of this extension
     *
     * @param uiController the user interface controller
     * @return a user interface extension, or null if none is provided
     */
    public UIExtension getUIExtension(UIController uiController) {
        return new UIStartSharing(this, uiController);
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.green.s1.ipc.n1151211.comm;

import csheets.ext.Extension;

/**
 *
 * @author Fernando
 */
public class CommExtension2 extends Extension{
    /** The name of the extension */
    public static final String NAME = "CommServer";
    private int commServerPort = 16100;
    
            
    private CommServer2 commServer;
    private ListenerServer listenerServer;
    private BroadcastServer broadcastServer;
    

    /**
     * Creates a new Example extension.
     */
    public CommExtension2() {
        super(NAME);

        commServer = CommServer2.getServer( commServerPort );
        listenerServer = ListenerServer.getServer( commServerPort, commServer );
        broadcastServer = BroadcastServer.getServer( listenerServer );
    }

}

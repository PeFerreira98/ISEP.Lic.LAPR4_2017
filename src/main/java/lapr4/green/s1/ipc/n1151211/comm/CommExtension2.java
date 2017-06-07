/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.green.s1.ipc.n1151211.comm;

import csheets.ext.Extension;
import csheets.ui.ctrl.UIController;
import csheets.ui.ext.UIExtension;
import lapr4.green.s1.ipc.n1151211.comm.ui.UICommExtension2;

/**
 * It is the extension that initiates the communications service.
 * Respond to ping requests
 * 
 * @author Fernando
 */
public class CommExtension2 extends Extension implements CommHandler2 {

    /**
     * The name of the extension
     */
    public static final String NAME = "CommServer";
    protected static final int PACKET_SIZE_RECEIVE = 1452;
    private String peerId = System.getProperty("user.name");
    private EchoRequest echoRequet;

    /*
     * ethernet = 1500
     * ipv6 = 40 b
     * UDP = 8 b
     * remaining = 1500 - 40 - 8 = 1452
     */
    private int commServerPort = 16100;

    private CommServer2 commServer;
    private ListenerServer listenerServer;
    private BroadcastServer broadcastServer;

    /**
     * Creates a new Example extension.
     */
    public CommExtension2() {
        super(NAME);

        System.out.println("CommExtension2");
        
        commServer = CommServer2.getServer(commServerPort);        
        listenerServer = ListenerServer.getServer(commServerPort, commServer);
        broadcastServer = BroadcastServer.getServer(commServerPort, peerId);
        
        // Configuring the Echo Reply Service
        commServer.addHandler(EchoRequest.class, this);
        broadcastServer.broadcastThisService( NAME, true );
    }

    @Override
    public UIExtension getUIExtension(UIController uiController) {
        return new UICommExtension2(this, uiController);
    }

    @Override
    public void handleDTO(Object dto, SendDto commWorker) {
        EchoRequest echoRequet = (EchoRequest) dto;
        EchoReply echoReply = new EchoReply(peerId, echoRequet);
        commWorker.sendDto(echoReply);
    }

    /**
     *
     * @return
     */
    @Override
    public EchoRequest getLastReceivedDTO() {
        return echoRequet;
    }

}

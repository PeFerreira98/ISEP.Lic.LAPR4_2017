/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.green.s1.ipc.n1151211.comm;

/**
 *
 * @author Fernando
 */
public class BroadcastServer extends Thread{
    private static ListenerServer lstenerServer = null;
    private static BroadcastServer theBroadcastServer = null;


    private BroadcastServer() {

    }
    
    public static BroadcastServer getServer( ListenerServer listenSvr  ) {
        if (theBroadcastServer == null) {
            lstenerServer = listenSvr;
            
            theBroadcastServer = new BroadcastServer();

            theBroadcastServer.start();
        }
        return theBroadcastServer;
    }
    
    
        /**
     * Starts the server
     *
     */
    @Override
    public void run() {
    }

}

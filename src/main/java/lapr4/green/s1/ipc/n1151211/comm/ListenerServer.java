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
public class ListenerServer extends Thread{
    private static int serverPort = 15000;
    private static CommServer2 commSever = null;

    private static ListenerServer theListenerServer = null;


    private ListenerServer() {

    }
    
    public static ListenerServer getServer(  int svtPrt, CommServer2 commSvr  ) {
        if (theListenerServer == null) {
            serverPort = svtPrt;
            commSever = commSvr;
            
            theListenerServer = new ListenerServer();

            theListenerServer.start();

            // To test the server we are going to create a simple handler
            //CommHandler aHandler = new HelloHandler();
            //theCommServer.addHandler(HelloRequestDTO.class, aHandler);
        }
        return theListenerServer;
    }
    
    
        /**
     * Starts the server
     *
     */
    @Override
    public void run() {
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.green.s1.ipc.n1151211.comm;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Listen for connections from other peers to this.
 * For each accepted connection, a thread is created with the function
 * of receiving the objects and invoking a method previously
 * associated with its class.
 * 
 * Each class of objects must meet the following requirements:
 * The objects classes have to implement the Serializable interface
 * Each transmitted class must have a handler registered in ComServer2.
 * This handler has to implement the CommHandler2 interface
 * 
 * Keeps track of the handlers associated with classes that pass through the network.
 * 
 * @author Fernando
 */
public class CommServer2 extends Thread {

    private static int seerverPort = 15000;

    private static CommServer2 theCommServer = null;

    private static Map<Class, CommHandler2> handlers = new HashMap<Class, CommHandler2>();

    private CommServer2() {

    }

    /**
     *  tarts the broadcast server. It is called by the communications extension only once.
     * 
     * @param svtPrt
     * @return
     */
    protected static CommServer2 getServer( int svtPrt) {
        if (theCommServer == null) {
            seerverPort = svtPrt;
            theCommServer = new CommServer2();

            theCommServer.start();
        }
        return theCommServer;
    }
    
    /**
     * Returns the reference to the server instance.
     * 
     * @return
     */
    public  static CommServer2 getServer() {
        return theCommServer;
    }

    /**
     * Registers the association of a class with the hander that will process the objects of this class.
     * 
     * @param dto 
     * @param handler
     */
    public void addHandler(Class dto, CommHandler2 handler) {
        handlers.put(dto, handler);
    }

    protected CommHandler2 getHandler(Class dto) {
        return handlers.get(dto);
    }

    /**
     * Starts the server
     *
     */
    @Override
    public void run() {

        System.out.println("CommServer2");

        ServerSocket svrSock=null;
        
        try {

            // We need to make the server execute an "endless" loop accepting clients...
            svrSock = new ServerSocket(seerverPort);

            while( true ){                
                Socket aSocket = svrSock.accept();

                Logger.getLogger(CommServer2.class.getName()).log(Level.INFO, "New client. Socket={0}", aSocket.getPort());
                
                // Here we should create a CommServerWorker to take care of the communication with the client...
                CommServerWorker2 aWorker = new CommServerWorker2(aSocket, this);

                aWorker.start();
            }

        } catch (IOException ex) {
            Logger.getLogger(CommServer2.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                svrSock.close();
            } catch (IOException ex) {
                Logger.getLogger(CommServer2.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

}


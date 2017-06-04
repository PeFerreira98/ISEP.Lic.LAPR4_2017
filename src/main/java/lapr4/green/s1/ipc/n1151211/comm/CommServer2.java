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


public class CommServer2 extends Thread {

    private static int seerverPort = 15000;

    private static CommServer2 theCommServer = null;

    private static Map<Class, CommHandler2> handlers = new HashMap<Class, CommHandler2>();

    private CommServer2() {

    }

    public static CommServer2 getServer( int svtPrt) {
        if (theCommServer == null) {
            seerverPort = svtPrt;
            theCommServer = new CommServer2();

            theCommServer.start();
        }
        return theCommServer;
    }

    public void addHandler(Class dto, CommHandler2 handler) {
        handlers.put(dto, handler);
    }

    public CommHandler2 getHandler(Class dto) {
        return handlers.get(dto);
    }

    /**
     * Starts the server
     *
     */
    @Override
    public void run() {

        ServerSocket svrSock=null;
        
        try {

            // We need to make the server execute an "endless" loop accepting clients...
            svrSock = new ServerSocket(seerverPort);

            while( true ){
                   System.out.println("CommServer2");
                
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


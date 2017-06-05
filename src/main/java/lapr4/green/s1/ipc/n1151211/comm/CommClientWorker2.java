/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.green.s1.ipc.n1151211.comm;

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Fernando
 */
public class CommClientWorker2  extends Thread implements SendDto{
  
    private final Socket socket;
    private CommServer2 commServer;
    private Peer peer = null;
    private ObjectInputStream inStream = null;
    private ObjectOutputStream outStream = null;
    private boolean status = true;
    
        
    public CommClientWorker2 (Socket theSocket, CommServer2 srvr, Peer pr) {
        socket=theSocket;
        commServer = srvr;
        peer = pr;
        try {
            inStream=new ObjectInputStream(socket.getInputStream());
        } catch (IOException ex) {
            status = false;
            Logger.getLogger(CommClientWorker2.class.getName()).log(Level.SEVERE, null, ex);
        }
        try { 
            outStream= new ObjectOutputStream( socket.getOutputStream() );
        } catch (IOException ex) {
            status = false;
            Logger.getLogger(CommClientWorker2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public synchronized ObjectOutputStream getObjectOutputStream() throws IOException {
        if (outStream!=null)
            return outStream;
        else {
            outStream = new ObjectOutputStream(socket.getOutputStream()); 
            
            return outStream;
        }
    }
    
    public synchronized ObjectInputStream getObjectInputStream() throws IOException {
        if (inStream!=null) 
            return inStream;
        else {
            inStream = new ObjectInputStream(socket.getInputStream());
            
            return inStream;
        }
    }

    /**
     * Will close the socket which will result in the thread being terminated  
     */
    public synchronized void terminateExecution() {
        try {
            if (inStream!=null) {
                inStream.close();
                inStream=null;
            }
            if (outStream!=null) {
                outStream.close();
                outStream=null;
            }
            if (socket!=null) { 
                socket.close();
            }
        } catch (IOException ex) {
            Logger.getLogger(CommClientWorker2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * 
     * @param inDTO inDTO
     */
    private void processIncommingDTO(Object inDTO) {
        CommHandler2 handler= commServer.getHandler(inDTO.getClass());
        
        if (handler!=null) {
            handler.handleDTO(inDTO, this);
        }
    }    
   
    @Override
    public void run() {
        if( inStream != null && outStream != null ){
            status = true;
            // A loop receiving and processing DTOs...
            try {

                for (;;) {
                    Object dto  = inStream.readObject();

                    processIncommingDTO(dto);
                }

            } catch (EOFException ex) {
                Logger.getLogger(CommClientWorker2.class.getName()).log(Level.WARNING, "EOF. The server seems to have closed the connection. Will terminate the worker thread.");            
            } catch (java.net.SocketException ex) {
                Logger.getLogger(CommClientWorker2.class.getName()).log(Level.WARNING, "The server seems to have closed the connection. Will terminate the worker thread.");                        
            } catch (IOException ex) {
                Logger.getLogger(CommClientWorker2.class.getName()).log(Level.WARNING, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(CommClientWorker2.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                try {
                    if (inStream!=null) inStream.close();
                    if (outStream!=null) outStream.close();
                    socket.close();
                } catch (IOException ex) {
                    Logger.getLogger(CommClientWorker2.class.getName()).log(Level.WARNING, null, ex);
                }
            }
        }
        
        
        peer.workerDown();
        status = false;
        System.out.println("CommClientWorker2 exit run");
    }

    @Override
    public boolean sendDto( Object dto ){
        if( status == false ){
            System.out.println("Status off");
            return false;
        }
            
        
        try {
            if( outStream == null )
                System.out.println("outStream == null");
                
            if( dto == null )
                System.out.println("dto == null");
                
            outStream.writeObject(dto);
            return true;
            
        } catch (IOException ex) {
            Logger.getLogger(CommClientWorker2.class.getName()).log(Level.SEVERE, null, ex);
            status = false;
            peer.workerDown();
            return false;
        }
    }
}

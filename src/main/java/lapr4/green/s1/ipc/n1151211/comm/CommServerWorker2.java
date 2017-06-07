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
Function: receives objects sent by peers and invokes the previously
* registered handler for the object class.
* Implements the Sendto interface that allows you to return a response
* in server mode without local user intervention.
* 
 * Requirement:
 * The objects classes have to implement the Serializable interface
 * Each transmitted class must have a handler registered in ComServer2.
 * This handler has to implement the CommHandler2 interface
 * 
 * @author Fernando implements SenDto
 */
public class CommServerWorker2 extends Thread implements SendDto {
    
    private Socket socket;
    private CommServer2 server;
    
    private ObjectInputStream inStream;
    private ObjectOutputStream outStream; 
    
    
    public CommServerWorker2(Socket theSocket, CommServer2 theServer) {
        socket=theSocket;
        server=theServer;
        inStream=null;
        outStream=null;
    }
        
    /**
     * 
     * @param inDTO inDTO
     */
    private void processIncommingDTO(Object inDTO) {
        CommHandler2 handler=server.getHandler(inDTO.getClass());
        if (handler!=null) {

            handler.handleDTO(inDTO, this );

        }

    }
    
    @Override
    public void run() {
        // A loop receiving and processing DTOs...
        try {

            outStream = new ObjectOutputStream(socket.getOutputStream());
            inStream = new ObjectInputStream(socket.getInputStream());

            for (;;) {
                Object dto  = inStream.readObject();
                processIncommingDTO(dto);
            }
            
        } catch (EOFException ex) {
            Logger.getLogger(CommServerWorker2.class.getName()).log(Level.WARNING, "The client seems to have closed the connection. Will terminate the worker thread.");
        } catch (IOException ex) {
            Logger.getLogger(CommServerWorker2.class.getName()).log(Level.WARNING, "Error in the loop of the comm worker thread", ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CommServerWorker2.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (inStream!=null) {
                    inStream.close();
                    inStream=null;
                }
                if (outStream!=null) {
                    outStream.close();
                    outStream=null;
                }
                if (socket!=null){
                    socket.close();
                    socket = null;
                }
            } catch (IOException ex) {
                Logger.getLogger(CommServerWorker2.class.getName()).log(Level.WARNING, null, ex);
            }
        }
        
    }
    
    /**
     * Sends response objects to the peer to which it is attached.
     * The response is done in server mode without requiring a local user intervention.
     * 
     * @param dto
     * @return
     */
    @Override
    public boolean sendDto( Object dto ){
        
        try {
            outStream.writeObject(dto);
            return true;
        } catch (IOException ex) {
            Logger.getLogger(CommClientWorker2.class.getName()).log(Level.WARNING, null, ex);
            return false;
        }
    }
    
    /**
     * It is used to obtain the identification of the peer that sent the object.
     * This information allows this peer to connect to the other peer as a client.
     * The peerId is not correct, it is only to maintain the structure
     * of the internal identification of the peer
     * 
     * 
     * @return
     */
    @Override
    public String peerAddress() {
        return System.getProperty("user.name") + "@" + socket.getInetAddress().toString();
    }
}

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
    
    
    public boolean sendDto( Object dto ){
        
        try {
            outStream.writeObject(dto);
            return true;
        } catch (IOException ex) {
            Logger.getLogger(CommClientWorker2.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
}

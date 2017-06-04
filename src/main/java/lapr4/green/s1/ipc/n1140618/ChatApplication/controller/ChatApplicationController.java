/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.green.s1.ipc.n1140618.ChatApplication.controller;

import csheets.ui.ctrl.UIController;
import java.net.InetAddress;
import lapr4.green.s1.ipc.n1140618.ChatApplication.Message;
import lapr4.green.s1.ipc.n1151211.comm.CommHandler2;
import lapr4.green.s1.ipc.n1151211.comm.CommServer2;
import lapr4.green.s1.ipc.n1151211.comm.SendDto;

/**
 *
 * @author Tiago
 */
public class ChatApplicationController {
    
     private InetAddress ipDest;
    
    private CommServer2 server;
    
    /**
     * Creates a new Controller
     * @param uiController the user interface controller
     */
    public ChatApplicationController(){
        
    }
    
    /**
     * Connect to the server
     */
    public void connectServer(){
        this.server= CommServer2.getServer(1);
    }

    /**
     * verify if the user is connected to the server
     * @return 
     */
    public boolean isOnline() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Get the user that are connected 
     * @return 
     */
    public Iterable<InetAddress> getOnlineUsers() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    /**
     * Especify the user to who the message will be sent, creating a frame for enter text
     * @param oUser 
     */
    public void sendMessage(InetAddress oUser) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * MEthod that will send the message to another user
     * @param text 
     */
    public void messageSend(String text) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

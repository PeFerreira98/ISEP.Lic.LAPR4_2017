/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.green.s1.ipc.n1140618.ChatApplication.controller;

import csheets.ui.ctrl.UIController;
import java.net.InetAddress;
import lapr4.green.s1.ipc.n1140618.ChatApplication.Message;
import lapr4.green.s1.ipc.n1151211.comm.BroadcastServer;
import lapr4.green.s1.ipc.n1151211.comm.CommHandler2;
import lapr4.green.s1.ipc.n1151211.comm.CommServer2;
import lapr4.green.s1.ipc.n1151211.comm.ListenerServer;
import lapr4.green.s1.ipc.n1151211.comm.PeerService;
import lapr4.green.s1.ipc.n1151211.comm.SendDto;

/**
 *
 * @author Tiago
 */
public class ChatApplicationController {
    
    
    private int commServerPort = 16100;
    
    private String peerId = "Teste";
    
    private CommServer2 commServer;
    
    private ListenerServer listenerServer;
    
     private BroadcastServer broadcastServer;
     
     private boolean status=true;
    
    /**
     * Creates a new Controller
     * @param uiController the user interface controller
     */
    public ChatApplicationController(){
        this.commServer= CommServer2.getServer();   
        this.listenerServer = ListenerServer.getServer();
        this.broadcastServer = BroadcastServer.getServer();
        
        broadcastServer.broadcastThisService(new PeerService("Chat", true));
    }
    

    /**
     * verify if the user is connected to the server
     * @return 
     */
    public boolean isOnline() {
       return status;
    }
    
    public void offline(){
        this.status=false;
    }

    /**
     * Get the user that are connected 
     * @return 
     */
    public Iterable<String> getOnlineUsers() {
        return this.listenerServer.getServicePeers(peerId);
    }
    
    /**
     * Especify the user to who the message will be sent, creating a frame for enter text
     * @param oUser 
     */
    public void sendMessage(String oUser) {
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

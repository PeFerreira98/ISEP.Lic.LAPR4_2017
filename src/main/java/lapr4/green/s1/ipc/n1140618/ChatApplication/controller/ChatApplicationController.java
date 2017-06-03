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
    public ChatApplicationController(InetAddress ipDest){
        this.ipDest=ipDest;
    }
    
    /**
     * Connect to the server
     */
    public void connectServer(){
        this.server= CommServer2.getServer(1);
    }
    
    /**
     * Add a class as an Handler
     */
    public void addClassHandler(Class hand){
        
        
    }
    
}

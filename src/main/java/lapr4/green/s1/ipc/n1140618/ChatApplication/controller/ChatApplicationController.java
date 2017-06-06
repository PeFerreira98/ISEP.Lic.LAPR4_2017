/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.green.s1.ipc.n1140618.ChatApplication.controller;

import java.util.Observer;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import lapr4.green.s1.ipc.n1140618.ChatApplication.Message;
import lapr4.green.s1.ipc.n1140618.ChatApplication.ui.ReceiveMessage;
import lapr4.green.s1.ipc.n1140618.ChatApplication.ui.SendMessage;
import lapr4.green.s1.ipc.n1151211.comm.BroadcastServer;
import lapr4.green.s1.ipc.n1151211.comm.CommClientWorker2;
import lapr4.green.s1.ipc.n1151211.comm.CommHandler2;
import lapr4.green.s1.ipc.n1151211.comm.CommServer2;
import lapr4.green.s1.ipc.n1151211.comm.ListenerServer;
import lapr4.green.s1.ipc.n1151211.comm.PeerService;
import lapr4.green.s1.ipc.n1151211.comm.SendDto;

/**
 *
 * @author Tiago
 */
public class ChatApplicationController implements CommHandler2 {

    private String peerId ="Teste";

    private CommServer2 commServer;

    private ListenerServer listenerServer;

    private BroadcastServer broadcastServer;

    private boolean status = true;

    private Message mess;

    /**
     * Creates a new Controller
     */
    public ChatApplicationController() {
        
        if(CommServer2.getServer()==null ){
            JOptionPane.showMessageDialog(null, "Server not initialized!", "Alert!", JOptionPane.INFORMATION_MESSAGE);
            return;
        }else if(ListenerServer.getServer()==null){
            JOptionPane.showMessageDialog(null, "Server not initialized!", "Alert!", JOptionPane.INFORMATION_MESSAGE);
            return;
        }else if(BroadcastServer.getServer()== null){
            JOptionPane.showMessageDialog(null, "Server not initialized!", "Alert!", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        this.commServer = CommServer2.getServer();
        this.listenerServer = ListenerServer.getServer();
        this.broadcastServer = BroadcastServer.getServer();
        
        commServer.addHandler(Message.class, this);
        broadcastServer.broadcastThisService(new PeerService("Chat", true));
    }

    /**
     * verify if the user is connected to the server
     *
     * @return
     */
    public boolean isOnline() {
        return status;
    }

    public void offline() {
        this.status = false;
    }

    /**
     * Get the user that are connected
     *
     * @return
     */
    public Iterable<String> getOnlineUsers(Observer ui) {
        listenerServer.addObserver(ui);
        return this.listenerServer.getServicePeers(peerId);
    }

    /**
     * Especify the user to who the message will be sent, creating a frame for
     * enter text
     *
     * @param oUser
     */
    public void sendMessage(String oUser) {
        this.mess = new Message();
        mess.setIdDest(oUser);
        mess.setIdOrig(peerId);

        SendMessage sm = new SendMessage(this);
    }

    /**
     * Method that will send the message to another user
     *
     * @param text
     */
    public void messageSend(String text) {
        mess.setContent(text);
        
        CommClientWorker2 toPeer = listenerServer.getCommClientWorker2(peerId);
        if(toPeer==null){
            JOptionPane.showMessageDialog(null, "NO COMUNICATION TO PEER!", "Alert!", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        
        if(toPeer.sendDto(mess)==false){
            JOptionPane.showMessageDialog(null, "NO COMUNICATION!", "Alert!", JOptionPane.INFORMATION_MESSAGE);
        }
        
    }

    public String getUser() {
        return this.peerId;
    }

    public Message getMessage() {
        return this.mess;
    }
    
    public ListenerServer getListener(){
        return this.listenerServer;
    }

    @Override
    public void handleDTO(Object dto, SendDto commWorker) {
        this.mess = (Message) dto;
        
        this.peerId=commWorker.peerAddress().split("@")[1];
        
        System.out.println(commWorker.peerAddress());
        
        ReceiveMessage rm = new ReceiveMessage(this);
    }

    @Override
    public Message getLastReceivedDTO() {
        return this.mess;
    }
}

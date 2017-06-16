/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.red.s3.ipc.n1140388.chatrooms.controller;

import lapr4.green.s1.ipc.n1140618.ChatApplication.controller.*;
import java.net.Inet4Address;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Observer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import lapr4.blue.s2.ipc.n1140956.ChatApplication.ChatUser;
import lapr4.blue.s2.ipc.n1140956.ChatApplication.ChatUsersStorage;
import lapr4.blue.s2.ipc.n1140956.ChatApplication.ConversationStorage;
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
import lapr4.red.s3.ipc.n1140388.chatrooms.ChatRoom;
import lapr4.red.s3.ipc.n1140388.chatrooms.ChatRoomDTO;
import lapr4.red.s3.ipc.n1140388.chatrooms.ChatRoomsList;
import lapr4.red.s3.ipc.n1140388.chatrooms.PrivateChatRoom;
import lapr4.red.s3.ipc.n1140388.chatrooms.PublicChatRoom;

/**
 *
 * @author Tiago
 */
public class ChatRoomApplicationController implements CommHandler2 {

    private String peerId = System.getProperty("user.name") + "@";

    private CommServer2 commServer;

    private ListenerServer listenerServer;

    private BroadcastServer broadcastServer;

    private boolean status = true;

    private Message mess;

    private ChatRoomsList roomsList;

    private ChatUsersStorage lst_Users;

    private ConversationStorage lst_Conversations;

    /**
     * Creates a new Controller
     */
    public ChatRoomApplicationController(/*Properties props*/) {

        if (CommServer2.getServer() == null) {
            JOptionPane.showMessageDialog(null, "Server not initialized!", "Alert!", JOptionPane.INFORMATION_MESSAGE);
            return;
        } else if (ListenerServer.getServer() == null) {
            JOptionPane.showMessageDialog(null, "Server not initialized!", "Alert!", JOptionPane.INFORMATION_MESSAGE);
            return;
        } else if (BroadcastServer.getServer() == null) {
            JOptionPane.showMessageDialog(null, "Server not initialized!", "Alert!", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        this.commServer = CommServer2.getServer();
        this.listenerServer = ListenerServer.getServer();
        this.broadcastServer = BroadcastServer.getServer();
        this.lst_Users = new ChatUsersStorage();
        commServer.addHandler(ChatRoomDTO.class, this);
        broadcastServer.broadcastThisService(new PeerService("ChatRoom", true));
        this.roomsList = new ChatRoomsList();

        try {
            this.peerId = System.getProperty("user.name") + "@/" + Inet4Address.getLocalHost().getHostAddress();
        } catch (UnknownHostException ex) {
            Logger.getLogger(ChatRoomApplicationController.class.getName()).log(Level.SEVERE, null, ex);
        }
        ChatUser user = new ChatUser(peerId.split("@")[0] + "@", peerId.split("@")[1]);
        this.lst_Users.addUser(user);
        this.lst_Conversations = new ConversationStorage();

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
    public void sendMessage(ChatRoom room, String message) {
        for(ChatUser oUser :room.participants()){
            this.mess = new Message();
        
        mess.setIdDest(oUser.getInfo());
        mess.setIdOrig(peerId);

        messageSend(message);
        }
    }

    /**
     * Method that will send the message to another user
     *
     * @param text
     */
    public void messageSend(String text) {
        mess.setContent(text);

        CommClientWorker2 toPeer = listenerServer.getCommClientWorker2(mess.getIdDest());
        if (toPeer == null) {
            JOptionPane.showMessageDialog(null, "NO COMUNICATION TO PEER!", "Alert!", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        if (toPeer.sendDto(mess) == false) {
            JOptionPane.showMessageDialog(null, "NO COMUNICATION!", "Alert!", JOptionPane.INFORMATION_MESSAGE);
        } else {
            this.lst_Conversations.addMessage(mess);
        }

    }

    public ChatUser owner() {
        return this.lst_Users.getUserByIP(peerId.split("@")[1]);
    }

    public Message getMessage() {
        return this.mess;
    }

    public ListenerServer getListener() {
        return this.listenerServer;
    }

    public ChatUser getChatUser(String ip) {
        return this.getChatUsersList().getUserByIP(ip);
    }

    /**
     * method to receive the message from others. In this case, the destiny of
     * the message is my ip.
     *
     * @param dto the message
     * @param commWorker
     */
    @Override
    public void handleDTO(Object dto, SendDto commWorker) {
        //this.mess = (Message) dto;
        ChatRoomDTO room = (ChatRoomDTO) dto;
        // String tmp = commWorker.peerAddress();
        // String sourceIP = this.mess.getIdOrig().split("@")[0] + "@" + tmp.split("@")[1];
        // this.mess.setIdOrig(sourceIP);
        // this.lst_Conversations.addMessage(mess);
        if (room.getType().equals("private")) {
            ChatRoom newRoom = new PrivateChatRoom(room.getName(), room.getOwner(), null);
//            newRoom.participants() = room.getParticipants();
            this.roomsList.add(newRoom);
        } 
        if (room.getType().equals("public")) {
            ChatRoom newRoom = new PublicChatRoom(room.getName(), room.getOwner());
            this.roomsList.add(newRoom);
        }
        //    ReceiveMessage rm = new ReceiveMessage(this, sourceIP);
    }

    @Override
    public Message getLastReceivedDTO() {
        return this.mess;
    }

    public void addChatUser(ChatUser cu) {
        this.lst_Users.addUser(cu);
    }

    public ChatUsersStorage getChatUsersList() {
        return this.lst_Users;
    }

    public ArrayList<Message> refreshConversation(ChatUser user) {
        return this.lst_Conversations.getConversationUsersTest(user);
    }

    public HashMap<String, ChatUser> getUsers() {
        return this.lst_Users.getUserList();
    }

    /**
     * Creates a new chat room.
     *
     * @param name
     * @param type
     * @param invites
     * @return
     */
    public ChatRoom createChatRoom(String name, int type, List<ChatUser> invites) {
        if (roomsList.findChatRoomByName(name) != null) {
            return null;
        }

        if (type == 1) {
            return new PublicChatRoom(name, owner());
        } else if (type == 2) {
            return new PrivateChatRoom(name, owner(), invites);
        }

        return null;
    }

    /**
     * Adds the room to the list of rooms.
     *
     * @param cr the chat room to add
     */
    public void startChat(ChatRoom cr) {
        roomsList.add(cr);
        boolean flagfirst = true;
        if (cr instanceof PrivateChatRoom) {
            ChatRoomDTO roomDto = new ChatRoomDTO(cr.name(), cr.owner(), cr.participants(), cr.isOnline(), "private");
            for (ChatUser user : ((PrivateChatRoom) cr).invitations()) {

                roomSend(roomDto, user.getInfo());
            }
        } else {
            ChatRoomDTO roomDto = new ChatRoomDTO(cr.name(), cr.owner(), cr.participants(), cr.isOnline(), "public");
            
            for (ChatUser user : lst_Users.getUserList().values()) {
                if(!flagfirst){
                    roomSend(roomDto, user.getInfo());
                }
                flagfirst = false;
            }

        }

    }

    /**
     * Add the active participant to the room.
     *
     * @param chatRoom the room
     * @return true if the participant was added, false if was not
     */
    public boolean joinChatRoom(ChatRoom chatRoom) {
        
        return chatRoom.addParticipant(owner());
    }

    /**
     * Reject the invitation to the private room
     *
     * @param chatRoom the room
     * @return true if the invatation was rejected, false if was not
     */
    public boolean rejectChatRoom(ChatRoom chatRoom) {
        return ((PrivateChatRoom) chatRoom).invitations().remove(owner());
    }

    public void roomSend(ChatRoomDTO text, String oUser) {
//        room.setContent(text);

        String ipDestination = oUser;

        CommClientWorker2 toPeer = listenerServer.getCommClientWorker2(ipDestination);

        if (toPeer == null) {
            JOptionPane.showMessageDialog(null, "NO COMUNICATION TO PEER!", "Alert!", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        if (toPeer.sendDto(text) == false) {
            JOptionPane.showMessageDialog(null, "NO COMUNICATION!", "Alert!", JOptionPane.INFORMATION_MESSAGE);
        } else {
//            this.lst_Conversations.addChatRoom(room);
        }

    }

    public ChatRoomsList getRoomsList() {
        return roomsList;
    }

}

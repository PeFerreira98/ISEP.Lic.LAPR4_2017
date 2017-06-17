/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.red.s3.ipc.n1140388.chatrooms.controller;

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
import lapr4.green.s1.ipc.n1140618.ChatApplication.Message;
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
import lapr4.red.s3.ipc.n1140388.chatrooms.Notification;
import lapr4.red.s3.ipc.n1140388.chatrooms.PrivateChatRoom;
import lapr4.red.s3.ipc.n1140388.chatrooms.PublicChatRoom;

/**
 *
 * @author Alexandra Ferreira 1140388
 */
public class ChatRoomApplicationController implements CommHandler2 {

    private String peerId = System.getProperty("user.name") + "@";

    private CommServer2 commServer;

    private ListenerServer listenerServer;

    private BroadcastServer broadcastServer;

    private boolean status = true;

    private Message lastMessage;

    private ChatRoomsList roomsList;

    private ChatUsersStorage lst_Users;

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
        // commServer.addHandler(MessageToRoom.class, this);
        broadcastServer.broadcastThisService(new PeerService("ChatRoom", true));
        this.roomsList = new ChatRoomsList();

        try {
            this.peerId = System.getProperty("user.name") + "@/" + Inet4Address.getLocalHost().getHostAddress();
        } catch (UnknownHostException ex) {
            Logger.getLogger(ChatRoomApplicationController.class.getName()).log(Level.SEVERE, null, ex);
        }
        ChatUser user = new ChatUser(peerId.split("@")[0] + "@", peerId.split("@")[1]);
        this.lst_Users.addUser(user);

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
     * @param ui
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
     */
    public void sendMessage(ChatRoom room, String message) {
        if (room instanceof PrivateChatRoom) {
//            boolean flag = true;
            for (ChatUser oUser : room.participants()) {
                if (!oUser.getInfo().equals(peerId)) {
                    Message messToRoom = new Message();
                    messToRoom.setIdDest(oUser.getInfo());
                    messToRoom.setIdOrig(peerId);
                    messToRoom.setContent(message);
                    lastMessage =messToRoom;
                    room.getLst_Conversations().addMessage(lastMessage);
                    ChatRoomDTO roomDto=new ChatRoomDTO(room.name(), room.owner(), room.participants(), room.isOnline(), ((PrivateChatRoom) room).invitations(), "private");
                    roomDto.setConversations(room.getLst_Conversations());
                    messageSend(roomDto, messToRoom);
                }

            }
        }
        if (room instanceof PublicChatRoom) {

            for (ChatUser oUser : room.participants()) {

                if (!oUser.getInfo().equals(peerId)) {
                    Message messToRoom = new Message();
                    messToRoom.setIdDest(oUser.getInfo());
                    messToRoom.setIdOrig(peerId);
                    messToRoom.setContent(message);
                    lastMessage =messToRoom;
                    room.getLst_Conversations().addMessage(lastMessage);
                    ChatRoomDTO roomDto=new ChatRoomDTO(room.name(), room.owner(), room.participants(), room.isOnline(), ((PublicChatRoom) room).invitations(), "public");
                    roomDto.setConversations(room.getLst_Conversations());
                    messageSend(roomDto, messToRoom);
                }

            }
        }

    }

    /**
     * Method that will send the message to another user
     *
     * @param chat
     * @param message
     */
    public void messageSend(ChatRoomDTO chat, Message message) {

        CommClientWorker2 toPeer = listenerServer.getCommClientWorker2(message.getIdDest());
        if (toPeer == null) {
            JOptionPane.showMessageDialog(null, "NO COMUNICATION TO PEER!", "Alert!", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        if (toPeer.sendDto(chat) == false) {
            JOptionPane.showMessageDialog(null, "NO COMUNICATION!", "Alert!", JOptionPane.INFORMATION_MESSAGE);
        } else {
            ChatRoom chatRoom =this.roomsList.findChatRoomByName(chat.getName());
            chatRoom.setLst_Conversations(chat.getConversations());
            Notification.chatInformer().notifyChange(chatRoom);
        }

    }

    public ChatUser owner() {
        return this.lst_Users.getUserByIP(peerId.split("@")[1]);
    }

    public Message getLastMessage() {
        return this.lastMessage;
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

        if (dto instanceof ChatRoomDTO) {
            ChatRoomDTO room = (ChatRoomDTO) dto;
            handleChatRoomDTO(room, commWorker);
        }

//        if (dto instanceof MessageToRoom) {
//
//            MessageToRoom messageDto = (MessageToRoom) dto;
//            Message newMessage = new Message();
//            newMessage.setContent(messageDto.getContent());
//            newMessage.setIdDest(messageDto.getIdDest());
//            newMessage.setIdOrig(messageDto.getIdOrig());
//            handleMessageDTO(newMessage, commWorker);
//
//        }
    }

    public void handleChatRoomDTO(ChatRoomDTO room, SendDto commWorker) {
        if (room.getType().equals("private")) {
            ChatRoom newRoom = new PrivateChatRoom(room.getName(), room.getOwner(), room.getInvitates());
            newRoom.setLst_Conversations(room.getConversations());
            for (ChatUser user : room.getParticipants()) {
                if (!newRoom.participants().contains(user)) {
                    newRoom.participants().add(user);
                }
            }

            if (roomsList.contains(newRoom)) {
                roomsList.getChatRoomsList().set(roomsList.getChatRoomsList().indexOf(newRoom), newRoom);
                Notification.chatInformer().notifyChange(newRoom);
            } else {
                this.roomsList.add(newRoom);
            }
        }

        if (room.getType().equals("public")) {
            ChatRoom newRoom = new PublicChatRoom(room.getName(), room.getOwner(), room.getInvitates());
            newRoom.setLst_Conversations(room.getConversations());
            for (ChatUser user : room.getParticipants()) {
                if (!newRoom.participants().contains(user)) {
                    newRoom.participants().add(user);
                }
            }

            if (roomsList.contains(newRoom)) {
                roomsList.getChatRoomsList().set(roomsList.getChatRoomsList().indexOf(newRoom), newRoom);
                Notification.chatInformer().notifyChange(newRoom);
            } else {
                this.roomsList.add(newRoom);
            }
        }
    }

//    public void handleMessageDTO(Message message, SendDto commWorker) {
//        String tmp = commWorker.peerAddress();
//        String sourceIP = message.getIdOrig().split("@")[0] + "@" + tmp.split("@")[1];
//        message.setIdOrig(sourceIP);
//
//        Notification.chatInformer().notifyChange(message);
//    }

    @Override
    public Message getLastReceivedDTO() {
        return this.lastMessage;
    }

    public void addChatUser(ChatUser cu) {
        this.lst_Users.addUser(cu);
    }

    public ChatUsersStorage getChatUsersList() {
        return this.lst_Users;
    }

    public ArrayList<Message> refreshConversation(ChatRoom room, ChatUser user) {
        return room.getLst_Conversations().getConversationUsersTest(user);
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
            List<ChatUser> users = new ArrayList<>();

            for (ChatUser user : lst_Users.getUserList().values()) {
                users.add(user);
            }

            return new PublicChatRoom(name, owner(), users);
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

        if (cr instanceof PrivateChatRoom) {

            ChatRoomDTO roomDto = new ChatRoomDTO(cr.name(), cr.owner(), cr.participants(), cr.isOnline(), ((PrivateChatRoom) cr).invitations(), "private");
            for (ChatUser user : ((PrivateChatRoom) cr).invitations()) {
                if (!user.equals(cr.owner())) {
                    roomSend(roomDto, user.getInfo());
                }
            }
        } else {
            ChatRoomDTO roomDto = new ChatRoomDTO(cr.name(), cr.owner(), cr.participants(), cr.isOnline(), ((PublicChatRoom) cr).invitations(), "public");

            for (ChatUser user : lst_Users.getUserList().values()) {
                if (!user.equals(cr.owner())) {
                    roomSend(roomDto, user.getInfo());
                }
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
        chatRoom.addParticipant(owner());

        if (chatRoom instanceof PrivateChatRoom) {
            ChatRoomDTO roomDto = new ChatRoomDTO(chatRoom.name(), chatRoom.owner(), chatRoom.participants(), chatRoom.isOnline(), ((PrivateChatRoom) chatRoom).invitations(), "private");

            for (ChatUser user : chatRoom.participants()) {
                if (!user.equals(owner())) {
                    roomSend(roomDto, user.getInfo());
                }
            }

        } else {
            ChatRoomDTO roomDto = new ChatRoomDTO(chatRoom.name(), chatRoom.owner(), chatRoom.participants(), chatRoom.isOnline(), ((PublicChatRoom) chatRoom).invitations(), "public");

            for (ChatUser user : chatRoom.participants()) {
                if (!user.equals(owner())) {
                    roomSend(roomDto, user.getInfo());
                }
            }

        }

        return true;

    }

    /**
     * Reject the invitation to the private room
     *
     * @param chatRoom the room
     * @return true if the invatation was rejected, false if was not
     */
    public boolean rejectChatRoom(ChatRoom chatRoom) {

        if (chatRoom instanceof PrivateChatRoom) {
            return ((PrivateChatRoom) chatRoom).invitations().remove(owner());
        }

        if (chatRoom instanceof PublicChatRoom) {
            return ((PublicChatRoom) chatRoom).invitations().remove(owner());
        }
        return false;

    }

    public void roomSend(ChatRoomDTO room, String oUser) {

        String ipDestination = oUser;

        CommClientWorker2 toPeer = listenerServer.getCommClientWorker2(ipDestination);

        if (toPeer == null) {
            JOptionPane.showMessageDialog(null, "NO COMUNICATION TO PEER!", "Alert!", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        if (toPeer.sendDto(room) == false) {
            JOptionPane.showMessageDialog(null, "NO COMUNICATION!", "Alert!", JOptionPane.INFORMATION_MESSAGE);
        } else {
//            this.lst_Conversations.addChatRoom(room);
        }

    }

    public ChatRoomsList getRoomsList() {
        return roomsList;
    }

}

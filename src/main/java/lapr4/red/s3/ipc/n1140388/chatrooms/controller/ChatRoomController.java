/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.red.s3.ipc.n1140388.chatrooms.controller;

import java.util.List;
import lapr4.blue.s2.ipc.n1140956.ChatApplication.ChatUser;
import lapr4.green.s1.ipc.n1140618.ChatApplication.controller.ChatApplicationController;
import lapr4.red.s3.ipc.n1140388.chatrooms.ChatRoomsList;
import lapr4.red.s3.ipc.n1140388.chatrooms.ChatRoom;
import lapr4.red.s3.ipc.n1140388.chatrooms.PrivateChatRoom;
import lapr4.red.s3.ipc.n1140388.chatrooms.PublicChatRoom;

/**
 *
 * @author Alexandra Ferreira 1140388
 */
public class ChatRoomController {

    private ChatUser owner;
    
    private ChatRoomsList roomsList;

    public ChatRoomController() {
        this.roomsList = new ChatRoomsList();
    }

    public ChatUser owner() {
        owner = new ChatApplicationController().owner();
        return owner;
    }

    public ChatRoom createChatRoom(String name, int type, List<ChatUser> invites) {
        if (type == 1) {
            return new PublicChatRoom(name, owner);
        } else if (type == 2) {
            return new PrivateChatRoom(name, owner, invites);
        }

        return null;
    }
    
    /**
     * @return the chatRoomsList
     */
    public List<ChatRoom> chatRoomsList() {
        return roomsList.chatRoomsList(owner);
    }
    
    /**
     * @return the chatRoomsList
     */
    public List<ChatRoom> publicRooms() {
        return roomsList.publicRoomsWithoutParticipant(owner);
    }
    
    /**
     * @return the chatRoomsList
     */
    public List<ChatRoom> privateRooms() {
        return roomsList.privateRoomsWithInvationWithoutParticipant(owner);
    }
    
    public void startChat(ChatRoom cr) {
        roomsList.add(cr);
    }
    
    public boolean joinChatRoom(ChatRoom chatRoom) {
        return chatRoom.addParticipant(owner);
    }
    
    public boolean rejectChatRoom(ChatRoom chatRoom) {
        return ((PrivateChatRoom) chatRoom).invitations().remove(owner);
    }
}

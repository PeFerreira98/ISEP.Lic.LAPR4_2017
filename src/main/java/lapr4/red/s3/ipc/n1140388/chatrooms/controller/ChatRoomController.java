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

    /**
     * Creates the chat room controller.
     */
    public ChatRoomController() {
        this.roomsList = new ChatRoomsList();
        this.owner = new ChatApplicationController().owner();
    }

    /**
     * Returns the active participant.
     *
     * @return the active participant
     */
    public ChatUser owner() {
        owner = new ChatApplicationController().owner();
        return owner;
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
            return new PublicChatRoom(name, owner);
        } else if (type == 2) {
            return new PrivateChatRoom(name, owner, invites);
        }

        return null;
    }

    /**
     * Returns the list of chat rooms of the active participant.
     *
     * @return the chatRoomsList
     */
    public List<ChatRoom> chatRoomsList() {
        return roomsList.chatRoomsList(owner);
    }

    /**
     * Returns the list of public chat rooms where the active participant is not
     * in it.
     *
     * @return the public chatRoomsList
     */
    public List<ChatRoom> publicRooms() {
        return roomsList.publicRoomsWithoutParticipant(owner);
    }

    /**
     * Returns the list of private chat rooms where the active participant is
     * not in it and has an invatation.
     *
     * @return the private chatRoomsList
     */
    public List<ChatRoom> privateRooms() {
        return roomsList.privateRoomsWithInvationWithoutParticipant(owner);
    }

    /**
     * Adds the room to the list of rooms.
     *
     * @param cr the chat room to add
     */
    public void startChat(ChatRoom cr) {
        roomsList.add(cr);
    }

    /**
     * Add the active participant to the room.
     *
     * @param chatRoom the room
     * @return true if the participant was added, false if was not
     */
    public boolean joinChatRoom(ChatRoom chatRoom) {
        return chatRoom.addParticipant(owner);
    }

    /**
     * Reject the invitation to the private room
     *
     * @param chatRoom the room
     * @return true if the invatation was rejected, false if was not
     */
    public boolean rejectChatRoom(ChatRoom chatRoom) {
        return ((PrivateChatRoom) chatRoom).invitations().remove(owner);
    }
}

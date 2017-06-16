/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.red.s3.ipc.n1140388.chatrooms;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import lapr4.blue.s2.ipc.n1140956.ChatApplication.ChatUser;

/**
 * This class creates a list of chat rooms.
 *
 * @author Alexandra Ferreira 1140388
 */
public class ChatRoomsList implements Serializable {

    private List<ChatRoom> chatRoomsList;

    /**
     * Creates a chat room list.
     */
    public ChatRoomsList() {
        this.chatRoomsList = new ArrayList<>();
    }

    /**
     * Verify if a chat room list contains the specific chat room.
     *
     * @param cr the chat room to verify
     * @return true if contains, false if not
     */
    public boolean contains(ChatRoom cr) {
        return chatRoomsList.contains(cr);
    }

    /**
     * Add a chat room to the chat room list.
     *
     * @param cr the chat room to add
     */
    public void add(ChatRoom cr) {
        if (!contains(cr)) {
            chatRoomsList.add(cr);
            cr.setOnline(true);
        }
    }

    /**
     * Method that return the room by a specific name.
     *
     * @param name the name of the room
     * @return the room with that name, or null if doesnt have it
     */
    public ChatRoom findChatRoomByName(String name) {
        for (ChatRoom cr : chatRoomsList) {
            if (cr.name().equals(name)) {
                return cr;
            }
        }
        return null;
    }

    /**
     * Returns a list of chat rooms of the participant.
     *
     * @param participant the participant chosen
     * @return a list of chat rooms of the participant
     */
    public List<ChatRoom> chatRoomsList(ChatUser participant) {
        List<ChatRoom> list = new ArrayList<>();

        for (ChatRoom cr : chatRoomsList) {
            if (cr.hasParticipant(participant)) {
                list.add(cr);
            }
        }

        return list;
    }

    /**
     * Returns a list of public chat rooms where the participant is not joinned.
     *
     * @param participant the participant chosen
     * @return a list of public chat rooms of the participant
     */
    public List<ChatRoom> publicRoomsWithoutParticipant(ChatUser participant) {
        List<ChatRoom> list = new ArrayList<>();

        for (ChatRoom cr : chatRoomsList) {
            if (cr instanceof PublicChatRoom) {
                if(!cr.hasParticipant(participant)){
                    list.add(cr);
                }
            }
        }

        return list;
    }

    /**
     * Returns a list of private chat rooms where the participant is not joinned
     * and has an invatation.
     *
     * @param participant the participant chosen
     * @return a list of private chat rooms of the participant
     */
    public List<ChatRoom> privateRoomsWithInvationWithoutParticipant(ChatUser participant) {
        List<ChatRoom> list = new ArrayList<>();

        for (ChatRoom cr : chatRoomsList) {
            if (cr instanceof PrivateChatRoom) {
                if(!cr.hasParticipant(participant)){
                    list.add(cr);
                }
            }
        }

        return list;
    }

    public List<ChatRoom> getChatRoomsList() {
        return chatRoomsList;
    }
}

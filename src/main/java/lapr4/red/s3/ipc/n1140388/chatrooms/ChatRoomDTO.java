/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.red.s3.ipc.n1140388.chatrooms;

import java.util.List;
import lapr4.blue.s2.ipc.n1140956.ChatApplication.ChatUser;

/**
 *
 * @author Alexandra Ferreira 1140388
 */
public class ChatRoomDTO {

    private String name;
    private ChatUser owner;
    private List<ChatUser> participants;
    private boolean online;
    private String type;

    public ChatRoomDTO(String name, ChatUser owner, List<ChatUser> participants, boolean online, String type) {
        this.name = name;
        this.owner = owner;
        this.participants = participants;
        this.online = online;
        this.type=type;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the owner
     */
    public ChatUser getOwner() {
        return owner;
    }

    /**
     * @return the participants
     */
    public List<ChatUser> getParticipants() {
        return participants;
    }

    /**
     * @return the online
     */
    public boolean isOnline() {
        return online;
    }

    /**
     * @return the type
     */
    public String getType() {
        return type;
    }
}

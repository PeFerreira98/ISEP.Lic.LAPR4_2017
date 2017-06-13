/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.red.s3.ipc.n1140388.chatrooms;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import lapr4.red.s3.ipc.n1140388.chatrooms.ChatRoom;

/**
 *
 * @author Alexandra Ferreira 1140388
 */
public class ChatRoomsList implements Serializable {

    private List<ChatRoom> chatRoomsList;

    public ChatRoomsList() {
        this.chatRoomsList = new ArrayList<>();
    }

    public boolean contains(ChatRoom cr) {
        return chatRoomsList.contains(cr);
    }

    public void add(ChatRoom cr) {
        if (!contains(cr)) {
            chatRoomsList.add(cr);
            cr.setOnline(true);
        }
    }

    public ChatRoom findChatRoomByName(String name) {
        for (ChatRoom cr : chatRoomsList) {
            if (cr.name().equals(name)) {
                return cr;
            }
        }
        return null;
    }

    /**
     * @return the chatRoomsList
     */
    public List<ChatRoom> chatRoomsList() {
        return chatRoomsList;
    }
}

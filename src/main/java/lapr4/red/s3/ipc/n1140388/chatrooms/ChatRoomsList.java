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

    public List<ChatRoom> chatRoomsList(ChatUser participant) {
        List<ChatRoom> list = new ArrayList<>();

        for (ChatRoom cr : chatRoomsList) {
            if (cr.hasParticipant(participant)) {
                list.add(cr);
            }
        }

        return list;
    }

    public List<ChatRoom> publicRoomsWithoutParticipant(ChatUser participant) {
        List<ChatRoom> list = new ArrayList<>();

        for (ChatRoom cr : chatRoomsList) {
            if (cr instanceof PublicChatRoom) {
                if (!cr.hasParticipant(participant)) {
                    list.add(cr);
                }
            }
        }

        return list;
    }

    public List<ChatRoom> privateRoomsWithInvationWithoutParticipant(ChatUser participant) {
        List<ChatRoom> list = new ArrayList<>();

        for (ChatRoom cr : chatRoomsList) {
            if (cr instanceof PrivateChatRoom) {
                if (!cr.hasParticipant(participant)
                        && ((PrivateChatRoom) cr).invitations().contains(participant)) {
                    list.add(cr);
                }
            }
        }

        return list;
    }
}

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
public class PublicChatRoom extends ChatRoom implements Serializable {

    private List<ChatUser> inviteAll;
    
    /**
     * Creates a public chat room
     *
     * @param name the name of the chat
     * @param owner the owner of the chat
     */
    public PublicChatRoom(String name, ChatUser owner) {
        super(name, owner);
        this.inviteAll = new ArrayList<>();
    }
    
    public PublicChatRoom(String name, ChatUser owner, List<ChatUser> inv) {
        super(name, owner);
        this.inviteAll = inv;
    }

    /**
     * Returns the invations.
     *
     * @return the invations
     */
    public List<ChatUser> invitations() {
        return inviteAll;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.blue.s2.ipc.n1140956.ChatApplication;

import java.util.ArrayList;
import lapr4.green.s1.ipc.n1140618.ChatApplication.Message;

/**
 *
 * @author Marcos
 */
public class Conversation {
    
    ChatUser chatUser1;
    ChatUser chatUser2;
    ArrayList<Message> conversation;

    public Conversation(ChatUser chatUser1, ChatUser chatUser2) {
        this.chatUser1 = chatUser1;
        this.chatUser2 = chatUser2;
    }
    
    
    
}
